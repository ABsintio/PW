package tags;

import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;

public class FormRecordTag extends TagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String value = "";

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        String v = request.getParameter(this.value);
        try {
            pageContext.getOut().print(v == null ? "" : v);
        } catch (IOException ioException) {
            throw new JspException(ioException.getMessage());
        }
        return SKIP_BODY;
    }
    
}