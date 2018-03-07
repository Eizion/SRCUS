<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password</title>
</head>
<body>

	${errorMessage}
	<p>Please enter in your email address</p>
	<form name="emailForm" action="forgotpassword" method="post">
		Email:
		<input type="text" name="email" required />
		<input type="submit" value="Submit">
	</form>


</body>
</html>