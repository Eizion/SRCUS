<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Challenge</title>
</head>
<body>

	${errorMessage}
	<p>Please answer your security question.</p>
	<form name="questions" action="CheckSQServlet" method="post">
		${question}
		<input type="text" name="answer" required />
		<input type="submit" value="Submit">
	</form>

</body>
</html>