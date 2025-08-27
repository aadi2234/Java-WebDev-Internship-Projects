import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReminderServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // Database connection details

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    try {
      // Establish a database connection
      Connection con=MysqlCon.getCon();

      // Prepare the SQL statement
      String sql = "INSERT INTO reminders (title, description) VALUES (?, ?)";
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, title);
      statement.setString(2, description);

      // Execute the statement
      statement.executeUpdate();

      // Close the database resources
      statement.close();
      con.close();

      // Display a success message
      PrintWriter out = response.getWriter();
      out.println("Reminder added successfully!");
    } catch (SQLException e) {
      e.printStackTrace();
      // Handle any database errors
    }
  }
}
