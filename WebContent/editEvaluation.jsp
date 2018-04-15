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
<title>Southeast Regional Credit Union Schools Web Portal - Edit Evaluation</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/evaluations.js">
		
		</script>
	
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Select Evaluation</h3>
		
		<form name="evaluation" action="selectEvaluation" method="post">
    			<table>
    				<tr>
    					<td><label>Instructor Name:</label></td>
     					<td><select name="instrID" id="instrID" required onChange="getCourse(this.value);" >
							
							</select>
						</td>
     				</tr>
     				<tr>
     					<td><label>Course Name:</label></td>
     					<td><select name="courseID" id="courseID" required onChange="getYear(this.value);">
							<option value="">---Course Name---</option>
							</select>
						</td>
     				</tr>
     				<tr>
     					<td><label>Year:</label></td>
     					<td><select name="year" id="year" required onChange="getTerm(this.value);">
     						<option value="" selected="selected"></option>
     						</select>
     					</td>
     				</tr>
     				<tr>
	    				<td><label>Term:</label></td>
     					<td><select name="term" id="term" required>
     						<option value="" selected="selected"></option>
     						<option value="spring">Spring Semester</option>
     						<option value="fall">Fall Semester</option>
     						<option value="summer">Summer Semester</option>
     						</select>
     					</td>
     				</tr>
     				<tr>
	    			
     				<tr>
     					<td><input type="submit" name="submit" value="Edit Evaluation" /></td>
     					<td><input type="submit" name="submit" value="Delete Evaluation" onClick="return confirmDelete();" /></td>
     					<td><input type="submit" name="submit" value="Assign Students" /></td>
     					<td><input type="submit" name="submit" value="Undo Assigned Students" />
     					<td><input type="reset" name="reset" value="Reset" /></td>
     					</tr>
     			</table>
     			${message}
  		</form>

</body>
</html>