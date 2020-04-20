import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class servlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -5247501020978681895L;

    public servlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        String operation = request.getParameter("destinazione");

        switch (operation) {
            case "destinazione1":
                this.gotoPage("/Dest", request, response);
                break;
            
            case "destinazione2":
                this.gotoPage("/src/html/dest2.jsp", request, response);
                break;
        }

    }

    private void gotoPage(String address, HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}