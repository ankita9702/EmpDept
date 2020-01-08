<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JSP Example</title>
</head>
<body>
	<h1>Sample JSP Program</h1>
	<%--comment tags--%>
	<%!int x=5; %>
	<h2>The value of x is <%=x++%></h2>
	<%if(x>0){%>
		<h3>X is a positive number.</h3>
	<%}else {%>
		<h3>X is a negative number</h3>
	<%} %>
</body>
</html>