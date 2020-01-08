<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		session.setAttribute("login", true);
		if(user.equals("admin") && pass.equals("admin")){%>
			<jsp:include page="Admin.jsp"></jsp:include>	
		<%} 
		else if(!user.equals("admin")){
			session.setAttribute("user", user);%>
			<jsp:include page="User.jsp"></jsp:include>
		<%} 
		else{
			out.println("<font color=red>Invalid Username</font>");
			session.invalidate();%>
			<jsp:include page="Login.jsp"></jsp:include>
		<%}%>
</body>
</html>