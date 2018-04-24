<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Security Question</title>
</head>
<body style="background-color: dodgerblue;">
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

	${errorMessage}
	<div class="center-login">
	<div style="background-color: white; padding: 25px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
	<strong><p>Please choose your Security Question and Answer</p></strong>
			<form name="Security" action="updateSecurityQuestion" method="post">

			<div class="form-group">
				<label>Question</label>
				<select class="form-control" style="width:100%;" name="sq">
					<option value="">-----</option>
					<option value="1">In what city were you born?</option>
					<option value="2">What is the name of your first pet?</option>
					<option value="3">What is your dream vacation destination?</option>
					<option value="4">What was the make of your first car?</option>
					<option value="5">What was the name of your first
						boyfriend or girlfriend?</option>
				</select> 
				</div>
				
				<div class="form-group">
				<label>Answer(Case-Sensitive)</label>
				 <input class="form-control" type="text" name="answer" required />
				</div>

				<div class="form-group">
				<label>Enter your password</label>
				<input class="form-control" type="password" name="password" required /> 
				</div>
				<input
				
					class="btn btn-primary" type="submit" name="submit" value="Submit">
			</form>
		</div>
</div>

</body>
</html>