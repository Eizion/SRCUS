<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {
		jQuery('#title').hide();
		//jQuery('#title select').removeAttr('required');
		jQuery('#year').hide();
		//jQuery('#year select').removeAttr('required');
		
		jQuery("#role").change(function(){
			var selectedValue = jQuery("#role").val();
			
			if (selectedValue == 2) {
				jQuery('#year').show();
				//jQuery('#year select').attr('required',true);
				jQuery('#title').hide();
				//jQuery('#title select').removeAttr('required');
			} else if (selectedValue == 3) {
				jQuery('#title').show();
				//jQuery('#title select').attr('required',true);
				jQuery('#year').hide();
				//jQuery('#year select').removeAttr('required');
			} else {
				jQuery('#title').hide();
				//jQuery('#title select').removeAttr('required');
				jQuery('#year').hide();
				//jQuery('#year select').removeAttr('required');
			}
			
		});
	});
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union Schools Web Portal</title>
</head>
<body>

	<div class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light"> <a
			class="navbar-brand" href="#">Southeast Regional Credit Union
			Schools Web Portal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav"></div>
		</nav>
	</div>

	<div class="container">
		<div class="form-group">
			<form name="registration" action="register" method="post">
				<p>Please Fill Out Your Information Here:</p>
<div class="form-group">

				<label>Email:</label> <input class="form-control" type="text" name="email" required /> <label>Password:</label>
				<input class="form-control" type="password" name="password" required /> <label>First
					Name:</label> <input class="form-control"type="text" name="fname" required /> <label>Last
					Name:</label> <input class="form-control" type="text" name="lname" required /> <label>User
					Role:</label> <select class="form-control" id="role" name="role" required>
					<option value="">-----</option>
					<option value="2">Student</option>
					<option value="3">Instructor</option>
				</select> 
				
				<label>Street Line 1:</label> <input class="form-control" type="text" name="address1"
					required /> 
					
					<label>Street Line 2:</label> <input class="form-control" type="text"
					name="address2" />
					
					 <label>City:</label> <input class="form-control" type="text"
					name="city" required /> 
					
					<label>State:</label> <select class="form-control" name="state"
					required>
					<option value="">-----</option>
					<option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
				</select> <label>Zipcode:</label> <input class="form-control" type="text" name="zipcode" required />


				<label>Organization:</label> <input class="form-control" type="text" name="organization"
					required /> <label>Phone:</label> <input class="form-control" type="text" name="phone"
					required /> <label>Title:</label> <input class="form-control" type="text" name="title" />


				<label>Year:</label> <select class="form-control" name="year">
					<option value="0">-----</option>
					<option value="1">1st Year</option>
					<option value="2">2nd Year</option>
					<option value="3">3rd Year</option>
				</select> <label>Security Question</label> <select class="form-control" name="sq" required>
					<option value="">-----</option>
					<option value="1">In what city were you born?</option>
					<option value="2">What is the name of your first pet?</option>
					<option value="3">What is your dream vacation destination?</option>
					<option value="4">What was the make of your first car?</option>
					<option value="5">What was the name of your first
						boyfriend or girlfriend?</option>
				</select> <label>Answer(Case-Sensitive)</label> <input class="form-control space-bottom" name="answer" required />

				<div style="padding-top:20px;">
				<a class="" href="index.jsp">back</a> 
				<input class="btn btn-primary"style="padding-top: 0px; padding-bottom: 0px; float: right;"type="submit" name="submit" value="Register">
				</div>

</div>

				${errorMessage}
			</form>
		</div>
	</div>


</body>
</html>