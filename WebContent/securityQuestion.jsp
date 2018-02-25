<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Question</title>
</head>
<body>

	<form name="Security" action="SecurityServlet" method="post">
		<table>
			<tr>
				<td>Question</td>
				<td>Answer</td>
			</tr>
			<tr>
				<td>
					<select name ="SQ1">
						<option value="">-----</option>
						<option value="1">In what city were you born?</option>
						<option value="2">What is the name of your first pet?</option>
						<option value="3">What is your dream vacation destination?</option>
						<option value="4">What was the make of your first car?</option>
						<option value="5">What was the name of your first boyfriend or girlfriend?</option>
					</select>
				</td>
				<td>
					<input type="text" name="answer1" required/>
				</td>
			</tr>
			<tr>
				<td>
					<select name ="SQ2">
						<option value="">-----</option>
						<option value="1">In what city were you born?</option>
						<option value="2">What is the name of your first pet?</option>
						<option value="3">What is your dream vacation destination?</option>
						<option value="4">What was the make of your first car?</option>
						<option value="5">What was the name of your first boyfriend or girlfriend?</option>
					</select>
				</td>
				<td>
					<input type="text" name="answer2" required/>
				</td>
			</tr>
			<tr>
				<td>
					<select name ="SQ3">
						<option value="">-----</option>
						<option value="1">In what city were you born?</option>
						<option value="2">What is the name of your first pet?</option>
						<option value="3">What is your dream vacation destination?</option>
						<option value="4">What was the make of your first car?</option>
						<option value="5">What was the name of your first boyfriend or girlfriend?</option>
					</select>
				</td>
				<td>
					<input type="text" name="answer3" required/>
				</td>
			</tr>
		</table>
		<input type="submit" name="submit" value="Submit">
	</form>

</body>
</html>