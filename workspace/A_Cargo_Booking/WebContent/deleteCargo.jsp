<%@page import="com.Cargo.project.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String name = request.getParameter("nm");
try
{
	Connection con = ConnectDB.connect();
	PreparedStatement ps = con.prepareStatement("delete from addcargo where name=?");
	ps.setString(1, name);
	int i = ps.executeUpdate();
	if(i>0)
	{
		System.out.println("Data deleted Successfully...!!");
		response.sendRedirect("viewDeleteCargo.jsp");
	}
	else
	{
		System.out.println("Failed...!!");
		response.sendRedirect("viewDeleteCargo.jsp");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>


</body>
</html>