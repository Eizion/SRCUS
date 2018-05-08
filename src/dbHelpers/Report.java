/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import model.Course;
import model.Evaluation;
import model.Instructor;
import model.Question;

/**
 * @author Lideta
 *
 */
public class Report {
	private Connection connection;
	private ResultSet result;
	
	public Report(){
		connection = MyDbConnection.getConnection();
 	}
	
	public int tally(int evalID,int questionNum, String choice) {
		int tally = 0;
		String query = "select  count(Answer) from Feedback where EvalID = ? and  QuestionNum = ? and  Answer = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, questionNum);
			ps.setString(3, choice);
			result = ps.executeQuery();
			while(this.result.next()){
				tally = result.getInt("count(Answer)");
		
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tally;
	}
	
	public ArrayList<String> writenAnswers(int evalID, int questionNum){
		ArrayList<String> answers = new ArrayList<String>();
		String query = "select  Answer from Feedback where EvalID = ? and QuestionNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, questionNum);
			result = ps.executeQuery();
			while(this.result.next()){
				if(result.getString("Answer") != null){
				answers.add(result.getString("Answer"));
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}
	
	public Course getCourse(String courseID){
		String query = "select * from Course where CourseID = ?";
		Course course = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,courseID);
			result = ps.executeQuery();
			if(this.result.next()){
				course = new Course(result.getString("CourseID"), result.getString("CourseName"), result.getDouble("CreditHr"), result.getString("CourseType"), result.getString("CourseYear"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;
}
	
	public Instructor getInstructor(String instrID){
		String query = "select  * from Instructor where InstrID = ?";
		Instructor instructor = null;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, instrID);
			result = ps.executeQuery();
			if(this.result.next()){
				instructor = new Instructor(result.getInt("InstrID"), result.getString("FName"), result.getString("LName"), result.getString("Title"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return instructor;
	}
	
	public ArrayList<String> getAnswers(int evalID, int questionNum){
		ArrayList<String> answers = new ArrayList<String>(); 
		String[] temp;
		String query = "select  Answer from Feedback where EvalID = ? and QuestionNum = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, evalID);
			ps.setInt(2, questionNum);
			result = ps.executeQuery();
			while(this.result.next()){
				if(result.getString("Answer") != null){
					String ans = result.getString("Answer");
					if(ans.contains("^")) {
						temp = ans.split(Pattern.quote("^"));
						for(int i = 0 ; i < temp.length; i ++) {
							answers.add(temp[i]);
						}
					}
				answers.add(ans);
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answers;
	}
	
	public String generateReport(Evaluation eval,Question[] container, int year, Course course, Instructor instructor) {
		int evalID = eval.getEvalID();
		String message="";
		Question current = new Question();
		message += "<p>";
		message += "<table class='table table-striped'>";
		ArrayList<String> choices = new ArrayList<String>();
			for(int i= 0; i < container.length; i++) {
				current = container[i];
				int questionNum = i+1;
				if(current.getQuestionType().equals("chooseOne")) {
					choices = current.getChoices();
					double totTally = 0.00;
					double totWeighdTally = 0.00;
					double meanScore = 0.00;
					message +="<tr>";
					message +="<th>Choice / Value </th>";
					for(int m = 0; m < choices.size(); m++) {
						int value = m+1;
						message += "<th>"+ choices.get(m) +" / " + value  +"</th>";  //header for each question
					}
					message += "<th>"+ "Mean Score" +"</th>";
					message += "</tr>";
					message += "<tr>";
					message += "<td>"+ questionNum + "." +current.getQuestion()+ "</td>";  //displays the question
					for (int j = 0; j < choices.size(); j ++) {         //to find the tally of choices
						int choiceNum = j+1;
						int count = tally(evalID, questionNum, choices.get(j));
						totTally += count;
						totWeighdTally += count * choiceNum;
						message += "<td>" + count + "</td>"; 
					}
					meanScore = (totWeighdTally / totTally);    //to calculate mean score
					DecimalFormat df = new DecimalFormat(".##");
					message += "<td>" + df.format(meanScore)+"</td>";
				}else if(current.getQuestionType().equals("multiSelect")) {
					choices = current.getChoices();
					double totTally = 0.00;
					double totWeighdTally = 0.00;
					double meanScore = 0.00;
					message +="<tr>";
					message +="<th>Choice / Value </th>";
					for(int m = 0; m < choices.size(); m++) {
						int value = m+1;
						message += "<th>"+ choices.get(m) +" / " + value  +"</th>";  //header for each question
					}
					message += "<th>"+ "Mean Score" +"</th>";
					message += "</tr>";
					message += "<tr>";
					message += "<td>"+ questionNum + "." +current.getQuestion()+ "</td>";  //displays the question
					ArrayList<String> answers=getAnswers(evalID, questionNum);
					int count = 0;
					for (int j = 0; j < choices.size(); j ++) {
						int choiceNum = j+1;
						String choice = choices.get(j);
						for(int m = 0; m < answers.size(); m++) { //to get the tally of each choice
							if(answers.get(m).equals(choice)) {
								count ++;
							}
						}
						totTally += count;
						totWeighdTally += count * choiceNum;
						message += "<td>" + count + "</td>";
						count = 0;
					}
					meanScore = (totWeighdTally / totTally);    //to calculate mean score
					DecimalFormat df = new DecimalFormat(".##");
					message += "<td>" + df.format(meanScore)+"</td>";
				}
				else if(current.getQuestionType().equals("giveAnswer")) {
					message += "<tr>";
					message += "<td>"+ questionNum + " ." +current.getQuestion()+ "</td>";
					message += "</tr>";
					ArrayList<String> writenAnswers = writenAnswers(evalID, questionNum);
					for(int m= 0; m < writenAnswers.size(); m++) {
						message += "<tr>";
						message += "<td>" + writenAnswers.get(m)+ "</td>";
						message += "</tr>";
					}
				}
			}
			message += "</table>";
			message += "</p>";
		return message;
	}

}
