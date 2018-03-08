<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Password</title>
</head>
<body style="background-color: dodgerblue;">

	${errorMessage}
		<div style="width: 20%;height: 20%;position: absolute;top: 0;bottom: 0;left: 0;right: 0;margin: auto;">
	<div style="background-color: white; padding: 25px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
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
     			<td ><a href="settings.jsp">back</a></td>
     			<td><span style="float:right;"><input type="submit" name="submit" value="Submit"></span></td>
     			
   			</tr>
		</table>
	
	</form>
	</div>
	</div>

</body>
</html>