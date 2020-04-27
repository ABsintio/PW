import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class redirectServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        req.setAttribute("name", session.getId());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(
            "/esercizio1questionario/servletRisposta"
        );
        dispatcher.forward(req, resp);

    }

}
