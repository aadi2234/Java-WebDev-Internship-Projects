package com.mitali2.services;
import com.mitali.connectdb.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitali.connectdb.ConnectDB;

/**
 * Servlet implementation class AddCase
 */
public class AddCase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCase() {
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
		
		String PatientName,Age,Gender,Address,Mobile,Symptom1,Symptom2,Symptom3;
		PatientName = request.getParameter("PatientName");
		Age = request.getParameter("Age");
		Gender = request.getParameter("Gender");
		Address = request.getParameter("Address");
		Mobile = request.getParameter("Mobile");
		Symptom1 = request.getParameter("Symptom1");
		Symptom2 = request.getParameter("Symptom2");
		Symptom3 = request.getParameter("Symptom3");
		
		try
		{
			Connection con = ConnectDB.connect();
			System.out.println("Connection established");
			PreparedStatement ps1 = con.prepareStatement("insert into arogya_vibhag values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,0);
			ps1.setString(2, PatientName);
			ps1.setString(3, Age);
			ps1.setString(4, Gender);
			ps1.setString(5, Address);
			ps1.setString(6, Mobile);
			ps1.setString(7, Symptom1);
			ps1.setString(8, Symptom2);
			ps1.setString(9, Symptom3);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("ViewCase2.jsp");
			}
			else
			{
				response.sendRedirect("NewCase2.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}