/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author Lideta
 *
 */
public class Evaluation implements Serializable{
	private String instructorID;
	private String courseID;
	private int evalID;
	private int year;
	private String term;
	/**
	 * Default constructor
	 */
	public Evaluation() {
		// TODO Auto-generated constructor stub
		this.courseID = "";
		this.evalID = 0;
		this.instructorID = "";
		this.term = "";
		this.year = 0;
			
	}
	/**
	 * @param instructorID
	 * @param courseID
	 * @param evalID
	 * @param year
	 * @param term
	 */
	public Evaluation(String instructorID, String courseID, int evalID, int year, String term) {
		this.instructorID = instructorID;
		this.courseID = courseID;
		this.evalID = evalID;
		this.year = year;
		this.term = term;
	}
	/**
	 * @return the instructorID
	 */
	public String getInstructorID() {
		return instructorID;
	}
	/**
	 * @param instructorID the instructorID to set
	 */
	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}
	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	/**
	 * @return the evalID
	 */
	public int getEvalID() {
		return evalID;
	}
	/**
	 * @param evalID the evalID to set
	 */
	public void setEvalID(int evalID) {
		this.evalID = evalID;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	

}
