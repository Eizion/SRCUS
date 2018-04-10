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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h3>Evaluation Information</h3>
        <sql:setDataSource var = "srcus" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/srcus_master"
         user = "root"  password = "root"/>
        
         <sql:query dataSource = "${srcus}" var = "instructor">
            SELECT InstrID, FName, LName, Title  from Instructor;
         </sql:query>
        
        <sql:query dataSource = "${srcus}" var = "course">
            SELECT CourseID, CourseName  from Course;
         </sql:query>
         
        <form name="evaluation" action="createEvaluation" method="post">
                <table>
                    <tr>
                        <td><label>Instructor Name:</label></td>
                        <td><select name="instrID" id="instrID" >
                            <option value="" selected="selected"></option>
                                <c:forEach var="row" items="${instructor.rows}" >
                                    <option value="${row.InstrID}">${row.Title} ${row.FName} ${row.LName }</option>  
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
                        <td><label>Activation Date:</label></td>
                        <td><input type="date" name="activeDate" required/></td>
                    </tr>
                    <tr>
                        <td><label>Submission Deadline:</label></td>
                        <td><input type="date" name="submDate" required/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" value="save and Continue"></td>
                        <td><input type="reset" name="reset" value="Reset" /></td>
                        </tr>
                </table>
                ${message}
        </form>
</body>
</html>