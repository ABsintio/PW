import java.io.*;
// import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MySQLServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
            "<html>\n" +
            "<head>\n" +
            "<title> Test di MySQL </title>\n" +
            "</head>\n" +
            "<body>\n" + 
            "<h1>Questa pagina è prodotta da <br>" +
            "una servlet che esegue una query al DB</h1><br>\n" + 
            "<table border=\"1\" cellpadding=\"5\" cellspacing=\"0\" width=\"400\">\n"
        );
        String connectionURL = "jdbc:mysql://127.0.0.1:3306/esempio";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Caricamento dinamico della classe e registrazione del driver 
            // presso il driver manager
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
            // Connect to database
            connection = DriverManager.getConnection(connectionURL, "root", "$Fioretto$1998");
            // Create statement to query database
            statement = connection.createStatement();
            // query database
            String query_autori_libri = "";
            query_autori_libri.concat(
                "select Nome, Cognome, Titolo\n" +
                "from Autori a, Libro l, Autore_Libro al\n" +
                "where a.AutoreID = al.AutoreID and l.LibroID = al.LibroID"
            );
            resultSet = statement.executeQuery(query_autori_libri);
            // Process query result
            StringBuffer results = new StringBuffer();
            ResultSetMetaData metaData = resultSet.getMetaData();
            results.append("<tr>");
            for (int i = 1; i <= 3; i++) {
                results.append("<td><b>" + metaData.getColumnName(i) + "</b></td>");
            }
            results.append("</tr>");

            while (resultSet.next()) {
                results.append("<tr>");
                for (int i = 1; i <= 3; i++) {
                    results.append("<td>" + resultSet.getObject(i) + "</td>");
                }
                results.append("</tr>");
            }
            out.println(results.toString());

        } catch (SQLException e) {
            System.err.println("SQL Problem: " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error: " + e.getErrorCode());
            System.exit(1);
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        out.println("</table></body></html>");
    }
}