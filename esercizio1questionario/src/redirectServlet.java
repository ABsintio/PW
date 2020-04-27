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

        String cookiename = "password" + String.valueOf(this.access);
        
        HttpSession session = req.getSession(true);
        session.setAttribute(cookiename, req.getParameter("password"));
        req.setAttribute("nuovoattributo", session.getId());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(
            "/ResponseServlet"
        );
        dispatcher.forward(req, resp);

    }

}
