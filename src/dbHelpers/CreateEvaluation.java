/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import model.Course;
import model.Evaluation;


/**
 * @author Lideta
 *
 */
public class CreateEvaluation {
	private Connection connection;
	private ResultSet result;
	
	public CreateEvaluation(String dbName, String username, String pwd){
		String url="jdbc:mysql://localhost:3306/" + dbName;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getInstrID(String[] iName){
		String instrID="";
		String query = "select InstrID from Instructor where Title=?, FName= ?, LName=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,iName[0]);
			ps.setString(2,iName[1]);
			ps.setString(3,iName[2]);
			result = ps.executeQuery();
			if(this.result.next()){
				instrID=result.getString("InstrID");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instrID;
		
	}
	
	
	
	
	public void doCreate(String instrID, String courseID, int year, String term, String activeDate, String submDate){
		//String AdminID to add in future
		//converting string activeDate and submDate to LocalDate format to insert into database
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		format = format.withLocale( Locale.US );
		LocalDate activeD = LocalDate.parse(activeDate, format);
		LocalDate submD = LocalDate.parse(submDate, format);
		LocalDate createDate = LocalDate.now();
	
		
		String query ="insert into Evaluation (InstrID, CourseID, Year, Term, DateCreated, ActivationDate, SubmissionDeadline) values (?, ? ,? ,? ,? ,? ,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, instrID);
			ps.setString(2, courseID);
			ps.setInt(3, year);
			ps.setString(4, term);
			ps.setDate(5, java.sql.Date.valueOf(createDate));
			ps.setDate(6, java.sql.Date.valueOf(activeD));
			ps.setDate(7, java.sql.Date.valueOf(submD));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public Evaluation doCheck(String instrID, String courseID, int year, String term) {
		String query = "select * from Evaluation where InstrID = ? and CourseID = ? and Year = ? and Term = ?";
		Evaluation existing = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,instrID);
			ps.setString(2,courseID);
			ps.setInt(3,year);
			ps.setString(4,term);
			result = ps.executeQuery();
			if(this.result.next()){
				existing = new Evaluation(result.getString("InstrID"), result.getString("CourseID"), result.getInt("EvalID"), result.getInt("year"), result.getString("term"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return existing;
	}
	
	public int retrieveEvalID(String instrID, String courseID, int year, String term) {
		int EvalID = 0;
		String query = "select EvalID from Evaluation where InstrID = ? and CourseID = ? and Year = ? and Term = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,instrID);
			ps.setString(2,courseID);
			ps.setInt(3,year);
			ps.setString(4,term);
			result = ps.executeQuery();
			if(this.result.next()){
			 EvalID = result.getInt("EvalID");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EvalID;
	}
		
		
	}