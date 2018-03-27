<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Course, dbHelpers.CheckCourse" %>
    <%
    Course course = new Course();
    course = (Course)request.getAttribute("course");
    String tempcourse= course.getCourseID();
    session.setAttribute("oldCourseID", tempcourse);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Southeast Regional Credit Union Schools Web Portal - Edit Course</title>
</head>
<body>
	<h1>Southeast Regional Credit Union Schools Web Portal</h1>
		<h3>Course Information</h3>
		<form name="update" action="update" method="post">
			<label>Course Code</label>
				<input type="text" name="courseID" value="<%=course.getCourseID() %>" required /></br></br>
				
			<label>Course Name</label>
				<input type="text" name="courseName" value="<%=course.getCourseName() %>" required /></br></br>
				
			<label>Credit Hours</label>
				<input type="number" name="creditHr" min="1" step="0.5" value="<%=course.getCreditHr()%>" required /></br></br>
				
			<label>Course Type</label>
				<select name="courseType"  required >
					<option value="<%=course.getCourseType() %>" selected><%=course.getCourseType() %></option>
					<option value="face-to-face">Face-to-face</option>
					<option value="webinar">Webinar</option>
					<option value="hybride">Hybrid</option>
				</select>	</br></br>		
			<label>Course Year</label>
				<select name="courseYear" required>
				<option value="<%=course.getClassYear()%>" selected><%=course.getClassYear()%></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="For all students">For all students</option>
			</select> </br></br>
				<input type="submit" value="Save Changes" />
		</form>		
		
				

</body>
</html>