package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Course;


public class AddCourse {

	private Connection connection;
	
	public AddCourse(){
		connection = MyDbConnection.getConnection();
	}
	
	public void doAdd(Course course){
		String query ="insert into Course (CourseID, CourseName, CreditHr, CourseType, CourseYear) values (?, ? ,? ,? ,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, course.getCourseID());
			ps.setString(2, course.getCourseName());
			ps.setDouble(3, course.getCreditHr());
			ps.setString(4, course.getCourseType());
			ps.setString(5, course.getClassYear());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	
}
