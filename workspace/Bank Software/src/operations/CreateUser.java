package operations;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.MysqlCon;


/**
 * Servlet implementation class CreateUser
 */
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String accno,aname,amob,abal;
		accno = request.getParameter("accno");
		aname = request.getParameter("aname");
		amob = request.getParameter("amob");
		abal = request.getParameter("abal");
		
		try
		{
			Connection con = MysqlCon.getCon();
			PreparedStatement ps1 = con.prepareStatement("insert into accounts values(?,?,?,?)");
			ps1.setString(1, accno);
			ps1.setString(2, aname);
			ps1.setString(3, amob);
			ps1.setString(4, abal);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("viewAccount.jsp");
			}
			else
			{
				response.sendRedirect("createAccount.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
