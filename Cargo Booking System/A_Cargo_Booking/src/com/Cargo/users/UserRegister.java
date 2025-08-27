package com.Cargo.users;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Cargo.project.ConnectDB;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
		
		String name,email,username,password;
		name=request.getParameter("name");
		email=request.getParameter("email");
		username=request.getParameter("username");
		password=request.getParameter("password");
		
		try
		{
			Connection con = ConnectDB.connect();
			PreparedStatement ps1 = con.prepareStatement("select * from user where email=?");
            ps1.setString(1, email);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) 
            {
                System.err.println("User Already Exists...!!");
            	response.sendRedirect("Register.html");
            }
            else
            {
				PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2, email);
				ps.setString(3, username);
				ps.setString(4, password);
				int i = ps.executeUpdate();
				
				if(i>0)
				{
					System.out.println("Register Successfully...!!");
					response.sendRedirect("UserLogin.html");
				}
				else
				{
					System.out.println("Failed...!!");
					response.sendRedirect("Register.html");
				}
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
