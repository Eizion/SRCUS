<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="resources/css/style.css" >
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password</title>
</head>
<body style="background-color: dodgerblue;">
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
	<h2>Forgot Password</h2>
	${errorMessage}
	<div>
	<div class="center-login">
	<div style="
    background-color: white;
    padding: 40px;
    box-shadow: 3px 3px 3px #888888;
    border-radius: 0px;
" >
	<p>Please enter in your email address</p>
	<form name="emailForm" action="forgotpassword" method="post">
		Email:
		<input class="form-control" type="text" name="email" required />
		<input style="float:right;" type="submit" value="Submit">
	</form>
</div>
</div>
</div>
</body>
</html>