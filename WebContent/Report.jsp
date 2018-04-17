<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%
   String message = (String)request.getAttribute("message");
   %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Select Evaluation</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="evaluations.js">
		
		</script>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		

		<table>
		<tr>
		<th><h3>Southeast CUNA Management School ${year}</h3></th>
		</tr>
		<tr>
		<th>Evaluation Results</th>
		</tr>
		<tr>
		<td>Course Title: ${course.courseName}</td>
		<td>Class Year:${course.classYear}</td>
		</tr>
		<tr>
		<td>Instructor's Name:${instructor.title}${instructor.fName} ${instructor.lName }</td>
		</tr>
		</table>
		${message}
		
		<a href="generateReport.jsp"><input type="button" value ="Back" /></a>
</body>
</html>