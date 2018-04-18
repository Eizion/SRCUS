/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Course;

/**
 * @author Lideta
 *
 */
public class UpdateCourse {
	private Connection connection;
	
	public UpdateCourse(){
		connection = MyDbConnection.getConnection();
	}
	
	public void doUpdate(Course course, String oldCourseID){
		String query = "update Course set CourseID=?, CourseName=?, CreditHr=?, CourseType=?, CourseYear=? where CourseID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, course.getCourseID());
			ps.setString(2, course.getCourseName());
			ps.setDouble(3, course.getCreditHr());
			ps.setString(4, course.getCourseType());
			ps.setString(5, course.getClassYear());
			ps.setString(6, oldCourseID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
