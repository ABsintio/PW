import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class errorServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public errorServlet(){}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
        
        String error = (String) request.getAttribute("error");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
            "<html>\n" + 
            "<head>\n" +
            "<title>Error Page</title>\n" +
            "</head>\n" + 
            "<body>\n" +
            "<h1>Credenziali Errate</h1>"
        );

        if (error.equals("password")){
            out.println(
                "<h2>La password " +
                request.getParameter("password") + 
                " non è valida</h2>\n"
            );
        } else if (error.equals("role")) {
            out.println(
                "<h2>L'utente " +
                request.getParameter("userid") + 
                " non è associato al ruolo: " +
                request.getParameter("ruolo") + 
                "</h2>\n"
            );
        } else {
            out.println(
                "<h2>L'utente " + 
                request.getParameter("userid") +
                " non esiste nel sistema</h2>\n"
            );
        }

        out.println(
            "<a href=\"index.html\">Per tornare alla pagina di Login</a>\n" +
            "</body>\n" + 
            "</html>"
        );

        out.close();

    } 

}