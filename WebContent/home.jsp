<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union Schools Web Portal - Home</title>
</head>
<body>

	<div class="header">
    	<div class="nav">    		
    		<ul id="nav_ul">
				<li class="nav_li"><a href="home.jsp">Home</a></li>
				<li class="nav_li"><a href="login?logout=true">Logout</a></li>
			</ul>			
		</div>		
		<h2 style="font-family: Verdana">Southeast Regional Credit Union Schools Web Portal</h2>        
	</div>
	
	<div class="wrapper">
	
		<h1>Home</h1>
		${message}
	
		<p>Welcome, <c:out value="${user.fName}!!!" /></p>
		
		<table>
			<tr>
				<td><a href="manage.jsp">Manage Users</a></td>
				<td><a href="courseevaluation.jsp">Course Evaluations</a></td>
				<td><a href="settings.jsp">User Settings</a></td>
			</tr>
		</table>
	
	</div>

</body>
</html>