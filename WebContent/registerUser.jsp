<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
		
	<div style="width: 20%;height: 20%;position: absolute;top: 0;bottom: 0;left: 0;right: 0;margin: auto;">
	<div style="background-color: white; padding: 25px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
			<form name="registration" action="register" method="post">
			<p>Please Fill Out Your Information Here:</p>
    			<table>
     				<tr>
	    				<td><label>Email:</label></td>
     					<td><input type="text" name="email" required/></td>
     				</tr>
     				<tr>
     					<td><label>Password:</label></td>
     					<td><input type="password" name="password" required/></td>
     				</tr>
     				<tr>
     					<td><label>First Name:</label></td>
     					<td><input type="text" name="fname" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Last Name:</label></td>
     					<td><input type="text" name="lname" required/></td>
     				</tr>
     				<tr>
	    				<td><label>User Role:</label></td>
     					<td><select id="role" name="role" required>
     							<option value="">-----</option>
     							<option value="1">Administrator</option>
     							<option value="2">Student</option>
     							<option value="3">Instructor</option>
     						</select>
     					</td>
     				</tr>
     				<tr>
	    				<td><label>Street Line 1:</label></td>
     					<td><input type="text" name="address1" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Street Line 2:</label></td>
     					<td><input type="text" name="address2" /></td>
     				</tr>
     				<tr>
	    				<td><label>City:</label></td>
     					<td><input type="text" name="city" required/></td>
     				</tr>
     				<tr>
	    				<td><label>State:</label></td>
     					<td><select name="state" required>
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
     						</select>
     					</td>
     				</tr>
     				<tr>
	    				<td><label>Zipcode:</label></td>
     					<td><input type="text" name="zipcode" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Organization:</label></td>
     					<td><input type="text" name="organization" required/></td>
     				</tr>
     				<tr>
	    				<td><label>Phone:</label></td>
     					<td><input type="text" name="phone" required/></td>
     				</tr>
     				<tr id="title">
	    				<td><label>Title:</label></td>
     					<td><input type="text" name="title"/></td>
     				</tr>
     				<tr id="year">
	    				<td><label>Year:</label></td>
     					<td><select name="year" >
     						<option value="0">-----</option>
     						<option value="1">1st Year</option>
     						<option value="2">2nd Year</option>
     						<option value="3">3rd Year</option>
     					</select>
     					</td>
     				</tr>
     				<tr>
     					<td><a href="index.jsp">back</a></td>
     					<td><input class="btn btn-primary" style="padding-top: 0px;padding-bottom:  0px; float:right;" type="submit" name="submit" value="Register"></td>
     					
     				</tr>
     			</table>
     			${errorMessage}
  		</form>
	</div>
	</div>
	

</body>
</html>