<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Record</title>
</head>
<body>
	<form action="UpdateEmpRecord" method="post">
	Enter Employee Code <input type="text" name="empno" value="${emp.empno}" readonly=readonly><br>
	Select Items to be updated <br> <input type="checkbox" name="item" value="job">Job
					    Select Job Title <input list="Job" name="job" value="${emp.job}"> 
						<datalist id="Job">
						<option>Manager</option>
						<option>Clerk</option>
						<option>Salesman</option>
						<option>Analyst</option>
						<option>President</option>
						</datalist> <br>
					<input type="checkbox" name="item" value="mgr">
						Enter Manager ID <input type="text" name="mgr" value="${emp.mgr}"><br>
					<input type="checkbox" name="item" value="sal">
						Enter Salary <input type="text" name="sal" value="${emp.sal}"><br>
					<input type="checkbox" name="item" value="comm">
						Enter Commission <input type="text" name="comm" value="${emp.comm}"><br>
					<input type="checkbox" name="item" value="deptno">
						Enter Department No. <input type="text" name="deptno" value="${emp.deptno}"><br>
		<input type="submit" value="Update Record">
</form>
</body>
</html>