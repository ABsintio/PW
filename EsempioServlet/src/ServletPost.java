import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/ServletPOST")
public class ServletPost extends HttpServlet {

    private HashMap<String, String> db;

    @Override
    public void init(){
        this.db = new HashMap<String, String>();
        this.db.put("admin", "admin");
        this.db.put("impiegato1", "impiegato");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String password = request.getParameter("pswd");
        String carica = request.getParameter("carica");

        out.println("<html><head><title>Home Page</title></head><body>");

        if (!this.db.containsKey(uname) || !this.db.get(uname).equals(password)) {
            out.println("<h1 color=\"red\">Username o password errati</h1>");
            out.println("<a href=\"/EsempioServlet/src/html/post.html\">Torna alla pagina di login</a>");
        } else {
            if (carica.equals("admin")) {
                if (uname.equals("admin") && password.equals("admin")) {
                    out.println("<h1>Benvenuto Amministratore!</h1>");
                } else if (uname.equals("impiegato1") && password.equals("impiegato")) {
                    out.println("<h1>Informazioni sull'impiegato1</h1>");
                    out.println(
                        "<table>\n" +
                        "<tr>\n" +
                        "<td><b>Nome: </b></td><td>Mario</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td><b>Congome: </b></td><td>Rossi</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td><b>Nato a: </b></td><td>Roma, 1975</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td><b>Anni di servizio: </b></td><td>20</td>\n" +
                        "</tr>\n" +
                        "<tr>\n" +
                        "<td><b>Comportamento: </b></td><td>Eccellente</td>\n" +
                        "</tr></table>\n"
                    );
                }
            } else {
                if (uname.equals("admin")) {
                    out.println("<h1 color=\"red\">Non puoi accedere da amministratore</h1>");
                    out.println("<a href=\"/EsempioServlet/src/html/post.html\">Torna alla pagina di login</a>");
                } else if (uname.equals("impiegato1") && password.equals("impiegato")) {
                    out.println("<h1>Benvenuto nella sua Home Page, Sig. Mario Rossi!</h1>");
                }
            }
        }
        out.println("</body></html>");
        out.close();
    }
}
