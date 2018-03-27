<%@page import="org.eclipse.jdt.internal.compiler.ast.ThisReference"%>
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
<title>Southeast Regional Credit Union Schools Web Portal - Edit Course</title>

</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Edit Course Information</h3>
		<h5>Select the course to be edited</h5>
		<sql:setDataSource var = "srcus" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/srcus_master"
         user = "root"  password = "root"/>
		
         <sql:query dataSource = "${srcus}" var = "result">
            SELECT CourseID, CourseName from Course;
         </sql:query>
         
		<form name="editCourse" action ="editCourse" method="post">
			<label>Course Code</label></br>
			<select name="courseID">
			<option value="" selected="selected">---------------</option>
			<c:forEach var="row" items="${result.rows}" >
				<option value="${row.CourseID}">${row.CourseID}:${row.CourseName}</option>  
			</c:forEach>
			</select></br></br>
			
	
			<input type="submit" name="submit" value="Edit" />
			<input type="submit" name="submit" value="Assign Instructors" />
			<input type="submit" name= "submit" value="Assign Students" />
			
		</form>
		${message}
</body>
</html>