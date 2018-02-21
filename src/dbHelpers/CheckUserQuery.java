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
	
	public CheckUserQuery (String dbName, String uname, String pwd) {

		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
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
				user = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("password"), rs.getString("fName"), rs.getString("lName"), rs.getString("role"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}

}
