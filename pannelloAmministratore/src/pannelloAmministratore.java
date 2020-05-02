import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;

/**
 * pannelloAmministratore
 */
public class pannelloAmministratore extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HashMap<String, String> admin;
    private HashMap<String, String> generic;
    private HashMap<String, HashMap<String, String>> database;

    public pannelloAmministratore(){}

    @Override
    public void init(){

        // Inizializzo l'utente admin
        this.admin = new HashMap<>();
        this.admin.put("userID", "admin");
        this.admin.put("password", "admin");
        this.admin.put("role", "amministratore");
        this.admin.put("accessi", "0");

        // Inizializzo l'utente generic
        this.generic = new HashMap<>();
        this.generic.put("userID", "generic");
        this.generic.put("password", "generic");
        this.generic.put("role", "generico");

        // Inizializzo il "database" con i primi utenti standard
        this.database = new HashMap<>();
        this.database.put("admin", this.admin);
        this.database.put("generic", this.generic);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        String username = request.getParameter("UserID");
        String password = request.getParameter("password");
        String role = request.getParameter("ruolo");

        // Se è stato inserito uno username che non è presente 
        // nel database allora eseguiamo una sottospecie di 
        // registrazione di un nuovo utente. 
        if (! this.database.containsKey(username)){
            HashMap<String, String> data = new HashMap<>();
            data.put("userID", username);
            data.put("password", password);
            data.put("role", role);

            if (role.equals("amministratore")) data.put("accessi", "0");

            this.database.put(username, data);
        }

        // Controllo le credenziali principali ossia la password in quanto 
        // se lo username non esiste lo interpretiamo come una specie 
        // di registrazione di nuovi utenti, quindi l'utente inserito non
        // potrà mai non esistere. La cosa che potrà essere diversa è la 
        // password. Ovviamente se l'utente già esiste non verrà sovrascritto.
        // Controlliamo anche che il ruolo dato come autenticazione sia lo
        // stesso salvato in fare di "registrazione".
        if (this.database.get(username).get("password").equals(password) &&
            this.database.get(username).get("role").equals(role)) {

            // Controlliamo adesso il ruolo computare azioni diverse
            if (role.equals("amministratore")) {

                // Creo una sessione, se non esiste, per l'utente
                // con i permessi di amministratore
                HttpSession session = request.getSession(true);

                String date = (new Date()).toString();

                this.database.get(username).put(
                    "accessi",
                    session.isNew() ? "1" : String.valueOf(Integer.parseInt(
                        this.database.get(username).get("accessi")
                    ) + 1)
                );

                // Aggiungo un attributo di sessione solo nel caso
                // in cui l'utente sia "utente amministratore"
                session.setAttribute("naccessi", this.database.get(username).get("accessi"));

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                out.println(
                    "<h1>Pannello Amministratore</h1>\n" +
                    "<div>\n" +
                    "<span>\n" +
                    "<label>Numero accessi: </label>" +
                    "<label id=\"naccessi\">" + 
                    (String) session.getAttribute("naccessi") + 
                    "</label>\n" +
                    "</span>\n" + 
                    "<span>\n" +
                    "<label id=\"date\">" + date + "</label>\n" + 
                    "</span>\n" +
                    "<span>\n" +
                    "<label>Choose a Link</label><select onchange=\"location = this.value\">\n" +
                    "<option value=\"https://www.google.com\">Google</option>\n" +
                    "<option value=\"https://www.youtube.com\">Youtube</option>\n" +
                    "</select>\n" + 
                    "</span>\n" +
                    "</div>\n"
                );
                
                // Ottengo il dispatcher per la redirezione interna e 
                // l'inclusione del contenuto html in più.
                // Includo l'"header" pannello amministratore alla risposta
                this.getServletContext().getRequestDispatcher("/HomeServlet")
                    .include(request, response);
            } else {

                // Se il ruolo non è amministratore allora è generico
                // Non aggiungo alcun attributo
                // E non ci deve essere alcun'operazione di inclusione
                // dinamica di nuovo contenuto in quanto l'utente è
                // del tipo "utente generico"

                // Creo una sessione, se non esiste, anche per 
                // l'utente generico.
                HttpSession session = request.getSession(true);

                this.getServletContext().getRequestDispatcher("/HomeServlet")
                    .forward(request, response);


            }
        } else {

            // Se abbiamo errori sull'autenticazione si rimanda all'utente
            // alla pagina di login
            getServletContext().getRequestDispatcher("/index.html").forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        String exit = (String) request.getAttribute("exit");

        if (exit != null) {

            // Questo doGET dovrà gestire le richieste di quit provienienti dalla pagina 
            // principale a cui l'utente amministratore o meno ha avuto accesso
            // Invaliderà la sessione in corso, se esistente.
            HttpSession session = request.getSession(false);
            if (session != null) session.invalidate();
        }

        // Ridirige il tutto alla pagina di login tramite una redirezione esterna
        // tanto stiamo con richieste GET
        response.sendRedirect("index.html");

    }
    
}