<%@page import="com.mitali.connectdb.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cases</title>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>

<body class="sub_page">

  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span>
              &nbsp;&nbsp;Rural E-Health
            </span>
          </a>
        </nav>
      </div>
    </header>
    <!-- end header section -->
  </div>

<div class="progressbar-heading grids-heading">
						<h2>View All Cases</h2>
</div>
<table class="table" border="1">
  <thead>
    <tr>
     <th scope="col">sr.no</th>
	 <th scope="col">PatientName</th>
	 <th scope="col">Age</th>
	 <th scope="col">Gender</th>
	 <th scope="col">Address</th>
     <th scope="col">Mobile</th>
     <th scope="col">Symptom1</th>
     <th scope="col">Symptom2</th>
     <th scope="col">Symptom3</th>
     <th scope="col">Action</th>
    </tr>
  </thead>
 
  <tbody>
  
  <% 
  try
  {
	  Connection con=ConnectDB.connect(); 
  	  PreparedStatement ps=con.prepareStatement("select * from arogya_vibhag");
   	  ResultSet rs= ps.executeQuery();
  	  while(rs.next())
    	{
   %>                              <tr>
								      <th scope="row"><%=rs.getInt(1)%></th>
								      <td><%=rs.getString(2)%></td>
								      <td><%=rs.getString(3)%></td>
								      <td><%=rs.getString(4)%></td>
								      <td><%=rs.getString(5)%></td>
								      <td><%=rs.getString(6)%></td>
								      <td><%=rs.getString(7)%></td>
						              <td><%=rs.getString(8)%></td>
						              <td><%=rs.getString(9)%></td>
								      <td><a href="DeleteCase.jsp?id=<%=rs.getInt(1)%>">Delete</a></td>
								    </tr>
    	    
   <% 
    	}
  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  %>
  </tbody>
</table>

<div class="sidebar-menu">
					<header class="logo1">
						<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
					</header>
						<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                           <div class="menu">
									<ul id="menu" >
										<li><a href="index.html"><i class="fa fa-tachometer"></i> <span>Back</span></a></li>
								  </ul>
								</div>
							  </div>
							  
</body>
</html>