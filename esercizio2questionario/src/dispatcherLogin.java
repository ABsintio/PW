import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;

/**
 * dispatcherLogin
 */
public class dispatcherLogin extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String userfile = "./webapps/esercizio2questionario/src/json/user.json";
    private int naccessi; // Gli accessi dell'amministratore

    public dispatcherLogin(){}

    public void init() {
        this.naccessi = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        String name = request.getParameter("userid");
        String role = request.getParameter("ruolo");
        String password = request.getParameter("password");

        HashMap<String, HashMap<String, String>> json = (
            HashMap<String, HashMap<String, String>>
        ) ReadJSON.parseJSON(this.userfile);

        String error = "";

        if (json.containsKey(name)) {
            HashMap<String, String> innerJson = json.get(name);

            /**
             * Come prima cosa controllo il ruolo in quanto anche
             * se la password è giusta l'utente potrebbe non essere
             * associato al ruolo inserito e di conseguenza non 
             * sarebbe comunque autorizzato ad entrare.
             */
            if (innerJson.get("role").equals(role)){
                
                // Controllo se le password coincidono
                if (innerJson.get("password").equals(password)) {

                    HttpSession session = request.getSession(true);

                    // Redirigo internamente la richiesta a due servlet
                    // diverse in base al ruolo che l'utente ha nel sistema
                    if (role.equals("Amministratore")) {
                        session.setAttribute("naccessi", String.valueOf(
                            ++this.naccessi
                        ));
                        // TODO: Redirigi richiesta a pannelloAmministratore
                    } else {
                        // TODO: Redirigi richiesta a homeServlet
                    }
                } else {
                    error = "password";
                }

            } else {
                error = "role";
            }

        } else {
            error = "username";
        }

        if (! error.equals("")) {
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/ErrorServlet")
                .forward(request, response);
        }

    }
}