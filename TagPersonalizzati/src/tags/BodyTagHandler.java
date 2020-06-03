package tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class BodyTagHandler extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String bgColor;  // Un attributo obbligatorio
    private String border = null;

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    @Override
    public int doStartTag() throws JspException{
        try {
            JspWriter out = pageContext.getOut();
            out.println( "<table bgcolor=\"" + this.bgColor + "\"");
            if (this.border != null) {
                out.println(" border=\"" + this.border + "\"");
            }
            out.println(">");
        } catch (IOException ioException) {
            throw new JspException(ioException.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.println("</table>");
        } catch (IOException ioException) {
            throw new JspException(ioException.getMessage());
        }
        return EVAL_PAGE;
    }

}