import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class responseServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public responseServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
        
        String password = req.getParameter("password");
        String id = req.getParameter("name");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println(
            "<html>\n" +
            "<head>\n" +
            "<title>Pagina di riposta</title>\n" + 
            "</head>\n" + 
            "<body>\n" +
            "<style>\n" +
            "* {text-align: center;}" +
            "</style>\n" +
            "<h1>Password Registrata</h1>\n" +
            "<p><strong>Name ID: </strong>" + id + "</p>\n" +
            "<p><strong>Password: </strong>" + password + "</p>\n" +
            "<a href=\"index.html\">Clicca qui per registrare nuova password</a>\n" +
            "</body>\n" + 
            "</html>"
        );

        out.close();

    }

}