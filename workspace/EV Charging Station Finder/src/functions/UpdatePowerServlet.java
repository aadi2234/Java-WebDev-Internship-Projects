package functions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.MysqlCon;

/**
 * Servlet implementation class UpdatePowerServlet
 */
public class UpdatePowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePowerServlet() {
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
		String sname=request.getParameter("sname");
		int upower=Integer.parseInt(request.getParameter("upower"));
		int upwr=0;
		try {
			 Connection con = MysqlCon.getCon();
	            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM register_cs WHERE sname=?");
	            ps1.setString(1, sname);
	            ResultSet rs = ps1.executeQuery();
	            while(rs.next()) 
	            {
	            	upwr=rs.getInt("power");
	            } 
	            upwr=upwr-upower;
	            PreparedStatement ps2 = con.prepareStatement("update register_cs set power=? WHERE sname=?");
	            ps2.setInt(1, upwr);
	            ps2.setString(2, sname);
	            int i=ps2.executeUpdate();
	            if(i>0)
	            {
	            	//Power Updated Successfully
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('Power Updated Successfully..!!');");
	                out.println("window.location.href = 'ViewStation.jsp';");
	                out.println("</script>");
	            }
	            else
	            {
	            	//Failed to Update Power 
	            	 response.setContentType("text/html");
		             PrintWriter out = response.getWriter();
		             out.println("<script type=\"text/javascript\">");
		             out.println("alert('Failed to Update Power ..!!');");
		             out.println("window.location.href = 'updatepower.html';");
		             out.println("</script>");
	            	response.sendRedirect("updatepower.html");
	            }
	        } 
			catch (Exception e) 
			{
	            e.printStackTrace();
	        }
		
	}

}
