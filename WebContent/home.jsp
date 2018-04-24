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
	</div>
	
	<div class="wrapper">
		${message}
	
		<h2>Welcome, <c:out value="${user.fName}!!!" /></h2>
		
		<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel" data-interval="3000">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="https://scontent.fatl1-1.fna.fbcdn.net/v/t31.0-8/28516455_1726493317371935_68847662416018128_o.png?_nc_cat=0&oh=cbb939b0f9f91bf65dff55595db24aad&oe=5B5A11D0" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="https://scontent.fatl1-1.fna.fbcdn.net/v/t31.0-8/29352328_1755187191169214_6604733273944901028_o.png?_nc_cat=0&oh=768823a72cbda47d5a6eef8a896e043a&oe=5B9C59C9" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="https://scontent.fatl1-1.fna.fbcdn.net/v/t31.0-8/27021556_1692143074140293_5840179866451015533_o.png?_nc_cat=0&oh=ffa5cbb2de667dcb26993d195e72ba2b&oe=5B640234" alt="Third slide">
    </div>
  </div>
</div>
		
		<div class="row center">
		<c:if test = "${user.role == 1 }">
				<div class="homepage-icons"><a class="homepage-links" href="manage.jsp">Manage Users</a></div>
		</c:if>
				<div class="homepage-icons"><a class="homepage-links" href="courseevaluation.jsp">Course Evaluations</a></div>
				<div class="homepage-icons"><a class="homepage-links" href="settings.jsp">User Settings</a></div>
	</div>
	
	</div>
</div>
</body>
</html>