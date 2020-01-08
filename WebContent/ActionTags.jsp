<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="emp" class="com.deloitte.empl.beans.Emp"></jsp:useBean>
	<jsp:setProperty property="empno" name="emp" value="123"/><br>
	<jsp:setProperty property="ename" name="emp" value="deloitte"/><br>
	Employee Number = <jsp:getProperty property="empno" name="emp"/><br>
	Employee Number = <jsp:getProperty property="ename" name="emp"/><br>
	<jsp:include page="Login.jsp"></jsp:include>
</body>
</html>