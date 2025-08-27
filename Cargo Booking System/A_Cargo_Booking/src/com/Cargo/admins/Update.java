package com.Cargo.admins;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cargo.project.ConnectDB;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		
		String Sr_no = request.getParameter("Sr_no");
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String cargotype = request.getParameter("cargotype");
		String pricing = request.getParameter("pricing");
		String arrival = request.getParameter("arrival");
		String departure = request.getParameter("departure");
		
		String cdate = null,ccargotype = null, cname= null, cpricing = null,carrival = null ,cdeparture = null;
		
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("select * from addcargo where Sr_no=?");
			ps1.setString(1, Sr_no);
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				cdate = rs.getString("date");
				ccargotype = rs.getString("cargotype");
				cname = rs.getString("name");
				cpricing = rs.getString("pricing");
				carrival = rs.getString("arrival");
				cdeparture = rs.getString("departure");
			}
			
		
			PreparedStatement ps2 = con.prepareStatement("update addcargo set date=?, cargotype=?, name=?, pricing=?, arrival=?, departure=? where Sr_no=?");
			ps2.setString(1, date);
			ps2.setString(2, cargotype);
			ps2.setString(3, name);
			ps2.setString(4, pricing);
			ps2.setString(5, arrival);
			ps2.setString(6, departure);
			ps2.setString(7, Sr_no);
			int i = ps2.executeUpdate();
			if(i>0)
			{
				System.out.println(i+" row updated");
				response.sendRedirect("viewCargo.jsp");
			}
			else
			{
				System.out.println("FAILED..!!");
				response.sendRedirect("UpdateCargo.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
		


}
