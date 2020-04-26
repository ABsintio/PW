import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

public class a extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public a(){}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        Cookie contatore = cookies[cookies.length - 1];
        Integer number = Integer.parseInt(contatore.getValue());

        response.setContentType("text/html");
        PrintWriter html = response.getWriter();

        html.println(
            "<html>\n" +
            "<head>\n" +
            "<title>Pagina Servlet A</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<style>\n" +
            "h1 { text-align: center; }\n" +
            "h2 { text-align: center; }\n" +
            "* { text-align: center; }\n" +
            "</style>\n" +
            "<h1>Benvenuto nella Servlet A</h1>\n" +
            "<h2>Numero di accesso alla Servlet A o B: " + number + "</h2>\n" +
            "<a href=\"index.html\">Cliccare qui per tornare alla pagina di disambiguazione.</a>" +
            "</body>\n" +
            "</html>"
        );

    }

}
