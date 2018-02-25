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
	
	public GenerateSecurityQuery (String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			try {
				this.connection = DriverManager.getConnection(url, uname, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
