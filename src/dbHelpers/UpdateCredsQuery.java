package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.SecurityAnswer;

public class UpdateCredsQuery {
	
private Connection connection;
	
	public UpdateCredsQuery() {
		connection = MyDbConnection.getConnection();
	}
	
	public void addAnswers(SecurityAnswer answer) {
		
		String query = "insert into security_answer (sq_id, user_id, answer) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, answer.getSq_id());
			ps.setInt(2, answer.getUser_id());
			ps.setString(3, answer.getAnswer());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void updatePassword(String encryptedPass, String email){
		
		String query = "update user set password=? where email=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, encryptedPass);
			ps.setString(2, email);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
