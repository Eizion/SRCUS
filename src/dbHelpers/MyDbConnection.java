package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * In this example, we encapsulate the database connection code
 * into a single class, and add a bit of error checking.
 * 
 * This class uses the "Singleton" pattern. Only one instance 
 * of Connection is ever created. If the instance already exists
 * that reference is returned. If no instance exists, one is created.
 */
public class MyDbConnection {
	
	private static final String dbName = "srcus_master";
	private static final String dbUser = "root";
	private static final String dbPwd  = "root";
	
	private static Connection connection = null;
	private MyDbConnection () {}
	
	public static Connection getConnection() {
		if (connection != null) {
			return connection;
		}
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, dbUser, dbPwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// NOTE: Errors that occur here will show in the Console, but will not
			// stop the web app from running. These errors could be handled better.
			e.printStackTrace();
		}
		
		if (connection == null) {
			throw new RuntimeException("Error connecting to database.");
		}
		
		return connection;
	}	
}