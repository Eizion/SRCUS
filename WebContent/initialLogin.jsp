<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Question and Password</title>
</head>
<body style="background-color: dodgerblue;">
<div style="width: 40%;height: 20%;position: absolute;top: 0;bottom: 0;left: 0;right: 0;margin: auto;">
	<div style="background-color: white; padding: 0px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
	<p>Please select a security question and change your password</p>
	<form name="Security" action="InitialLoginUpdateServlet" method="post">
		<table>
			<tr>
				<td>Question</td>
				<td>Answer</td>
			</tr>
			<tr>
				<td>
					<select name ="sq">
						<option value="">-----</option>
						<option value="1">In what city were you born?</option>
						<option value="2">What is the name of your first pet?</option>
						<option value="3">What is your dream vacation destination?</option>
						<option value="4">What was the make of your first car?</option>
						<option value="5">What was the name of your first boyfriend or girlfriend?</option>
					</select>
				</td>
				<td>
					<input type="text" name="answer" required/>
				</td>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<td><label>Password:</label></td>
     			<td><input type="password" name="password" required/></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Submit">
	</form>
</div>
</div>
</body>
</html>