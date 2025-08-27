package operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.MysqlCon;


/**
 * Servlet implementation class WithdrawMoney
 */
public class WithdrawMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawMoney() {
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
		
		String accno = request.getParameter("accno");
		int amt = Integer.parseInt(request.getParameter("amt"));
		int abal=0;
		
		try
		{
			Connection con = MysqlCon.getCon();
			PreparedStatement ps1 = con.prepareStatement("select * from accounts where accno=?");
			ps1.setString(1, accno);
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				abal = rs.getInt("bal");
			}
			
			abal=abal-amt;
			PreparedStatement ps2 = con.prepareStatement("update accounts set bal=? where accno=?");
			ps2.setInt(1, abal);
			ps2.setString(2, accno);
			int i = ps2.executeUpdate();
			if(i>0)
			{
				System.out.println(i+" row updated");
				response.sendRedirect("viewAccount.jsp");
			}
			else
			{
				System.out.println("FAILED..!!");
				response.sendRedirect("withdraw.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
