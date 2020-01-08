<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn Page</title>
<script>
	function validate(){
		if(document.myForm.user.value == ""){
			alert("Enter your Username");
			document.myForm.user.focus();
			return false;
		}
		if(document.myForm.pass.value == ""){
			alert("Enter your Password");
			document.myForm.pass.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="Validate.jsp" name="myForm" onsubmit="return(validate());">
		Enter Name <input type="text" name="user"><br>
		Enter Password <input type="password" name="pass"><br>
		<input type="submit">
	</form>
</body>
</html>