<%@page import="com.mitali.connectdb.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ArogyaVibhag</title>
</head>
<body>

<%
//String PatientName = request.getParameter("sr.no");
int id=Integer.parseInt(request.getParameter("id"));
try
{
	Connection con = ConnectDB.connect();
	PreparedStatement ps = con.prepareStatement("delete from arogya_vibhag where srno=?");
	ps.setInt(1,id);
	
	int i = ps.executeUpdate();
	{
		response.sendRedirect("ViewCase2.jsp");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>