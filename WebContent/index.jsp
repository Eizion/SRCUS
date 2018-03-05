<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union Schools Web Portal</title>
</head>
<body style="background-color: dodgerblue;" >
	
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
	<div>
    <div style="
    width: 20%;
    height: 20%;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
">
<div style="
    background-color: white;
    padding: 25px;
    box-shadow: 3px 3px 3px #888888;
    border-radius: 0px;
">
    <h3 style="text-align: center;padding-bottom:  10px;">Log In</h3>
    	<form name="loginForm" action="login" method="post">
			
				
					<div style="padding-bottom: 15px;"><span>Email</span><span style="padding-left: 31px;"> <input type="text" name="email" required /></span></div>
				
				
					<div style="padding-bottom: 10px;"><span><label>Password</label></td> <input type="password" name="password" required /></span></div>
				
				
					<input style="padding-top: 0px;padding-bottom:  0px;" class="btn btn-primary" type="submit" value="Login">
					<a style="margin-left: 57px;" href="#">Forgot Password</a>
				
			
				${errorMessage}
		</form>
		</div>
		</div>
		</div>
		<!-- select answer from security_answer, user where security_answer.user_id = user.user_id and email = 'joe.vo28@gmail.com'; -->
		
</body>
</html>