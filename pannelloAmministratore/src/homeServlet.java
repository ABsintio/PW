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
            "<style>\n" +
            "* {text-align: center;}\n" +
            "label {margin-right: 10px;}\n"+
            "label#naccessi {margin-right: 0px;}\n"+
            "label#date {margin-right: 0px;}\n"+
            "h1 {margin-bottom: 30px;}\n" +
            "div {\n" +
            "display: inline;\n" +
            "position: relative; top: 50%;\n" +
            "border-bottom: 2px solid #800080;\n" +
            "border-top: 2px solid #800080;\n" +
            "padding-bottom: 20px; padding-top: 20px;\n" +
            "}\n" + 
            "span {\n" +
            "padding-left: 35px;\n" +
            "padding-right: 35px;\n"+
            "border-right: 1px solid #800080;\n" +
            "border-left: 1px solid #800080;\n" +
            "}\n" +
            "</style>\n" +
            "<h1>Welcome " + nome + "</h1>\n" +
            "</body>\n" +
            "</html>"
        );

        out.close();

    }

}