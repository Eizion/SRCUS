/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author Lideta
 *
 */
public class Course implements Serializable {
	
	private String courseID;
	private String courseName;
	private Double creditHr;
	private String courseType;
	private String classYear;
	
	/**
	 * default constructor
	 */
	public Course() {
	}

	/**
	 * @param courseID
	 * @param courseName
	 * @param creditHr
	 */
	public Course(String courseID, String courseName, Double creditHr, String courseType, String classYear) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.creditHr = creditHr;
		this.courseType = courseType;
		this.classYear = classYear;
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the creditHr
	 */
	public Double getCreditHr() {
		return creditHr;
	}

	/**
	 * @param creditHr the creditHr to set
	 */
	public void setCreditHr(Double creditHr) {
		this.creditHr = creditHr;
	}

	/**
	 * @return the courseType
	 */
	public String getCourseType() {
		return courseType;
	}

	/**
	 * @param courseType the courseType to set
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	/**
	 * @return the classYear
	 */
	public String getClassYear() {
		return classYear;
	}

	/**
	 * @param classYear the classYear to set
	 */
	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}
	
	

}
