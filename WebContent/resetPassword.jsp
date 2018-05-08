<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="resources/css/style.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reset Password</title>
</head>
<body style="background-color: dodgerblue;">
<h1>Southeast Regional Credit Union Schools Web Portal</h1>
<h2>Reset Password</h2>
	${errorMessage}
	<div class="center-login">
	<div style="background-color: white; padding: 45px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
	<p>Please enter a new password</p>
	
	<form name="updatePassword" action="resetPassword" method="post">
		
     		
     			<label>New Password:</label></td>
     			<input class="form-control" type="password" name="newPassword1" required/>
     		
     		
     			<label>Retype Password:</label></td>
     			<input class="form-control" type="password" name="newPassword2" required/>
     		
     			<input style="float:right;" class="btn btn-primary" type="submit" name="submit" value="Submit">
   			
		
	</form>
</div>
</div>
</body>
</html>