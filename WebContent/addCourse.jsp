<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
   String message = (String)request.getAttribute("message");
   %>
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Add course</title>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Add Courses</h3>
		<form name="addCourse" action ="courseServlet" method="post">
			<label>Course Code</label></br>
			<input type="text" name="courseID" required /><br>
			<label>Course Name</label></br>
			<input type="text" name="courseName" required /></br>
			<label>Credit hr</label><br>
			<input type="number" name="creditHr" min="1" step="0.5" required /></br>
			<label>Course Type</label></br>
			<select name="courseType">
				<option value=""></option>
				<option value="face-to-face">Face-to-face</option>
				<option value="webinar">Webinar</option>
				<option value="hybride">Hybrid</option>
			</select></br>
			<label>Course Year</label></br>
			<select name="classYear">
				<option value=""></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="For all students">For all students</option>
			</select></br>
			<input type="submit" value="Add course" />
			<input type="reset" value="Reset" />
		</form>
		${message}
</body>
</html>