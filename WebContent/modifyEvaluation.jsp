<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%@page import="model.Evaluation" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Create Evaluation</title>
	<script type="text/javascript">
		var counter=1;
		function addChoices(selected){ 
			for(var i = 1; document.getElementById(i) !== null; i++){
				counter = i;
			}
			window.alert(counter);
			var qType = document.getElementById("questionType").value;
			if(qType == "chooseOne" || qType == "multiSelect"){
				if(counter == 1){ //first choice textbox option to create
				 var p = document.getElementById("choices");
				 var newElement = document.createElement("input");
				 var label = document.createElement("label");
				 label.setAttribute("id", "label1");
				 label.innerHTML ="</br></br><label>Choice "+counter+ " " + "</label>";
				 newElement.setAttribute("id", counter);
				 newElement.setAttribute("name", counter);
				 newElement.setAttribute("onChange","newChoices(this.value)");
				 p.appendChild(label);
				 p.appendChild(newElement);
				 counter++;
				}else if(counter > 1){ //When there are existing choice text boxes
					for (var i =1; i <= counter; i++){
						var newElem = document.getElementById(i)
						var lable1 = document.getElementById("label1");
						newElem.parentNode.removeChild(newElem);
						label1.parentNode.removeChild(label1);
					}
					counter = 1;
					var p = document.getElementById("choices");
					 var newElement = document.createElement("input");
					 var label = document.createElement("label");
					 label.setAttribute("id", "label1");
					 label.innerHTML ="</br></br><label>Choice "+counter+" </label>";
					 newElement.setAttribute("id", counter);
					 newElement.setAttribute("name", counter);
					 newElement.setAttribute("onChange","newChoices(this.value)");
					 p.appendChild(label);
					 p.appendChild(newElement);
					 counter++;
				}
			}else {
				for (var i =1; i <= counter; i++){
					var newElem = document.getElementById(i)
					var lable1 = document.getElementById("label1");
					newElem.parentNode.removeChild(newElem);
					label1.parentNode.removeChild(label1);
				}
				counter = 1;
			}
		}
		
		function newChoices(entry){
			if(entry !== ""){
			var p = document.getElementById("choices");
			 var newElement = document.createElement("input");
			 var label = document.createElement("label");
			 label.setAttribute("id", "label1");
			 label.innerHTML ="</br></br><label>Choice "+counter+" </label>";
			 newElement.setAttribute("id", counter);
			 newElement.setAttribute("name", counter);
			 newElement.setAttribute("onChange","newChoices(this.value)");
			 p.appendChild(label);
			 p.appendChild(newElement);
			 counter++;
			}
		}
		
		
		function doReset(){
			if(counter == 0){
				var counter = document.getElementByID("counter").value;
			}
				for (var i =1; i <= counter; i++){
					var newElem = document.getElementById(i)
					var lable1 = document.getElementById("label1");
					newElem.parentNode.removeChild(newElem);
					label1.parentNode.removeChild(label1);
					counter--;
		}
	}
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
			</c:if>
		<input type="submit" name="submit" value="Delete Question" />
		<input type="reset" name="reset" value="Reset" onClick="doReset();" />
	</form>	
		 
</body>
</html>