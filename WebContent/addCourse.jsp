<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
   String message = (String)request.getAttribute("message");
   %>
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Add course</title>
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
		</br></br>
		<a href="courseevaluation.jsp"><input type="button" value ="Back" /></a>
</body>
</html>