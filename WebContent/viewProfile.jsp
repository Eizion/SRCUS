<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
</head>
<body>
<h1>User Profile</h1>

<!-- Table to show user profile information -->




<!-- Table to show user profile information -->
<table>
     				<tr>
	    				<td><label>Email:</label></td>
	    				
	    				<!--  Getting the user data via the "user" object -->
     					<td>${user.email}</td>
     				</tr>
     				<tr>
     					<td><label>First Name:</label></td>
     					<td>${user.fName}</td>
     				</tr>
     				<tr>
	    				<td><label>Last Name:</label></td>
     					<td>${user.lName}</td>
     				</tr>
     				<tr>
	    				<td><label>Role:</label></td>
     					<td>${user.role}</td>
     				</tr>
     				<tr>
     				
     					<td><a href="editProfile.jsp">Edit Profile</a></td>
     					<td><a href="settings.jsp">Back</a></td>
     				</tr>
     			</table>
                   
</body>
</html>