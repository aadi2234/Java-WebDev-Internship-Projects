<%@page import="connectionDB.*" %>
<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>View Specific Account</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
</head>
<body>

<section id="container">
<!--header start-->

<header class="header fixed-top clearfix">
<!--logo start-->

<div class="brand">
    <a href="index.html" class="logo">
        ICICI Bank
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->
</header>
<!--header end-->

<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="createAccount.html">
                        <i class="fa fa-dashboard"></i>
                        <span>Create Account</span>
                    </a>
                </li>
                
                <li class="sub-menu">
                    <a href="deposit.html">
                        <i class="fa fa-book"></i>
                        <span>Deposit Money</span>
                    </a>
                </li>
                <li>
                    <a href="withdraw.html">
                        <i class="fa fa-bullhorn"></i>
                        <span>Withdraw Money</span>
                    </a>
                </li>
                <li>
                    <a href="transfer.html">
                        <i class="fa fa-bullhorn"></i>
                        <span>Transfer Money</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="viewAccount.jsp">
                        <i class="fa fa-th"></i>
                        <span>View Accounts</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="viewSpecific.jsp">
                        <i class="fa fa-tasks"></i>
                        <span>View Specific Account</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="index.html">
                        <i class="fa fa-envelope"></i>
                        <span>Logout</span>
                    </a>
                </li>
               </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->

</section>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
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
<div class="log-w3">
<div class="w3layouts-main">
	<!-- start content -->
	<div class="grids">
				<div class="progressbar-heading grids-heading">
						<h2>Search Account</h2>
					</div>
					<div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class="form-grids widget-shadow" data-example-id="basic-forms"> 
								<div class="form-title">
									<h4>Search Form :</h4>
								</div>
								<div class="form-body">
									<form action="viewSpecific.jsp"> 
										
										<div class="form-group"> 
											<label for="exampleInputEmail1">Account Number:</label> 
											<input type="text" class="form-control" name="accno" id="exampleInputEmail1" placeholder="Enter Account Number"> 
										</div> 
										
										<button type="submit" class="btn btn-default">Search</button> 
									</form> 
								</div>
							</div>
						</div>
					</div>
	
					
					<%
					String id = request.getParameter("accno");
					if(id!=null)
					{
					%>
	
					<div class="progressbar-heading grids-heading">
						<h2>View Accounts</h2>
					</div>
					<div class="panel panel-widget forms-panel">
						
						<table id="customers">
						  <thead>
						    <tr>
						    <tr>
							<th>Account Number</th>
							<th>Name</th>
							<th>Contact</th>
							<th>Balance</th>
							<th>Action</th>
						    </tr>
						  </thead>
						  
						   <tbody>
						  <%
						  	try
						  	{
						  		Connection con = MysqlCon.getCon();
						  		PreparedStatement ps = con.prepareStatement("select * from accounts where accno=?");
						  		ps.setString(1, id);
						  		ResultSet rs = ps.executeQuery();
						  		while(rs.next())
						  		{
						  		%>
						  			<tr>
								      <td><%=rs.getString(1)%></td>
								      <td><%=rs.getString(2)%></td>
								      <td><%=rs.getString(3)%></td>
								      <td><%=rs.getInt(4)%></td>
								      <td><a href="deleteAccount.jsp?id=<%=rs.getString(1)%>" style="color: red;">Delete</a></td>
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
						
						
					</div>
					<%
					}
					%>
					
					
				</div>

	<!-- end content -->
	
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
