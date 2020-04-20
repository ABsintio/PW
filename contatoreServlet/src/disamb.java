import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class disamb extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

        String url_servlet = request.getParameter("servlet");

        this.checkForCookie(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url_servlet);
        dispatcher.forward(request, response);

    }

    private void checkForCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            response.addCookie(new Cookie("n.accessi", "1"));
        } else {
            Cookie cookie = cookies[cookies.length - 1];
            cookie.setValue(String.valueOf(Integer.parseInt(cookie.getValue()) + 1));
            response.addCookie(cookie);
        }
    }

}