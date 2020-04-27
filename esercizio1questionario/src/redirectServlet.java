import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class redirectServlet extends HttpServlet {

    private int access = 0;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {

        this.access++;

        String password = req.getParameter("password");

        String cookiename = "password" + String.valueOf(this.access);
        resp.addCookie(new Cookie(cookiename, password));

        resp.setContentType("text/html");
        
        req.setAttribute("nuovoattributo", String.valueOf(this.access));
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(
            "/ResponseServlet"
        );
        dispatcher.forward(req, resp);

    }

}
