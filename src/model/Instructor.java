/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author Lideta
 *
 */
public class Instructor implements Serializable{
	private int instrID;
	private String fName;
	private String lName;
	private String title;
	
	public Instructor() {
		this.instrID = 0;
		this.fName = "";
		this.lName = "";
		this.title = "";
		
	}

	/**
	 * @param instrID
	 * @param fName
	 * @param lName
	 * @param title
	 */
	public Instructor(int instrID, String fName, String lName, String title) {
		this.instrID = instrID;
		this.fName = fName;
		this.lName = lName;
		this.title = title;
	}

	/**
	 * @return the instrID
	 */
	public int getInstrID() {
		return instrID;
	}

	/**
	 * @param instrID the instrID to set
	 */
	public void setInstrID(int instrID) {
		this.instrID = instrID;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	

}
