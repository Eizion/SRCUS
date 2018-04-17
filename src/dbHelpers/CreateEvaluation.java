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
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import model.Course;
import model.Evaluation;
import model.User;


/**
 * @author Lideta
 *
 */
public class CreateEvaluation {
	private Connection connection;
	private ResultSet result;
	
	public CreateEvaluation(){
		connection = MyDbConnection.getConnection();
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
	
	public String checkActivationEvaluation(Evaluation existing) {
		String message = "";
		String query = "select ActivationDate, SubmissionDeadline from Evaluation where EvalID=?";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		format = format.withLocale( Locale.US );
		LocalDate today = LocalDate.now();
		String activeDate = "";
		String submission= "";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,existing.getEvalID());
			result = ps.executeQuery();
			if(this.result.next()){
			 activeDate = result.getDate("ActivationDate").toString();
			 submission = result.getDate("SubmissionDeadline").toString();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(today.isBefore(LocalDate.parse(activeDate, format))) {//Before activation date
			message="This evaluation is not open yet";
		}else if(today.isAfter( LocalDate.parse(submission, format))) { //After submission date
			message="This evaluation's deadline was on " + submission;
		}
		return message;
		
	}
	
	
	public boolean  checkStatus(Evaluation existing, User user) {//return true if student has submitted evaluation already
		boolean complete = false;
		String query = "select Status from Assignments where EvalID=? and StudentID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,existing.getEvalID());
			ps.setInt(2, user.getId());
			result = ps.executeQuery();
			if(this.result.next()){
				String status = result.getString("Status");
				if(status.equals("completed")) {
					complete = true;
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complete;
	}
		
		
	}