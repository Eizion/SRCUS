package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSecurityQuestionQuery {
	
	private Connection connection;
	
	public UpdateSecurityQuestionQuery(String dbName, String uname, String pwd) {
		
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
	
	public void updateAnswer(int sq_id, String answer, int user_id){
		
		String query = "update security_answer set sq_id=?, answer=? where user_id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, sq_id);
			ps.setString(2, answer);
			ps.setInt(3, user_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}