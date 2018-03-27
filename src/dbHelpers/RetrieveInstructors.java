/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Course;
import model.Evaluation;
import model.Instructor;

/**
 * @author Lideta
 *
 */
public class RetrieveInstructors {
	private Connection connection;
	private ResultSet result;
	
	public RetrieveInstructors(String dbName, String userName, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
 	}
	
	public ArrayList<Instructor> doRetrieve(){
	String query = "select  InstrID, FName, LName, Title from Instructor";
	Instructor instructor = null;
	ArrayList<Instructor> container = new ArrayList<Instructor>();
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		result = ps.executeQuery();
		while(this.result.next()){
			instructor = new Instructor(result.getString("InstrID"), result.getString("FName"), result.getString("LName"), result.getString("Title"));
			container.add(instructor);
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return container;
}
	
	public ArrayList<String> checkAssignment(String courseID, int year, String term){
		String query = "select  InstrID from Lectures where CourseID = ? and Year = ? and Term = ?";
		ArrayList<String> existing = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, courseID);
			ps.setInt(2, year);
			ps.setString(3, term);
			result = ps.executeQuery();
			while(this.result.next()){
				existing.add(result.getString("InstrID"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return existing;
	}
	
	public void doAssign(String[] instructors, String courseID, int year, String term) {
		String qry ="insert into Lectures (InstrID, CourseID, Year , Term) values (?, ? ,? ,? )";
		try {
			for(int i = 0; i < instructors.length; i++) {
			PreparedStatement ps = connection.prepareStatement(qry);
			ps.setString(1, instructors[i]);
			ps.setString(2, courseID);
			ps.setInt(3, year);
			ps.setString(4, term);
			ps.executeUpdate();
			}
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}		
	}
	
	public void deleteAssign(String courseID, int year, String term) {
		String qry ="delete from Lectures where CourseID = ? and  Year = ? and Term = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(qry);
			ps.setString(1, courseID);
			ps.setInt(2, year);
			ps.setString(3, term);
			ps.executeUpdate();
			}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}		
	}

}
