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
        Cookie cookies[] = request.getCookies();
        String iceCream = request.getParameter("select");
        Cookie cookieIceCream = new Cookie(iceCream, this.url.get(iceCream));
        response.addCookie(cookieIceCream);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Gelati</title></head><body>");
        out.println("<h1>Preferenza selezionata</h1>");
        out.println("<p><strong>" + iceCream + "</strong></p>");
        out.println("<p>Questo link potrebbe interessarti " +
                    "<a href=" + this.url.get(iceCream) + ">" + this.url.get(iceCream) + "</a></p>");
        out.println("<a href=\"/EsempioServlet/src/html/cookie.html\">Seleziona altre preferenze</a>");
        if (cookies.length > 0 && cookies != null) {
            out.println("<h3>Le tue preferenze recenti sono state: </h3><p><table>");
            for (Cookie c: cookies) {
                out.println("<tr>");
                out.println("<td><strong>" + c.getName() + "</strong></td>");
                out.println("<td><a href=" + c.getValue() + ">" + c.getValue() + "</td>");
                out.println("</tr>");
            }
            out.println("</table></p>");
        }
        out.close();
    }
}
