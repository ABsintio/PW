package tags;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class AttributeTag extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String firstName = "";

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            JspWriter out = pageContext.getOut();
            out.println("Hello " + this.firstName + 
                        ", <br>Welcome to JSP Libraries!");
        } catch (IOException ioException) {
            throw new JspException(ioException.getMessage());
        }

        return SKIP_BODY;
    }
    
}