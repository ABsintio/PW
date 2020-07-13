import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class ConnectionPoolServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private ConnectionPool connectionPool;

    private int initialConnections(){return 10;}

    private int maxConnections(){return 50;}

    public void init() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/esempio?serverTimezone=UTC";
        String username = "root";
        String password = "$Fioretto$1998";
        try {
            this.connectionPool = new ConnectionPool(
                driver, url, username, password,
                this.initialConnections(), this.maxConnections(), true
            );
        } catch (SQLException sqle) {
            System.err.println("Error making pool: " + sqle);
            this.getServletContext().log("Error making pool: " + sqle);
            this.connectionPool = null;
        }
    }

    public void destroy(){
        this.connectionPool.closeAllConnections();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        StringBuffer table = new StringBuffer();
        try {
            String query = "SELECT Nome, Cognome FROM Autori;";
            Connection conn = this.connectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            this.connectionPool.free(conn);
            table.append("<table>\n<tr>");
            for (int i = 1; i <= 3; i++) {
                table.append("<td><b>" + metaData.getColumnName(i) + "</b></td>\n");
            }
            table.append("</tr>\n");
            while (rs.next()) {
                table.append("<tr>\n");
                table.append("<td>" + rs.getString("Nome") + "</td>\n");
                table.append("<td>" + rs.getString("Cognome") + "</td>\n");
            }
        } catch (Exception e) {
            table.append("Erorr: " + e.getMessage());
        }
        response.setContentType("text/html");
        String title = "Test Pool Connection";
        PrintWriter out = response.getWriter();
        out.println(
            "<html>\n" + 
            "<head>\n" +
            "<title>" + title + "</title>\n" + 
            "<meta http-equiv=\"Pragma\" content=\"no-cache\">\n" +
            "<meta http-equiv=\"Expires=-1\" content=\"-1\">\n" + 
            "</head>\n" +
            "<body bgcolor=\"#FDF5E6\">\n" + 
            "<center>\n" + table + "\n" +
            "</center>\n" + 
            "</body>\n" + 
            "</html>"
        );
    }

}