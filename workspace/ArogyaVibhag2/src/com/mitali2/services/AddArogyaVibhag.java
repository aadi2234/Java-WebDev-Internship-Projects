package com.mitali2.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitali.connectdb.ConnectDB;

/**
 * Servlet implementation class AddArogyaVibhag
 */
public class AddArogyaVibhag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArogyaVibhag() {
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
		
		String Name,Email,Mobile,Password,Village,District;
		Name = request.getParameter("Name");
		Email = request.getParameter("Email");
		Mobile = request.getParameter("Mobile");
		Password = request.getParameter("Password");
		Village = request.getParameter("Village");
		District = request.getParameter("District");
		
		try
		{
			Connection con = ConnectDB.connect();
			System.out.println("Connection established");
			PreparedStatement ps1 = con.prepareStatement("insert into add_arogya_vibhag values(?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2, Name);
			ps1.setString(3, Email);
			ps1.setString(4, Mobile);
			ps1.setString(5, Password);
			ps1.setString(6, Village);
			ps1.setString(7, District);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("ViewArogyaVibhag.jsp");
			}
			else
			{
				response.sendRedirect("NewArogyaVibhag.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
