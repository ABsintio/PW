import javax.servlet.http.*;
import javax.servlet.*;
import java.util.HashMap;
import java.io.*;

public class ServletCookie extends HttpServlet {
    private HashMap<String, String> url;

    @Override
    public void init(){
        this.url = new HashMap<String, String>();
        this.url.put("Cioccolato", "https://en.wikipedia.org/wiki/Chocolate_ice_cream");
        this.url.put("Vaniglia", "https://en.wikipedia.org/wiki/Vanilla_ice_cream");
        this.url.put("Crema", "https://ricette.giallozafferano.it/Gelato-alla-crema.html");
        this.url.put("Pistacchio", "https://www.misya.info/ricetta/gelato-al-pistacchio.htm");
        this.url.put("Nocciola", "https://www.misya.info/ricetta/gelato-alla-nocciola.htm");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Gelati</title></head><body>");
        String iceCream = request.getParameter("select");
        out.println("<h1>Preferenza selezionata</h1>");
        out.println("<p><strong>" + iceCream + "</strong></p>");
        out.println("<p>Questo link potrebbe interessarti " + this.url.get(iceCream) + "</p>");
        Cookie cookieIceCream = new Cookie(iceCream, this.url.get(iceCream));
        response.addCookie(cookieIceCream);
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0) {
            out.println("<p>Le tue preferenze recenti sono state: </p><table>");
            for (Cookie c: cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            out.println("<h4 color=\"red\">Nessuna preferenza recente</h4>");
        }
        out.println("<a href=\"/EsempioServlet/src/html/cookie.html\">Seleziona altre preferenze</a>");
        out.close();
    }
}
