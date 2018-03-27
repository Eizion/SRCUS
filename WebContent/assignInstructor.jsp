<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Assign Instructor</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
<script type="text/javascript">
		//function to generate the options range for the year input box
		window.onload=function(){
			for(var i=2018; i<=2020; i++){
    			var select = document.getElementById("year");
    			var option = document.createElement("OPTION");
    			select.options.add(option);
   			 	option.text = i;
    			option.value = i;
			}
		};
		</script>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Assign Instructors for the course ${course.courseID} ${course.courseName}</h3>
		
		<form name="assignInstr" action="assignServlet" method="post">
		<table>
					<tr>
     					<td><label>Year:</label>
     					<select name="year" id="year" required>
     						<option value="" selected="selected"></option>
     						</select>
     					</td>
	    				<td><label>Term:</label>
     					<select name="term" id="term" required>
     						<option value="" selected="selected"></option>
     						<option value="spring">Spring Semester</option>
     						<option value="fall">Fall Semester</option>
     						<option value="summer">Summer Semester</option>
     						</select>
     					</td>
     				</tr>
			<c:forEach items="${instructors}" var="instructor">
					<tr>
					<td><input type="checkbox" name="instructor" value="${instructor.instrID}" > ${instructor.title} ${instructor.fName} ${instructor.lName}</td>
					</tr> 
			</c:forEach>
		</table>
		<input type="submit" name="submit" value="Assign Instructors" />
		</form>
		
</body>

</html>