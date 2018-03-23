package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class RegisterQuery {
	
	private Connection connection;
	
	public RegisterQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRegister(User user) {
		
		String query = "insert into user (email, password, fName, lName, role) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getfName());
			ps.setString(4, user.getlName());
			ps.setInt(5, user.getRole());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
