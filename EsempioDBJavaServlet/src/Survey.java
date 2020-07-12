import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.text.*;

public class Survey extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection conn;
    private PreparedStatement updateVote, totalVotes, results;

    // Setup database connection and prepare SQL statements
    @Override
    public void init(ServletConfig config) throws ServletException {
        String connectionURL = "jdbc:mysql://localhost:3306/animalsurvey?serverTimezone=UTC";
        String username = "root";
        String password = "$Fioretto$1998";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(connectionURL, username, password);
            this.updateVote = this.conn.prepareStatement(
                "UPDATE surveyresult\n" + 
                "SET votes = votes + 1\n" + 
                "WHERE id = ?"
            );
            this.totalVotes = this.conn.prepareStatement(
                "SELECT sum(votes) FROM surveyresult;"
            );
            this.results = this.conn.prepareStatement(
                "SELECT * FROM surveyresult sr ORDER BY sr.id;"
            );
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        out.println("<html><head>");
        int value = Integer.parseInt(request.getParameter("animal"));
        try {   
            this.updateVote.setInt(1, value);
            this.updateVote.executeUpdate();
            ResultSet totalRs = this.totalVotes.executeQuery();
            totalRs.next();
            int total = totalRs.getInt(1);
            ResultSet resultsRs = this.results.executeQuery();
            out.println("<title>Thank you!</title></head><body>");
            out.println("<p>Thank you for participating.</p>");
            out.println("<br />Results:</p>");
            int votes;
            while (resultsRs.next()) {
                out.println(resultsRs.getString(1) + ": ");
                votes = resultsRs.getInt(3);
                out.println(twoDigits.format((double) votes / total * 100));
                out.println("% reponses: " + votes);
            }
            resultsRs.close();
            out.println("Total responses: " + total + "</body></html>");
            out.close();
        } catch (SQLException e){
            out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        try {
            this.updateVote.close();
            this.totalVotes.close();
            this.results.close();
            this.conn.close();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
    
}