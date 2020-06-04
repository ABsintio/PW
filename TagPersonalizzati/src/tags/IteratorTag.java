package tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import java.io.IOException;
import java.util.*;

public class IteratorTag extends BodyTagSupport {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Collection<?> collection;
    private Iterator<?> iterator;

    public void setCollection(Collection<?> c) {
        this.collection = c;
    }

    @Override
    public int doStartTag() throws JspException {
        return this.collection.size() > 0 ? EVAL_BODY_BUFFERED : SKIP_BODY;
    }

    @Override
    public void doInitBody() throws JspException {
        this.iterator = collection.iterator();
        pageContext.setAttribute("item", this.iterator.next());
    }

    @Override
    public int doAfterBody() throws JspException {
        if (this.iterator.hasNext()) {
            pageContext.setAttribute("item", this.iterator.next());
            return EVAL_BODY_AGAIN;
        } else {
            try {
                getBodyContent().writeOut(getPreviousOut());
            } catch (IOException ioException) {
                throw new JspException(ioException.getMessage());
            }
            return SKIP_BODY;
        }
    }
    
}