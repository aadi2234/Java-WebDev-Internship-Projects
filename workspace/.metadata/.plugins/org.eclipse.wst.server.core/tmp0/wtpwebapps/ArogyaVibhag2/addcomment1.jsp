<%@page import="com.mitali.connectdb.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment Section</title>
</head>
<body>

<%
String addComment = request.getParameter("addComment");
int id=Integer.parseInt(request.getParameter("id"));
Connection con = ConnectDB.connect();
PreparedStatement ps1;
try 
{
	ps1 = con.prepareStatement("update add_specialist_doctor set AddComment=? where srno=?");
	ps1.setString(1,addComment);
	ps1.setInt(2,id);
	int i=ps1.executeUpdate();
	if(i>0)
	{
		System.out.println("Comment added successfully");
	}
	else
	{
		System.out.println("Failed to add comment");
	}
} 
catch (SQLException e) 
{
	// TODO Auto-generated catch block
	e.printStackTrace();
}

%>
</body>
</html>