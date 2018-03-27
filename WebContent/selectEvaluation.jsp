<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%
   String message = (String)request.getAttribute("message");
   %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Create Evaluation</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
		//function to generate the options range for the year input box
		window.onload=function(){
			for(var i=2015; i<=2020; i++){
    			var select = document.getElementById("year");
    			var option = document.createElement("OPTION");
    			select.options.add(option);
   			 	option.text = i;
    			option.value = i;
			}
		};
		</script>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Select Evaluation</h3>
		<sql:setDataSource var = "srcus" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/srcus_master"
         user = "root"  password = "root"/>
		<c:catch var="e">
         <sql:query dataSource = "${srcus}" var = "instructor">
            SELECT InstrID, FName, LName, Title  from Instructor;
         </sql:query>
		
		<sql:query dataSource = "${srcus}" var = "course">
            SELECT CourseID, CourseName  from Course;
         </sql:query>
         </c:catch>
         <c:if test="${e != null }">
         	<p> An exception occured.Message: ${e.message }</p>
         </c:if>
		<form name="evaluation" action="selectEvaluation" method="post">
    			<table>
    				<tr>
    					<td><label>Instructor Name:</label></td>
     					<td><select name="instrID" id="instrID" >
           					<option value="" selected="selected"></option>
								<c:forEach var="row" items="${instructor.rows}" >
									<option value="${row.InstrID}">${row.Title}. ${row.FName} ${row.LName }</option>  
								</c:forEach>
							</select>
						</td>
     				</tr>
     				<tr>
     				
     					<td><label>Course Name:</label></td>
     					<td><select name="courseID" id="courseID" >
							<option value="" selected="selected"></option>
								<c:forEach var="row" items="${course.rows}" >
									<option value="${row.CourseID}">${row.CourseID}:${row.CourseName}</option>  
								</c:forEach>
							</select>
						</td>
     				</tr>
     				<tr>
     					<td><label>Year:</label></td>
     					<td><select name="year" id="year" required>
     						<option value="" selected="selected"></option>
     						</select>
     					</td>
     				</tr>
     				<tr>
	    				<td><label>Term:</label></td>
     					<td><select name="term" id="term" required>
     						<option value="" selected="selected"></option>
     						<option value="spring">Spring Semester</option>
     						<option value="fall">Fall Semester</option>
     						<option value="summer">Summer Semester</option>
     						</select>
     					</td>
     				</tr>
     				<tr>
	    			
     				<tr>
     					<td><input type="submit" name="submit" value="Open Evaluation"></td>
     					<td><input type="reset" name="reset" value="Reset" /></td>
     					</tr>
     			</table>
     			${message}
  		</form>

</body>
</html>