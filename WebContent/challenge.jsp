<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="resources/css/style.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Security Challenge</title>
</head>
<body style="background-color: dodgerblue;">
<h1>Southeast Regional Credit Union Schools Web Portal</h1>
	${errorMessage}
	<div class="center-login">
	<div style="background-color: white; padding: 40px; box-shadow: 3px 3px 3px #888888;border-radius: 0px;">
	<p>Please answer your security question.</p>
	<form name="questions" action="CheckChallengeServlet" method="post">
		${question}
		<input class="form-control" type="text" name="answer" required />
		<input style="float:right;" type="submit" value="Submit">
	</form>
</div>
</div>
</body>
</html>