<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Assign Student</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
<script type="text/javascript">
		//function to generate the options range for the year input box
		window.onload=function(){ //function to retrieve all student assigned to participate in the evaluation
			var xhttp;
			var button = "undo";
			if (window.XMLHttpRequest){
				  xhttp=new XMLHttpRequest();
			  }
			else{
			  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			xhttp.onreadystatechange=function(){
			    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	if(xhttp.response == "<table></table>"){
			    		window.alert("There are currently no students assigned to this course.");
			    	}
			    document.getElementById("students").innerHTML = xhttp.responseText;
			    }
			};
			  xhttp.open("GET", "assignServlet?button="+button, true);
			  xhttp.send();
	};
	
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
		<h3>Undo Student Assignment for the Evaluation of ${courseID} for the ${term} semester of the year ${year}</h3>
		<h5>This is the full list of students currently assigned to take part in the evaluation of the course ${courseID}.</h5>
		<form name="assignStudents" action="assignServlet" method="post">
		
		<div id="students"></div>
		<input type="submit" name="submit" value="Undo Student Assignment" onClick="return confirmDelete();" />
		</form>
</body>
</html>