package com.Cargo.admins;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cargo.project.ConnectDB;

/**
 * Servlet implementation class AdLogin
 */
public class AdLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdLogin() {
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
		
		String username,password;
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("Select * from Admin where username=? and password=?");
			ps1.setString(1, username);
			ps1.setString(2, password);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				System.out.println("Login Successfull...!!");
				response.sendRedirect("AddCargo.html");
			}
			else
			{
				System.out.println("Failed...!!");
				response.sendRedirect("AdminLogin.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
