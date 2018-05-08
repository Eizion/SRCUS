<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.User" %>
<%@page import = "model.ContactInfo" %>
<%@page import = "model.Year" %>
<%@page import = "model.Title" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%User profile = (User) request.getAttribute("profile"); %>
<%ContactInfo profileContact = (ContactInfo) request.getAttribute("profileContact"); %>
<%Year year = (Year) request.getAttribute("year"); %>
<%Title title = (Title) request.getAttribute("title"); %>
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
<title>View Profile</title>
</head>
<body>
<div class="container" >
<div class="header">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div>
  <a class="navbar-brand" href="#"><img class="brand-image" src="resources/images/ScrusBrand.png" ></a>
  </div>
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
<h1 class="text-center">View Profile</h1>
	${errorMessage}
		<div>
	<div>
			
		<label>First Name:</label>
		<div><%= profile.getfName() %></div>
		<br>
		<label>Last Name:</label>
		<div><%= profile.getlName() %></div>
		<br>
		<label>Email:</label>
		<div><%= profile.getEmail() %></div>
		<br>
		<c:if test = "${user.role == 2}">
			<label>Year:</label>
			<div><%= year.getYear() %></div>
			<br>
		</c:if>
		<c:if test = "${user.role == 3}">
			<label>Title:</label>
			<div><%= title.getTitle() %></div>
			<br>
		</c:if>
		<c:if test = "${(user.role == 2) || (user.role == 3)}">
			<label>Address Line 1:</label>
			<div><%= profileContact.getAddressLine1() %></div>
			<br>
			<label>Address Line 2:</label>
			<div><%= profileContact.getAddressLine2() %></div>
			<br>
			<label>City:</label>
			<div><%= profileContact.getCity() %></div>
			<br>
			<label>State:</label>
			<div><%= profileContact.getState() %></div>
			<br>
			<label>Zip:</label>
			<div><%= profileContact.getZipcode() %></div>
			<br>
			<label>Phone:</label>
			<div><%= profileContact.getPhone() %></div>
			<br>
			<label>Organization:</label>
			<div><%= profileContact.getOrganization() %></div>
			<br>
		</c:if>
		
		<form action="editProfile" method="post">
			<input style="float:right;" class="btn btn-primary" type=submit name=submit value="Edit" />
		</form>

     			
     	</div>
		</div>
		</div>
		
</body>
</html>