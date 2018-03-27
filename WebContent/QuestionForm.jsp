<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%@page import="model.Evaluation" %>
    <%
    	
    	Evaluation eval = (Evaluation)session.getAttribute("eval");
    	String questionNum = (String)session.getAttribute("questionNum");
    %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Create Evaluation</title>
	<script type="text/javascript">
		var counter=1;
		function addChoices(selected){
			var qType = document.getElementById("questionType").value;
			if(qType == "chooseOne" || qType == "multiSelect"){
				if(counter == 1){
				 var p = document.getElementById("choices");
				 var newElement = document.createElement("input");
				 var label = document.createElement("label");
				 label.setAttribute("id", "label1");
				 label.innerHTML ="</br></br><label>Choice "+counter+ " " +"</label>";
				 newElement.setAttribute("id", counter);
				 newElement.setAttribute("name", counter);
				 newElement.setAttribute("onChange","newChoices(this.value)");
				 p.appendChild(label);
				 p.appendChild(newElement);
				 counter++;
				}else if(counter > 1){
					for (var i =1; i <= counter; i++){
						var newElem = document.getElementById(i)
						var lable1 = document.getElementById("label1");
						newElem.parentNode.removeChild(newElem);
						label1.parentNode.removeChild(label1);
						counter--;
					}
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
					counter--;
					}
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
		<form name="evalQuestions" action="addQuestions" method="post">
			<label>Enter question number <%=questionNum %></label></br></br>
			<textarea name="question" value="" rows="5" cols="40" required></textarea></br></br>
		
			<label>Type of question</label>
				<select name="questionType"  id="questionType"  onChange="addChoices(this.value);" required>
					<option value=""></option>
					<option value="chooseOne">Choose one</option>
					<option value="multiSelect">Multi select</option>
					<option value="giveAnswer">Give answer</option>
				</select> </br></br>
		
			<div id="choices"></div></br>
				<input type="submit" name= "submit" value="Save & Continue" />
				<input type="submit" name= "submit" value="Finish" />
		
		<input type="reset" name="reset" value="Reset" onClick="doReset()"/>
	</form>	
		 
</body>
</html>