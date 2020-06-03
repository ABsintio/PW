package tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class ShowErrorsTag extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public int doStartTag() throws JspException {
        String error = (String) pageContext.getSession().getAttribute("login-error");
        if (error != null) {
            try {
                pageContext.getOut().print(error);
            } catch (IOException ioException) {
                throw new JspException(ioException.getMessage());
            }
        }
        return SKIP_BODY;
    }
    
}