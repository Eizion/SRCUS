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
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Load Evaluation</title>
</head>
<body>
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