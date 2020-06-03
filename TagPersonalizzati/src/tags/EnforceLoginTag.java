package tags;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class EnforceLoginTag extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String loginPage;
    private String errorPage;

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }

    /**
     * Permette di decidere se permettere la visualizzazione
     * del resto della pagina.
     */
    @Override
    public int doEndTag() throws JspException {
        HttpSession session = pageContext.getSession();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        // usa una var protectedPage per memorizzare la pagina 
        // richiesta cui fare ritorno dopo l'eventuale redirezione
        // verso la login page.
        String protectedPage = request.getRequestURI();
        if (session.getAttribute("user") == null) {
            session.setAttribute("login-page", this.loginPage);
            session.setAttribute("error-page", this.errorPage);
            session.setAttribute("protected-page", protectedPage);
            try {
                pageContext.forward(this.loginPage);
                return SKIP_PAGE;
            } catch (Exception exception) {
                throw new JspException(exception.getMessage());
            }
        }

        // eseguito se l'attributo user viene trovato nella sessione
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        this.loginPage = null;
        this.errorPage = null;
    }
    
}