<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<%if(session.getAttribute("login")==null){%>
		<h3><font color="red" align="center">Invalid Access<br>Please LogIn</font></h3>
		<%response.sendRedirect("Login.jsp");}
	else{%>
		<h2>Welcome Administrator!!!</h2>
		<h3>Select Action to be performed</h3><br>
		<a href=DepartmentHomepage.html>   Department Operations</a><br>
		<a href=EmployeeHomepage.html>   Employee Operations</a><br><br>
		<a href=Logout.java> Logout</a>
	<% }%>
</body>
</html>