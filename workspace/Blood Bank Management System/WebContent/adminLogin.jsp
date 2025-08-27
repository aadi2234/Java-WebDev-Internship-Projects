<!DOCTYPE html>
<html lang="en">
<head>
 <link rel="stylesheet" href="style.css" type="text/css" media="screen">
<style>
input[type="text"], input[type="password"], input[type="submit"]
{
    border: yes;
    background: silver;
    height: 50px;
    font-size: 16px;
	margin-left:35%;
	padding:15px;
	width:33%;	
	border-radius: 25px;
}
body {
      background-image: url("loginbg.jpg");
      background-size: cover;
      background-position: center;
    }
</style>
    
</head>
<body>
<div class="header">
  <a href="#default" class="logo"><img class="logo" src="Logo1.png"></a>
    <h1>LifeLine Blood Bank</h1>
    <h2>Maharashtra, India</h2>
  <div class="header-right">
    <a href="index.jsp">Home</a>
    <a class="active" href="adminLogin.jsp">Admin Login</a>
  </div>
  </div>
<body>
<div class="container">
<br>
	<br>
	<%
	String msg=request.getParameter("msg");
	if("invalid".equals(msg))
	{
	%>
	}
	<center><font color="red" size="5">Invalid Username/Password</font></center>
	<%
	}
	%>
<form action="adminLoginAction.jsp" method="post">
<div class="form-group">
<center><h2 style="color:magenta">Username</h2></center>
<input type="text" placeholder="Enter Username" style="color:brown" name="username" required>
<center><h2 style="color:magenta">Password</h2></center>
<input type="password" placeholder="Enter Password" style="color:brown" name="password" required>
<center><button type="submit" class="button" style="color:yellow">Submit</button></center>
</form>
</div>
<br>
<br>
<br>
<br>
<h3><center>All Right Reserved @ AD Tech :: 0405  </center></h3>
</body>
</html>
