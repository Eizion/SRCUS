package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.SecurityAnswer;

public class CheckAnswerQuery {
	
	private Connection connection;
	
	public CheckAnswerQuery(String dbName, String uname, String pwd) {
		
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
	
	public boolean checkEmptyAnswer(String email) {
		
		boolean emptyAnswer = true;
		String query = "select answer from security_answer, user where security_answer.user_id = user.user_id and email = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, email);
			
			ResultSet results = ps.executeQuery();
			
			if (results.next()) {
				emptyAnswer = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emptyAnswer;	
	}

}
