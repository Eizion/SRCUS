<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.User" %>
<%@page import = "model.ContactInfo" %>
<%@page import = "model.Title" %>
    
<%User updatedUser = (User) session.getAttribute("updatedUser"); %>
<%ContactInfo updatedContactInfo = (ContactInfo) request.getAttribute("updatedContactInfo"); %>
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
<title>Southeast Regional Credit Union Schools Web Portal - Home</title>
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
<form name="updateForm" action="UpdateInstructor" method="get">

	<br>
	<label>First Name:</label>
	<input class="form-control" type=text name=fName value="<%= updatedUser.getfName() %>" />
	<br>
	<label>Last Name:</label>
	<input class="form-control" type=text name=lName value="<%= updatedUser.getlName() %>" />
	<br>
	<label>Email:</label>
	<input class="form-control" type=text name=email value="<%= updatedUser.getEmail() %>" />
	<br>
	<label>Title:</label>
	<input class="form-control" type=text name=title value="<%= title.getTitle() %>" />
	<br>
	<label>Address Line 1:</label>
	<input class="form-control" type=text name=addressLine1 value="<%= updatedContactInfo.getAddressLine1() %>" />
	<br>
	<label>Address Line 2:</label>
	<input class="form-control" type=text name=addressLine2 value="<%= updatedContactInfo.getAddressLine2() %>" />
	<br>
	<label>City:</label>
	<input class="form-control" type=text name=city value="<%= updatedContactInfo.getCity() %>" />
	<br>
	<label>State:</label>
	<input class="form-control" type=text name=state value="<%= updatedContactInfo.getState() %>" />
	<br>
	<label>Zip:</label>
	<input class="form-control" type=text name=zipcode value="<%= updatedContactInfo.getZipcode() %>" />
	<br>
	<label>Phone:</label>
	<input class="form-control" type=text name=phone value="<%= updatedContactInfo.getPhone() %>" />
	<br>
	<label>Organization:</label>
	<input class="form-control" type=text name=organization value="<%= updatedContactInfo.getOrganization() %>" />
	<br>
	
	<input class="btn btn-primary" type=submit name=submit value="Update" />

</form>
</div>
</div>
</body>
</html>