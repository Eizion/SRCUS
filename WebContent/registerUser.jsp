<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union Schools Web Portal</title>
</head>
<body style="background-color: dodgerblue;">

	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
	
	<h2>Account Registration</h2>
		
	<div style="width: 20%;height: 20%;position: absolute;top: 0;bottom: 0;left: 0;right: 0;margin: auto;">
	<div style="background-color: white; padding: 25px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
			<form name="registration" action="register" method="post">
			<p>Please Fill Out Your Information Here:</p>
    			<table>
     				<tr>
	    				<td><label>Email:</label></td>
     					<td><input type="text" name="email" required/></td>
     				</tr>
     				<tr>
     					<td><label>Password:</label></td>
     					<td><input type="password" name="password" required/></td>
     				</tr>
     				<tr>
     					<td><label>First Name:</label></td>
     					<td><input type="text" name="fname" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Last Name:</label></td>
     					<td><input type="text" name="lname" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Role:</label></td>
     					<td><select name="role" required>
     							<option value="">-----</option>
     							<option value="Administrator">Administrator</option>
     							<option value="Student">Student</option>
     							<option value="Insturctor">Instructor</option>
     						</select>
     					</td>
     				</tr>
     				<tr>
     					<td><a href="index.jsp">back</a></td>
     					<td><input class="btn btn-primary" style="padding-top: 0px;padding-bottom:  0px; float:right;" type="submit" name="submit" value="Register"></td>
     					
     				</tr>
     			</table>
     			${errorMessage}
  		</form>
	</div>
	</div>
	

</body>
</html>