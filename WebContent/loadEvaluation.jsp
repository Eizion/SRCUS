<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
     <%@page import="model.Question" %>
     <%
    	
    	Question[] container = (Question[])session.getAttribute("questionSet");
    	int questionNum = (Integer)session.getAttribute("questionNum");
    	int counter = questionNum - 1;
    	//Question current = (Question)request.getAttribute("current");
    %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Southeast Regional Credit Union Schools Web Portal - Load Evaluation</title>
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
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Course Evaluation for ${eval.courseID }</h3>
		<form name="laodEvaluation" action="saveAnswers" method="post">
			<label>${questionNum}. </label>
			<label>${current.question}</label></br></br>
			<c:if test="${current.questionType == 'chooseOne'}">
				<c:forEach items="${current.choices}" var="option">
					<input type="radio" name="answer" value="${option}" required />${option} </br>
				</c:forEach>
			</c:if>
			<c:if test="${current.questionType == 'multiSelect'}">
				<c:forEach items="${current.choices}" var="option">
					<input type="checkbox" name="answer" value="${option}" />${option} </br>
				</c:forEach>
			</c:if>
			<c:if test="${current.questionType == 'giveAnswer'}">
				<textarea name="answer"  rows="5" cols="40"  required></textarea>
			</c:if>
			</br></br>
			<c:if test="${last == false }">
			<input type="submit" name= "submit" value="Save & Continue" />
			</c:if>
			<c:if test="${last == true }">
			<input type="submit" name= "submit" value="Save & Finish" />
			</c:if>
			<input type="reset" name="reset" value="Reset" />
		</form>

	${message}
	<form name="navigate" action="saveAnswers" method="post">
		<input type="submit" name="submit" value ="Back" />
		<input type="submit" name="submit" value="Next" />
	</form>
</body>
</html>