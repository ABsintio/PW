import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class dest1 extends HttpServlet {

    private String string;

    @Override
    public void init(){
        this.string = "ciao";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
            "<html>"+ 
            "<head>"+
            "<title>Titolo A caso</title>"+
            "</head>"+
            "<body>"+
            "<h1>" + this.string + "</h1>"+
            "</body>"+
            "</html>"
        );

        out.close();
    }

}