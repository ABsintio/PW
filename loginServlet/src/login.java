import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class login extends HttpServlet {

    private String index;
    private String username;
    private String password;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public login(){}

    @Override
    public void init(){
        this.index = "../index.html";
        this.username = "admin";
        this.password = "12345";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter html = response.getWriter();

        if (user.equals(this.username) && pass.equals(this.password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", user);
            session.setAttribute("lastpage", "");

            html.println(
                "<html>\n" +
                "<head>\n" +
                "<title>Home Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<style>\n" +
                "h1 { text-align: center; }\n" +
                "div { text-align: center; left: 50%; top: 50%}\n" +
                "</style>\n" +
                "<h1>Login effettuato con successo</h1>\n" +
                "<form action=\"\" method=\"GET\">\n" +
                "<div class=\"web\">\n" +
                "<label>Seleziona la pagina che vuoi visitare<label>\n" +
                "<select>\n" +
                "<option value=\"https://google.com\">Google</option>\n" +
                "<option value=\"https://zorinos.com/start/\">Zorin Start Page<option>\n" +
                "<option value=\"/loginServlet/LoginPage\">Pagina di Login</option>\n" +
                "</select>\n" +
                "</div>\n" +
                "<div class=\"submit\">\n" +
                "<input type=\"submit\" value=\"Send\">\n" +
                "</div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>"
            );

        } else {

            // Parsa la pagina index.html e restituisce quella
            html.println(Parser.parse(this.index));
        }

        html.close();
    }

}