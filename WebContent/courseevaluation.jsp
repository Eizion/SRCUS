<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="resources/css/style.css" >
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin - Course Evaluations</title>
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
	<div class="center-login">
	<div style="background-color: white; padding: 25px; box-shadow: 3px 3px 3px 3px #888888;border-radius: 0px;">
	<c:if test = "${user.role == 1 }">
	<a class="btn btn-link" href="addCourse.jsp">Create Course</a><br>
	<a class="btn btn-link" href="selectCourse.jsp">Select Course</a><br>
	<a class="btn btn-link" href="CreateEvaluation.jsp">Create Evaluations</a><br>
	<a class="btn btn-link" href="editEvaluation.jsp">Edit Evaluation</a><br>
	</c:if>
	<a class="btn btn-link" href="selectEvaluation.jsp">Load Evaluation</a><br>
	<c:if test = "${(user.role == 1) || (user.role == 3)}">
	<a class="btn btn-link" href="generateReport.jsp">Generate Reports</a><br>
	</c:if>
	</div>
	</div>
</div>
</body>
</html>