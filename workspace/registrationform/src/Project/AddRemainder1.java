package Project;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRemainder
 */
public class AddRemainder1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRemainder1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("userDashboard.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        Connection con = MysqlCon.getCon();
        User user=new User();
        String title1=request.getParameter("title");
        String desc=request.getParameter("description");
        try {
            PreparedStatement ps3 = con.prepareStatement("INSERT INTO task_tbl (id,rtitle,rdesc,uemail) VALUES (?,?,?,?)");
            ps3.setInt(1, 0);
            ps3.setString(2, title1);
            ps3.setString(3, desc);
            ps3.setString(4, user.getEmail());

            int i = ps3.executeUpdate();
            if (i > 0) 
            {
                System.out.println("Reminder added successfully!");
                response.sendRedirect("userDashboard.html");
                
            } 
            else 
            {
                System.out.println("Failed to add reminder.");
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}

