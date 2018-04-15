package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.SecurityAnswer;
import model.SecurityQuestion;

public class ForgotPasswordQuery {
	
	private Connection connection;
	private ResultSet results;
	
	private SecurityAnswer securityAnswer = new SecurityAnswer();
	private SecurityQuestion securityQuestion = new SecurityQuestion();
	
	public ForgotPasswordQuery () {
		connection = MyDbConnection.getConnection();
	}
	
	public void getAnswers(int user_id) {
		
		String query = "select * from security_answer where user_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, user_id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			securityAnswer.setAn_id(this.results.getInt(1));
			securityAnswer.setSq_id(this.results.getInt(2));
			securityAnswer.setUser_id(this.results.getInt(3));
			securityAnswer.setAnswer(this.results.getString(4));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public SecurityAnswer getSecurityAnswer(){
		return this.securityAnswer;
	}
	
	public void getQuestions(int sq_id) {
		
		String query = "select * from security_question where sq_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, sq_id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			securityQuestion.setS_question(this.results.getString(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SecurityQuestion getSecurityQuestion(){
		return this.securityQuestion;
	}
	
}
