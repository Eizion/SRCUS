<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
</head>
<body>

	${errorMessage}
	<p>Please enter a new password</p>
	
	<form name="updatePassword" action="resetPassword" method="post">
		<table>
     		<tr>
     			<td><label>New Password:</label></td>
     			<td><input type="password" name="newPassword1" required/></td>
     		</tr>
     		<tr>
     			<td><label>Retype Password:</label></td>
     			<td><input type="password" name="newPassword2" required/></td>
     		</tr>
     		<tr>
     			<td><input type="submit" name="submit" value="Submit"></td>
   			</tr>
		</table>
	</form>

</body>
</html>