<%@page import="org.eclipse.jdt.internal.compiler.ast.ThisReference"%>
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Edit Course</title>
<script type="text/javascript">
		//function to generate the options range for the year input box
		window.onload=function(){ //function to retrieve all student assigned to participate in the evaluation
			var xhttp;
			if (window.XMLHttpRequest){
				  xhttp=new XMLHttpRequest();
			  }
			else{
			  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			xhttp.onreadystatechange=function(){
			    if (xhttp.readyState == 4 && xhttp.status == 200) {
			    	if(xhttp.response == "<table></table>"){
			    		window.alert("There are currently no courses in database.");
			    	}
			    document.getElementById("courseID").innerHTML = xhttp.responseText;
			    }
			};
			  xhttp.open("GET", "courseServlet", true);
			  xhttp.send();
	};
		</script>
</head>
<body style="background-color: dodgerblue;">
<div class="header">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Southeast Regional Credit Union Schools Web Portal</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <li class="nav-link"><a href="login?logout=true">Logout</a></li>

    </ul>
  </div>
</nav>
	</div>
		<h3>Edit Course Information</h3>
		<h5>Select the course to be edited</h5>
		
         
		<form name="editCourse" action ="editCourse" method="post">
			<label>Course Code</label></br>
			<select name="courseID" id="courseID" required>
			<option value="" selected="selected">---------------</option>
			
			</select></br></br>
			
	
			<input type="submit" name="submit" value="Edit" />
			<input type="submit" name="submit" value="Assign Instructors" />
			<input type="submit" name= "submit" value="Assign Students" />
			<input type="submit" name="submit" value="Undo Assigned Instructors" />
			<input type="submit" name= "submit" value="Undo Assigned Students" />
			
			
		</form>
		${message}
		</br></br>
		<a href="courseevaluation.jsp"><input type="button" value ="Back" /></a>
</body>
</html>