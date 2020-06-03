import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import beans.LoginDB;
import beans.User;

public class AuthenticateServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private LoginDB loginDB;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.loginDB = new LoginDB();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
    throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String uname = req.getParameter("userName");
        String pwd = req.getParameter("password");
        User user = this.loginDB.getUser(uname, pwd);

        if (user != null) {
            String protectedPage = (String) session.getAttribute("protected-page");
            session.removeAttribute("login-page");
            session.removeAttribute("error-page");
            session.removeAttribute("protected-page");
            session.removeAttribute("login-error");
            session.setAttribute("user", user);
            resp.sendRedirect(resp.encodeURL(protectedPage));
        } else {
            String loginPage = (String) session.getAttribute("login-page");
            String errorPage = (String) session.getAttribute("error-page");
            String forwardTo = errorPage != null ? errorPage : loginPage;
            session.setAttribute("login-error", "Username and pass are not valid");

            // la richiesta viene rediretta alla pagina di errore se è stata
            // configurata, altrimenti alla pagina di login
            this.getServletContext().getRequestDispatcher(
                resp.encodeURL(forwardTo)
            ).forward(req, resp);
        }
    }
    
}