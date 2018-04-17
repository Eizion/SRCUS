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

/**
 * @author Lideta
 *
 */
public class UpdateQuestion {
	
private Connection connection;
	
	public UpdateQuestion(){
		connection = MyDbConnection.getConnection();
	}
	
	
	public void updateQuestion(String question, String questionType, Evaluation eval, int questionNum){
		String query = "update EvaluationQuestions set Question=?, QuestionType=? where EvalID = ? and QuestionNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, question);
			ps.setString(2, questionType);
			ps.setInt(3, eval.getEvalID());
			ps.setInt(4, questionNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	public int getChoices(int evalID, int qNum) {
		String query = "select * from Choices where EvalID = ? and QuestionNum = ?";
		ResultSet res;
		int rows = 0;
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, qNum);
			res = ps.executeQuery();
			res.last();
			rows = res.getRow();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	public void updateChoices(ArrayList<String> choices, Evaluation eval, int questionNum) {
		int rows = getChoices(eval.getEvalID(),questionNum); //to get count of existing rows
		String query = "";
		if(rows > 0) { 
			query ="update Choices set Choice = ? where EvalID = ? and QuestionNum = ? and ChoiceNum = ?";
		}else if(rows == 0) { //TO insert new rows into table
			query ="insert into Choices (Choice, EvalID, QuestionNum, ChoiceNum) values (?, ? ,? ,? )";
		}
		for(int i = 0; i < choices.size(); i++) {
				try {
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, choices.get(i));
					ps.setInt(2, eval.getEvalID());
					ps.setInt(3, questionNum);
					ps.setInt(4, i+1);
					ps.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
		}
}
	
	public void insertChoices(ArrayList<String> choices, Evaluation eval, int questionNum) {
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
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}	
		}
	}	
}
	
	public void doDelete(Evaluation eval, int questionNum, String questionType) {
		String query = "delete from EvaluationQuestions where EvalID = ? and QuestionNum = ?";
		try {
			if(questionType.equals("chooseOne") || questionType.equals("multiSelect")) {
				String qry = "delete from Choices where EvalID = ? and QuestionNum = ?";
				PreparedStatement ps = connection.prepareStatement(qry);
				ps.setInt(1, eval.getEvalID());
				ps.setInt(2, questionNum);
				ps.executeUpdate();
			}
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eval.getEvalID());
			ps.setInt(2, questionNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteChoices(Evaluation eval, int questionNum) {
		int rows = getChoices(eval.getEvalID(),questionNum); 
		if(rows > 0) {
		try {
		String qry = "delete from Choices where EvalID = ? and QuestionNum = ?";
		PreparedStatement ps = connection.prepareStatement(qry);
		ps.setInt(1, eval.getEvalID());
		ps.setInt(2, questionNum);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	
	public void deleteEvaluation(Evaluation eval) {
		String query = "delete from Evaluation where EvalID = ? ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eval.getEvalID());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateTable(Evaluation eval, int questionNum, int rows ){
		for(int i = questionNum + 1; i <= rows; i++ ) {
		String query = "update EvaluationQuestions set QuestionNum =? where EvalID = ? and QuestionNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, questionNum);
			ps.setInt(2, eval.getEvalID());
			ps.setInt(3, i);
			ps.executeUpdate();
			questionNum++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	}

}
