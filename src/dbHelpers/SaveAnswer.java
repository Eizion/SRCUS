/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



/**
 * @author Lideta
 *
 */
public class SaveAnswer {
	
	private Connection connection;
	
	public SaveAnswer(){
		connection = MyDbConnection.getConnection();
	}
	
	
	public void doSave(int evalID, int questionNum, int studentID, String answer){
		String query = "";
		if(getFeedback(evalID, questionNum, studentID) == "") {
			query ="insert into Feedback (Answer, EvalID, QuestionNum, StudentID ) values (?, ? ,? ,? )";
		}else {
		  query ="update  Feedback set Answer = ? where EvalID = ? and QuestionNum = ? and StudentID = ? ";
		}
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, answer);
			ps.setInt(2, evalID);
			ps.setInt(3, questionNum);
			ps.setInt(4, studentID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void finalSubmit(int evalID, int studentID) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		format = format.withLocale( Locale.US );
		LocalDate submissionDate = LocalDate.now();
		String query ="update  Assignments set Status =?, SubmissionDate = ? where EvalID = ? and StudentID = ? ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, "completed");
			ps.setDate(2, java.sql.Date.valueOf(submissionDate));
			ps.setInt(3, evalID);
			ps.setInt(4, studentID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public String getFeedback(int evalID, int questionNum, int studentID) {
		String query = "select Answer from Feedback where EvalID = ? and QuestionNum = ? and StudentID = ?";
		String answer="";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, questionNum);
			ps.setInt(3, studentID);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				answer = res.getString("Answer");
			}
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answer;
	}

}
