package tags;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class WelcomeTagHandler extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Method called to begin tag processing
    @Override
    public int doStartTag() throws JspException {
        // attempt tag processing
        try {
            // obtain JspWriter to output content
            JspWriter out = pageContext.getOut();
            out.println("Messaggio proveniente dal tag");
        } catch (IOException ioException) {
            throw new JspException(ioException.getMessage());
        }

        return SKIP_BODY;
    }
}