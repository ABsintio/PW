import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;

/**
 * Servlet per la gesitone della sessione con parametri
 * hidden nei form
 */
public class HiddenFormParameter extends HttpServlet {
    private HashMap<String, String> info;

    @Override
    public void init(){
        info = new HashMap<String, String>();
        info.put("nome", null);
        info.put("cognome", null);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Informazioni</title></head><body>");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        this.info.replace("nome", nome);
        this.info.replace("cognome", cognome);
        if (this.info.get("nome") == null) {
            out.println("<h1>Inserisci il nome</h1>");
            out.println("<form action=\"/EsempioServlet/HFP\" method=\"GET\">");
            out.println("<input type=\"text\" name=\"nome\" placeholder=\"Scrivi qui\">");
            out.println("<input type=\"submit\" value=\"Inserisci il nome\">");
            out.println("</form></body></html>");
            out.close();
        } else if (this.info.get("cognome") == null) {
            out.println("<h1>Inserisci il cognome</h1>");
            out.println("<form action=\"/EsempioServlet/HFP\" method=\"GET\">");
            out.println("<input type=\"hidden\" value=" + this.info.get("nome") + " name=\"nome\">");
            out.println("<input type=\"text\" name=\"cognome\" placeholder=\"Scrivi qui\">");
            out.println("<input type=\"submit\" value=\"Inserisci il cognome\">");
            out.println("</form></body></html>");
            out.close();
        } else {
            out.println("<h1>Benvenuto " + nome + " " + cognome + "</h1>");
            out.println("</form></body></html>");
            out.close();
        }
    }
}
