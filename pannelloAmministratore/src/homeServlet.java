import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * homeServlet
 */
public class homeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public homeServlet(){}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        String nome = request.getParameter("userid");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
            "<html>\n" + 
            "<head>\n" +
            "<title>Home Page</title>\n" + 
            "</head>\n" + 
            "<body>\n" +
            "<h1>Welcome " + nome + "</h1>\n" +
            "</body>\n" +
            "</html>"
        );

        out.close();

    }

}