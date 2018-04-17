/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author Lideta
 *
 */
public class Student implements Serializable{
	private int studentID;
	private String fName;
	private String lName;
	private int year;
	
	/**
	 * 
	 */
	public Student(){
		this.studentID = 0;
		this.fName = "";
		this.lName = "";
		this.year = 1;
	}

	/**
	 * @param studentID
	 * @param fName
	 * @param lName
	 * @param year
	 */
	public Student(int studentID, String fName, String lName, int year) {
		this.studentID = studentID;
		this.fName = fName;
		this.lName = lName;
		this.year = year;

	}

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
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

	

}
