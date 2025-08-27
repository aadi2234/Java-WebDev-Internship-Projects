<%
 String username=request.getParameter("username");
 String password=request.getParameter("password");
 if("Aditya@01".equals(username) && "aadi2234".equals(password))
 {
	 response.sendRedirect("home.jsp");
 }
 else
 {
	 response.sendRedirect("adminLogin.jsp?msg=invalid");
 }
 %>