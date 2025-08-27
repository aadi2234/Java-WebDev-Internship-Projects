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
 * Servlet implementation class AddSpecialistDoctor
 */
public class AddSpecialistDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpecialistDoctor() {
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
		
		String Name,Email,Mobile,Password,City,Specialization,Diseased_Treat,AddComment,AddPrescription;
		Name = request.getParameter("Name");
		Email = request.getParameter("Email");
		Mobile = request.getParameter("Mobile");
		Password = request.getParameter("Password");
		City = request.getParameter("City");
		Specialization = request.getParameter("Specialization");
		Diseased_Treat = request.getParameter("Diseased_Treat");
		AddComment = null;
		AddPrescription = null;
		try
		{
			Connection con = ConnectDB.connect();
			System.out.println("Connection established");
			PreparedStatement ps1 = con.prepareStatement("insert into add_specialist_doctor values(?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2, Name);
			ps1.setString(3, Email);
			ps1.setString(4, Mobile);
			ps1.setString(5, Password);
			ps1.setString(6, City);
			ps1.setString(7, Specialization);
			ps1.setString(8, Diseased_Treat);
			ps1.setString(9, AddComment);
			ps1.setString(10, AddPrescription);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("ViewSpecialistDoctor.jsp");
			}
			else
			{
				response.sendRedirect("NewSpecialistDoctor.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
