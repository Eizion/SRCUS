<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Password</title>
</head>
<body>

	<!-- We need to add validation to match the password fields -->
	${errorMessage}
	<form name="updatePassword" action="updatePassword" method="post">
		<table>
			<tr>
     			<td><label>Old Password:</label></td>
     			<td><input type="password" name="oldPassword" required/></td>
     		</tr>
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
     			<td><a href="settings.jsp">back</a></td>
   			</tr>
		</table>
	
	</form>
	

</body>
</html>