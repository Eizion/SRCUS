package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class CheckUserQuery {
	
	private PreparedStatement checkUserStatement;
	private Connection connection;
	
	public CheckUserQuery () {

		//String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = MyDbConnection.getConnection();
			
			checkUserStatement = connection.prepareStatement("select * from user where email = ?");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public User checkUser(String email) {

		User user = null;
		
		try {
			checkUserStatement.setString(1, email);
			ResultSet rs = checkUserStatement.executeQuery();
			
			if (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("password"), rs.getString("fName"), rs.getString("lName"), rs.getInt("role"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}
	
	public int getUserId(String email) {
		
		int userID = 0;
		
		String query = "select userID from user where email = ?";
		
		try {
			checkUserStatement.setString(1, email);
			ResultSet rs = checkUserStatement.executeQuery();
			
			if (rs.next()) {
				userID = rs.getInt("user_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return userID;
	}

}
