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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
        
        String password = req.getParameter("password");
        String naccessi = req.getParameter("nuovoattributo");

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
            "<p><strong>Accesso numero: </strong>" + naccessi + "</p>\n" +
            "<p><strong>Password: </strong>" + password + "</p>\n"
        );

        Cookie[] cookies = req.getCookies();

        out.println(
            "<h2>Password precedentemente registrate</h2>\n"
        );

        for (Cookie c : cookies) {
            out.println(
                "<p><strong>" + c.getName() + ":</strong>" + c.getValue() + "</p>\n"
            );
        }

        out.println(
            "<a href=\"index.html\">Clicca qui per registrare nuova password</a>\n" +
            "</body>\n" + 
            "</html>"
        );

        out.close();

    }

}