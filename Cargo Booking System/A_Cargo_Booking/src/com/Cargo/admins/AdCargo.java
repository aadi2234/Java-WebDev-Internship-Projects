package com.Cargo.admins;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cargo.project.ConnectDB;

/**
 * Servlet implementation class AdCargo
 */
public class AdCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdCargo() {
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
		
		String date,cargotype,name,pricing,arrival,departure;
		date=request.getParameter("date");
		cargotype=request.getParameter("cargotype");
		name=request.getParameter("name");
		pricing=request.getParameter("pricing");
		arrival=request.getParameter("arrival");
		departure=request.getParameter("departure");
		
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps = con.prepareStatement("select * from addcargo where name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                System.err.println("User Already Exists...!!");
            	response.sendRedirect("AddCargo.html");
            } 
            else
            {
            	PreparedStatement ps1 = con.prepareStatement("insert into addcargo values(?,?,?,?,?,?,?)");
            	ps1.setInt(1,0);
            	ps1.setString(2, date);
            	ps1.setString(3, cargotype);
            	ps1.setString(4, name);
            	ps1.setString(5, pricing);
            	ps1.setString(6, arrival);
            	ps1.setString(7, departure);
            	int i = ps1.executeUpdate();
            	if(i>0)
            	{
            		System.out.println("Data inserted successfully..!");
            		response.sendRedirect("viewCargo.jsp");
            	}
            	else
            	{
            		System.out.println("Failed...!!");
            		response.sendRedirect("AddCargo.html");
            	}
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
