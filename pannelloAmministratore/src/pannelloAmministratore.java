import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

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

                // Aggiungo un attributo di sessione solo nel caso
                // in cui l'utente sia "utente amministratore"
                session.setAttribute("naccessi", ++this.naccessi);

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                out.println(
                    "<h2>Pannello Amministratore</h2>\n"
                );
                
                // Ottengo il dispatcher per la redirezione interna e 
                // l'inclusione del contenuto html in più.
                // Includo l'"header" pannello amministratore alla risposta
                this.getServletContext().getRequestDispatcher("/HomeServlet")
                    .include(request, response);
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
        }
        
    }
    
}