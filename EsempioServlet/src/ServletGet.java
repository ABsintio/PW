import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletGet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Prendiamo i parametri inseriti nel form
        String name = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        // Scriviamo il contenuto nell'out.
        out.println(
            "<html>\n" +
            "<head><title>Informazioni</title></head>\n"+
            "<body>\n" +
            "<b>Nome: </b> " + name + "<br>\n" +
            "<b>Cognome: </b>" + cognome + "\n" +
            "</body></html>"
        );
        out.close();
    }
}
