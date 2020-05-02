import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

/**
 * pannelloAmministratore
 */
public class pannelloAmministratore extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int naccessi;

    public pannelloAmministratore(){}

    @Override
    public void init(){
        this.naccessi = 0;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        String username = request.getParameter("userid");
        String password = request.getParameter("password");

        if (username.equals("admin")) {
            if (password.equals("admin")) {
                
                // Creo una sessione, se non esiste, per l'utente
                // con i permessi di amministratore
                HttpSession session = request.getSession(true);

                String date = (new Date()).toString();

                // Aggiungo un attributo di sessione solo nel caso
                // in cui l'utente sia "utente amministratore"
                session.setAttribute("lastAccess", date);

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                out.println(
                    "<h1>Pannello Amministratore</h1>\n" +
                    "<div>\n" +
                    "<span>\n" +
                    "<label>Numero accessi: </label>" +
                    "<label id=\"naccessi\">" + (++this.naccessi) + "</label>\n" +
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
                    "<span>\n" +
                    "<a href=\"index.html\">Quit</a>\n" +
                    "</span>\n"
                );
                
                // Ottengo il dispatcher per la redirezione interna e 
                // l'inclusione del contenuto html in più.
                // Includo l'"header" pannello amministratore alla risposta
                this.getServletContext().getRequestDispatcher("/HomeServlet")
                    .include(request, response);
            } else {
                response.sendRedirect("index.html");
            }
        } else if (username.equals("generic")) {
            if (password.equals("generic")) {

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
            response.sendRedirect("index.html");
        }
        
    }
    
}