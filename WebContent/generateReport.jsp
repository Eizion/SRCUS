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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="resources/css/style.css" >
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union Schools Web Portal - Select Evaluation</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/evaluations.js">
		
		</script>
</head>
<body>
<div class="container" >
<div class="header">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><img class="brand-image" src="resources/images/ScrusBrand.png" ></a>
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
	
		<h3>Select Evaluation</h3>
		
		<form name="Generate report" action="generateReport" method="post">
    			
    				<div class="form-group">
    					<label>Instructor Name:</label>
     					<select class="form-control" name="instrID" id="instrID" required onChange="getCourse(this.value);" >
							
							</select>
						</div>
     				
     				<div class="form-group">
     					<label>Course Name:</label>
     					<select class="form-control" name="courseID" id="courseID" required onChange="getYear(this.value);" >
							<option value="">---Course Name---</option>
							</select>
						</div>
     				
     				<div class="form-group">
     					<label>Year:</label>
     					<select class="form-control" name="year" id="year" required onChange="getTerm(this.value);" >
     						<option value="" selected="selected">---Year---</option>
     						</select>
     				</div>
					<div class="form-group">
	    				<label>Term:</label>
     					<select class="form-control" name="term" id="term" required>
     						<option value="" selected="selected">---Term---</option>
     						<option value="spring">Spring Semester</option>
     						<option value="fall">Fall Semester</option>
     						<option value="summer">Summer Semester</option>
     						</select>
     					</div>
     				
     					<input class="btn btn-primary" type="submit" name="submit" value="Generate Report">
     					<input class="btn btn-danger" type="reset" name="reset" value="Reset" />
     					
     			${message}
  		</form>
  		<br><br>
			<a href="courseevaluation.jsp"><input class="btn btn-light" type="button" value ="Back" /></a>
</div>
</body>
</html>