<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Undo Student Assignment for the Evaluation of ${courseID} for the ${term} semester of the year ${year}</h3>
		<h5>This is the full list of students currently assigned to take part in the evaluation of the course ${courseID}.</h5>
		<form name="assignStudents" action="assignServlet" method="post">
		
		<div id="students"></div>
		<input type="submit" name="submit" value="Undo Student Assignment" onClick="return confirmDelete();" />
		</form>
</body>
</html>