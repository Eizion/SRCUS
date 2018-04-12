<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Undo Assigned Students</title>
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
		
		function getStudents(){
			var year = document.getElementById("year").value;
			var term = document.getElementById("term").value;
			var button = document.getElementById("getStudent").value;
			var xhttp;
			if(year != "" && term != ""){
			if (window.XMLHttpRequest){
				  xhttp=new XMLHttpRequest();
			  }
			else{
			  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			xhttp.onreadystatechange=function(){
			    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	if(xhttp.responseText == "<table></table>"){
			    		window.alert("There are currently no students assigned to this course.");
			    	}
			        document.getElementById("students").innerHTML = xhttp.responseText;
			    }
			};
			  xhttp.open("GET", "undoAssignServlet?year="+year+"&term="+term+"&button="+button, true);
			  xhttp.send();
			}
		}
		
		function confirmDelete(){
			var answer = confirm("Are you sure you want to undo this assignment?");
			if(answer){
				return true;
			}
			else{
				return false;
			}
		}
		
		</script>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Undo Student Assignments for the Course ${course.courseID} ${course.courseName}</h3>
		<form name="undoAssignStudents" action="undoAssignServlet" method="post">
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
     					<td><input type="button" id="getStudent" value="Get Assigned Students" onClick="getStudents();" /></td>
     				</tr>
     				
		</table>
		
		<div id="students"></div>
		
		<input type="submit" name="submit" value="Undo Student Assignments" onClick="return confirmDelete();" / >
		</form>
</body>
</html>