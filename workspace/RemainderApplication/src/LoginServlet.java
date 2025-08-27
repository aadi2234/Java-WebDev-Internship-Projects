import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Establish a database connection
            Connection con=MysqlCon.getCon();

            // Prepare the SQL statement
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // User exists, check the password
                String storedPassword = resultSet.getString("password");
                if (storedPassword.equals(password)) {
                    // Passwords match, login successful
                    response.sendRedirect("addReminder.html");
                } else {
                    // Passwords do not match, login failed
                    response.sendRedirect("index.html?error=true");
                }
            } else {
                // User does not exist, login failed
                response.sendRedirect("index.html?error=true");
            }

            // Close the database resources
            resultSet.close();
            statement.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database errors
        }
    }
}
