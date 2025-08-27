package com.mitali.connectdb;
	
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB 
{
   public static Connection con=null;
   public static Connection connect()
   {
	   if(con==null)
	   {
		   try
		   {
			   Class.forName("com.mysql.jdbc.Driver");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ehealth_db","root","");
			   System.out.println("Connection established");
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
	   return con;    
   }
}