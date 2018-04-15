package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenerateSecurityQuery {
	
	private PreparedStatement checkUserStatement;
	private ResultSet results;
	private Connection connection;
	
	public GenerateSecurityQuery () {
		connection = MyDbConnection.getConnection();
	}
	
	public void getSecurityQuestionAll(){
		String query = "SELECT * FROM security_question";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			this.results = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	
	
}
