package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckAnswerQuery {
	
	private Connection connection;
	
	public CheckAnswerQuery() {
		connection = MyDbConnection.getConnection();
	}
	
	public boolean checkEmptyAnswer(String email) {
		
		boolean emptyAnswer = true;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select answer from security_answer, user where security_answer.user_id = user.user_id and email = ?");
			
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
