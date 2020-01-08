<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(session.getAttribute("login")==null){%>
		<h3><font color="red" align="center">Invalid Access<br>Please LogIn</font></h3>
		<%response.sendRedirect("Login.jsp");
	}else{
		String user = request.getParameter("user"); %>
		<h2>Welcome <%=user %></h2>
		<form action="GetEmployeeByCode">
			Enter Employee Code <input type="text" name="empno"><br>
			<input type="submit" value="View Record">
		</form><br>
		<form action="GetDeptByNo">
			Enter Department No <input type="text" name="deptno"><br>
			<input type="submit" value="Get Record">
		</form>
		<br>
		<br>
		<a href=Logout.java> Logout</a>
	<%}%>
</body>
</html>