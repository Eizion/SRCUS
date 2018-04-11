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


import model.Evaluation;
import model.Question;


/**
 * @author Lideta
 *
 */
public class RetrieveQuestion {
	private Connection connection;
	private ResultSet result;
	private Question[] container;
	ArrayList<String> choices;
	
	public RetrieveQuestion(String dbName, String username, String pwd){
		String url="jdbc:mysql://localhost:3306/" + dbName;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Question[] getquestion(Evaluation eval) {
		int evalID = eval.getEvalID();
		int i = 0;
		String query = "select * from EvaluationQuestions where EvalID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,evalID);
			result = ps.executeQuery();
			result.last();
			int counts = result.getRow();
			container = new Question[counts];
			result.beforeFirst();
			while(this.result.next()){
				String qType = result.getString("QuestionType");
				int qNum = result.getInt("QuestionNum");
					if(qType.equals("chooseOne") || qType.equals("multiSelect")) {
						//call getChoices method to get the options for the question
						choices = getChoices(evalID,qNum);
					}
					Question q= new Question(result.getString("Question"),result.getString("QuestionType"), choices);
					container[i] = q;
					i++;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}
	
	public ArrayList<String> getChoices(int evalID, int qNum) {
		String query = "select * from Choices where EvalID = ? and QuestionNum = ?";
		ResultSet res;
		ArrayList<String> choices = new ArrayList<String>();
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, qNum);
			res = ps.executeQuery();
			while(res.next()) {
				choices.add(res.getString("Choice"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return choices;
	}
	
	

}
