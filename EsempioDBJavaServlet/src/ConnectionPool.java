import java.sql.*;
import java.util.*;

public class ConnectionPool implements Runnable {
    private String driver, url, username, password;
    private int maxConnections;
    private boolean waitIfBusy;
    private Vector<Connection> availableConnections, busyConnections;
    private boolean connectionPending = false;

    public ConnectionPool(String dr, String url, String uname, String pswd, 
                          int iConn, int mConn, boolean waitIfBusy) 
    throws SQLException {
        this.driver = dr;
        this.url = url;
        this.username = uname;
        this.password = pswd;
        this.maxConnections = mConn;
        this.waitIfBusy = waitIfBusy;
        if (iConn > mConn) iConn = mConn;
        this.availableConnections = new Vector<Connection>(iConn);
        this.busyConnections = new Vector<Connection>();
        for (int i = 0; i < iConn; i++) {
            this.availableConnections.addElement(this.makeNewConnection());
        }
    }

    /**
     * Questo metodo crea esplicitamente una nuova connessione. Viene invocato in 
     * fg (foreground) all'inizializzazione e in bg (background) in esecuzione (run).
     */
    private Connection makeNewConnection() throws SQLException {
        try {
            Class.forName(this.driver);
            Connection conn = (Connection) DriverManager.getConnection(
                this.url, 
                this.username, 
                this.password
            );
            return conn;
        } catch (ClassNotFoundException cnfe) {
            throw new SQLException("Can't find class for driver: " + this.driver);
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        if (!this.availableConnections.isEmpty()) {
            Connection exsistingConnection = (Connection) this.availableConnections.lastElement();
            int lastIndex = this.availableConnections.size() - 1;
            this.availableConnections.remove(lastIndex);
            // Se la connessione pescata dalla lista di quelle disponibili
            // è bloccata, la rimuoviamo e ritentiamo il procedimento. Inoltre
            // svegliamo i thread che stavano aspettando per una connessione dal
            // momento che è stato raggiunto il limite imposto da maxConnection.
            if (exsistingConnection.isClosed()) {
                notifyAll();
                return this.getConnection();
            } else {
                this.busyConnections.addElement(exsistingConnection);
                return exsistingConnection;
            }
        } else { // vettore delle connessioni disponibili è vuoto
            if ((this.totalConnections() < this.maxConnections) && !this.connectionPending) {
                this.makeBgConnection();
            } else if (!this.waitIfBusy) {
                throw new SQLException("Connection limit reached");
            }
            try {
                wait();
            } catch (InterruptedException ie) {ie.printStackTrace();}
            return this.getConnection();
        }
    }

    public synchronized int totalConnections() {
        return this.availableConnections.size() + this.busyConnections.size();
    }

    public void makeBgConnection() {
        this.connectionPending = true;
        try {
            Thread conThread = new Thread(this);
            conThread.start();
        } catch (OutOfMemoryError oome) {oome.printStackTrace();}
    }

    public synchronized void free(Connection con) {
        this.busyConnections.removeElement(con);
        this.availableConnections.addElement(con);
        notifyAll();
    }

    private void closeConnection(Vector<Connection> connections) {
        try {
            for (int i = 0; i < connections.size(); i++) {
                Connection c = (Connection) connections.elementAt(i);
                if (!c.isClosed()) {c.close();}
            }
        } catch (SQLException sqle) {
            // Ignore errors; garbage collect anyhow
        }
    }

    public synchronized void closeAllConnections() {
        this.closeConnection(this.availableConnections);
        this.availableConnections = new Vector<Connection>();
        this.closeConnection(this.busyConnections);
        this.busyConnections = new Vector<Connection>();
    }

    @Override
    public void run() {
        try {
            Connection conn = this.makeNewConnection();
            synchronized (this) {
                this.availableConnections.addElement(conn);
                this.connectionPending = false;
                notifyAll();
            }
        } catch (Exception e) { // SQLExceptio o OutOfMemoryError
            // Rinuncia alla nuova connessione e attende che una di quelle 
            // esistente si liberi.
        }
    }

    public synchronized String toString(){
        String info = "ConnectionPool(" + url + ", " + username + ")" +
                      ", available: " + this.availableConnections.size() +
                      ", busy: " + this.busyConnections.size() + 
                      ", max: " + this.maxConnections;
        return info;
    }
}