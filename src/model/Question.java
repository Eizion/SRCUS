/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Lideta
 *
 */
public class Question implements Serializable{
	private String question;
	private String questionType;
	private ArrayList<String> choices;
	
	public Question(String question, String questionType, ArrayList<String> choices) {
		this.question = question;
		this.questionType = questionType;
		this.choices = choices;
	}

	public Question() {
		// default constructor 
		question = "";
		questionType= "";
		choices = new ArrayList<String>();
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}

	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/**
	 * @return the choices
	 */
	public ArrayList<String> getChoices() {
		return choices;
	}

	/**
	 * @param choices the choices to set
	 */
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

}
