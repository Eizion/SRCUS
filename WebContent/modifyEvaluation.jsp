<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%@page import="model.Evaluation" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/modifyEvaluation.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Southeast Regional Credit Union Schools Web Portal - Create Evaluation</title>
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
		<h3>Evaluation Questions</h3>
		<form name="EditEvaluation" action="editEvaluation" method="post">
			<label>Question ${questionNum}</label></br></br>
			<input type="text" name="question" size="100" value="${current.question}" required /></br></br>
			
			<label>Type of question</label>
				<select name="questionType"  id="questionType" onchange="addChoices(this.value);" required>
					<option value="${current.questionType}" selected>${current.questionType}</option>
					<option value="chooseOne">Choose one</option>
					<option value="multiSelect">Multi select</option>
					<option value="giveAnswer">Give answer</option>
				</select> </br></br>
				
			<div id ="choices">
			<c:if test="${current.questionType == 'chooseOne'|| current.questionType == 'multiSelect'}">
				<c:forEach items="${current.choices}" var="option" begin="0" step="1" varStatus="status">
					<label id="label1">Choice ${status.count} </label>
					<input type="text" name="${status.count}" id="${status.count}" value="${option}" required /></br>
					<input type="hidden" id="counter" value="${status.count}" />
				</c:forEach>
			</c:if>
			</div>
			</br></br>
			
			
			<c:if test="${last == false }">
			<input type="submit" name= "submit" value="Save & Continue" />
			<input type="submit" name= "submit" value="Save & Finish" />
			</c:if>
			<c:if test="${last == true }">
			<input type="submit" name= "submit" value="Save & Finish" />
			</c:if>
		<input type="submit" name="submit" value="Delete Question" onClick="return confirmDelete();"/>
	</form>	
		 ${message}
</body>
</html>