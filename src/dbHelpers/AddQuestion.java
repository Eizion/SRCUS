/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Evaluation;

/**
 * @author Lideta
 *
 */
public class AddQuestion {
private Connection connection;
	
	public AddQuestion(String dbName, String username, String pwd){
		String url="jdbc:mysql://localhost:3306/" + dbName;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAddQuestion(String question, String questionType, Evaluation eval, int questionNum) {
		String query ="insert into EvaluationQuestions (EvalID, QuestionNum, Question, QuestionType) values (?, ? ,? ,? )";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eval.getEvalID());
			ps.setInt(2, questionNum);
			ps.setString(3, question);
			ps.setString(4, questionType);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
	}
		
	public void insertChoices(String questionType, ArrayList<String> choices, Evaluation eval, int questionNum) {
		for(int i = 0; i < choices.size(); i++) {
			if(choices.get(i) != "") {
				String qry ="insert into Choices (EvalID, QuestionNum, ChoiceNum, Choice) values (?, ? ,? ,? )";
				try {
					PreparedStatement ps = connection.prepareStatement(qry);
					ps.setInt(1, eval.getEvalID());
					ps.setInt(2, questionNum);
					ps.setInt(3, i+1);
					ps.setString(4, choices.get(i));
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
	}
	
	

}
