<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">-->

<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="resources/css/style.css" >
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="CustomStyles.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union  Schools Web Portal</title>
</head>
<body style="background-color: #f2f2f2;" >
<div class="jumbotron">
<div class="container-fluid">
	<h1>SRCUS Web Portal</h1>	
	<h3>Southeast Regional Credit Union Schools</h3>
	</div>
    <div class="center-login">
<div style="
    background-color: #ffce99;
    padding: 25px;
    box-shadow: 3px 3px 3px #888888;
    border-radius: 0px;
">
    <h3 style="text-align: center;padding-bottom:  10px;">Log In</h3>
    	<form name="loginForm" action="login" method="post">

			
				
					<div style="padding-bottom: 15px;"><span>Email</span><span style="padding-left: 31px;"> <input class="form-control" type="text" name="email" required /></span></div>
				
				
					<div style="padding-bottom: 10px;"><span><label>Password</label></td> <input class="form-control" type="password" name="password" required /></span></div>
				
				
					<input style="padding-top: 0px;padding-bottom:  0px;" class="btn btn-primary " type="submit" value="Login">
					<a style="margin-left: 57px;" href="forgotpassword.jsp">Forgot Password</a>
				${errorMessage}
		</form>
		</div>
		</div>
		</div>
</div>		
</body>
</html>