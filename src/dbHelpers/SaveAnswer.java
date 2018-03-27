/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * @author Lideta
 *
 */
public class SaveAnswer {
	
	private Connection connection;
	
	public SaveAnswer(String dbName, String username, String pwd){
		String url="jdbc:mysql://localhost:3306/" + dbName;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doSave(int evalID, int questionNum, String studentID, String answer){
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
			ps.setString(4, studentID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getFeedback(int evalID, int questionNum, String studentID) {
		String query = "select Answer from Feedback where EvalID = ? and QuestionNum = ? and StudentID = ?";
		String answer="";
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, questionNum);
			ps.setString(3, studentID);
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
