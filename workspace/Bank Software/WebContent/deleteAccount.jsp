<%@page import="connectionDB.*"%>
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Account</title>
</head>
<body>

<%
String accno = request.getParameter("id");
try
{
	Connection con = MysqlCon.getCon();
	PreparedStatement ps = con.prepareStatement("delete from accounts where accno=?");
	ps.setString(1, accno);
	int i = ps.executeUpdate();
	{
		response.sendRedirect("viewAccount.jsp");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>


</body>
</html>