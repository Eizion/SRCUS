package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import model.Course;

public class CheckCourse {
	private Connection connection;
	private ResultSet result;
	
	public CheckCourse(String dbName, String userName, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
 	}

	public Course doCheckID(String courseID){
		String query = "select * from Course where CourseID = ?";
		Course course = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,courseID);
			result = ps.executeQuery();
			if(this.result.next()){
				course = new Course(result.getString("CourseID"), result.getString("CourseName"), result.getDouble("CreditHr"), result.getString("CourseType"), result.getString("CourseYear"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;
}
	
	public Course doCheckName(String courseName){
		String query = "select * from Course where CourseName = ?";
		Course course = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,courseName);
			result = ps.executeQuery();
			if(this.result.next()){
				course = new Course(result.getString("CourseID"), result.getString("CourseName"), result.getDouble("CreditHr"), result.getString("CourseType"), result.getString("CourseYear"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;
}
}
