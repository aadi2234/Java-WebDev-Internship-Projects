package Project;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUserA extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginUserA() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getParameter("action");

        switch (action) {
            case "AddRemainder1":
                response.sendRedirect("addremainder.html");
                break;
            case "viewRemainder":
                response.sendRedirect("viewRemainder.jsp");
                break;
            default:
                response.sendRedirect("menu.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	User user=new User();
        Connection con = MysqlCon.getCon();
        String emailid = request.getParameter("email");
        String password = request.getParameter("pass");

        try {
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user_tbl WHERE uemail=? AND upass=?");
            ps1.setString(1, emailid);
            ps1.setString(2, password);
            ResultSet rs = ps1.executeQuery();
            if(rs.next()) {
                System.out.println("Login Successful!");
                user.setEmail("email");
                response.sendRedirect("menu.jsp");
            } else {
                System.out.println("Failed to Login.");
                System.out.println("Please try again.");
                response.sendRedirect("registeruser.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
