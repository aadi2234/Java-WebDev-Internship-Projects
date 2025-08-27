<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="Project.MysqlCon"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remainder</title>
</head>
<body>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 95%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<br>
 <br>
<centre>
<table id="customers">
<tr>
<th>ID</th>
<th>Title</th>
<th>Description</th>
<th>Email ID</th>
</tr>
<tr>
<%
try
{
	Connection con=MysqlCon.getCon();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from task_tbl");
	while(rs.next())
	{
	%> 
	<td><%=rs.getInt(1)%></td>			
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	</tr>
	<%
	}
}
catch(Exception e)
{
	System.out.println(e);
}
	%>

</table>
</center>
<br>
</body>
</html>