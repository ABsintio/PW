import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;


public class gotoURL extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public gotoURL(){}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String url = request.getParameter("url");

        HttpSession session = request.getSession(true);
        session.setAttribute("lasturl", url);

        if (url == "index.html") {
            session.invalidate();
        }

        response.sendRedirect(url);

    }

}