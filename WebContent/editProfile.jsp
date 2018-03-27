<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Profile</title>
</head>
<body>
<h1>Edit Profile</h1>

<!-- Table to edit user profile information -->



		<form name="updateProfile" action="update" method="post">
				<table>
     				<tr>
	    				<td><label>Email:</label></td>
	    				
	    				<!-- Text field with the origional user data in it where the user can update if need be-->
     					<td><input type="text" name="email" value="${user.email}" required/></td>
     				</tr>
     				<tr>
     					<td><label>First Name:</label></td>
     					<td><input type="text" name="fname" value="${user.fname}" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Last Name:</label></td>
     					<td><input type="text" name="lname" value="${user.lname}" required/></td>
     				</tr>
     				<tr>
     				
     					<td><input type="submit" name="submit" value="Update"></td>
     					<td><a href="viewProfile.jsp">Back</a></td>
     				</tr>
     			</table>
     			${errorMessage}
     			
     		</form>
</body>
</html>