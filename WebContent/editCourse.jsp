<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Course, dbHelpers.CheckCourse" %>
    <%
    Course course = new Course();
    course = (Course)request.getAttribute("course");
    String tempcourse= course.getCourseID();
    session.setAttribute("oldCourseID", tempcourse);
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
		<h3>Course Information</h3>
		<form name="update" action="update" method="post">
			<label>Course Code</label>
				<input type="text" name="courseID" value="<%=course.getCourseID() %>" required /></br></br>
				
			<label>Course Name</label>
				<input type="text" name="courseName" value="<%=course.getCourseName() %>" required /></br></br>
				
			<label>Credit Hours</label>
				<input type="number" name="creditHr" min="1" step="0.5" value="<%=course.getCreditHr()%>" required /></br></br>
				
			<label>Course Type</label>
				<select name="courseType"  required >
					<option value="<%=course.getCourseType() %>" selected><%=course.getCourseType() %></option>
					<option value="face-to-face">Face-to-face</option>
					<option value="webinar">Webinar</option>
					<option value="hybride">Hybrid</option>
				</select>	</br></br>		
			<label>Course Year</label>
				<select name="courseYear" required>
				<option value="<%=course.getClassYear()%>" selected><%=course.getClassYear()%></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="For all students">For all students</option>
			</select> </br></br>
				<input type="submit" value="Save Changes" />
		</form>		
		
				

</body>
</html>