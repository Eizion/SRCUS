<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%@page import="model.Evaluation" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
 <title>Southeast Regional Credit Union Schools Web Portal - Edit Evaluation</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="modifyEvaluation.js">
		
	</script>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
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
			<input type="submit" name= "submit" value="Add Question" />
			</c:if>
			
		<input type="submit" name="submit" value="Delete Question" onClick="return confirmDelete();"/>
		
	</form>	
	 ${message} 
	 <form name="navigate" action="editEvaluation" method="post">
		<input type="submit" name="submit" value ="Back" />
		<input type="submit" name="submit" value="Next" />
	</form>
</body>
</html>
