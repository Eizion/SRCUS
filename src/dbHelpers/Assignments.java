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

import model.Course;
import model.Evaluation;
import model.Instructor;
import model.Student;

/**
 * @author Lideta
 *
 */
public class Assignments {
	private Connection connection;
	private ResultSet result;
	
	public Assignments(String dbName, String userName, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, userName, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
 	}
	
	public ArrayList<Instructor> retrieveInstructors(){
	String query = "select  InstrID, FName, LName, Title from Instructor";
	Instructor instructor = null;
	ArrayList<Instructor> container = new ArrayList<Instructor>();
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		result = ps.executeQuery();
		while(this.result.next()){
			instructor = new Instructor(result.getString("InstrID"), result.getString("FName"), result.getString("LName"), result.getString("Title"));
			container.add(instructor);
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return container;
}
	
	
	public ArrayList<Student> retrieveAllStudents(){
		String query = "select StudentID, FName, LName, Year from Student";
	Student student = null;
	ArrayList<Student> container = new ArrayList<Student>();
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		result = ps.executeQuery();
		while(this.result.next()){
			student = new Student(result.getString("StudentID"), result.getString("FName"), result.getString("LName"), result.getInt("Year"));
			container.add(student);
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return container;
}
	
	
	public ArrayList<Student> retrieveSelectStudents(String level){
	String query = "select StudentID, FName, LName , Year from Student where Year = ?";
	Student student = null;
	ArrayList<Student> container = new ArrayList<Student>();
	try {
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, Integer.parseInt(level));
		result = ps.executeQuery();
		while(this.result.next()){
			student = new Student(result.getString("StudentID"), result.getString("FName"), result.getString("LName"), result.getInt("Year"));
			container.add(student);
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return container;
}
	
	public ArrayList<String> checkInstructorAssignment(String courseID, int year, String term){
		String query = "select  InstrID from Lectures where CourseID = ? and Year = ? and Term = ?";
		ArrayList<String> existing = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, courseID);
			ps.setInt(2, year);
			ps.setString(3, term);
			result = ps.executeQuery();
			while(this.result.next()){
				existing.add(result.getString("InstrID"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return existing;
	}
	
	public ArrayList<String> checkStudentAssignments(String courseID, int year, String term){
		String query = "select  StudentID from Attend where CourseID = ? and Year = ? and Term = ?";
		ArrayList<String> existing = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, courseID);
			ps.setInt(2, year);
			ps.setString(3, term);
			result = ps.executeQuery();
			while(this.result.next()){
				existing.add(result.getString("InstrID"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		return existing;
	}
	
	public void studentAssignCourse(String[] students, String courseID, int year, String term) {
		ArrayList<String> existStudent = checkStudentAssignments(courseID, year, term);
		for(int i = 0; i < students.length; i++) {
			if(!existStudent.contains(students[i])){
				String qry ="insert into Attend (StudentID, CourseID, Year , Term) values (?, ? ,? ,? )";
				try {
					PreparedStatement ps = connection.prepareStatement(qry);
					ps.setString(1, students[i]);
					ps.setString(2, courseID);
					ps.setInt(3, year);
					ps.setString(4, term);
					ps.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void instructorAssignCourse(String[] instructors, String courseID, int year, String term) {
		ArrayList<String> existInstructors =  checkInstructorAssignment(courseID, year, term);
		for(int i = 0; i < instructors.length; i++) {
			if(!existInstructors.contains(instructors[i])){
				String qry ="insert into Lectures (InstrID, CourseID, Year , Term) values (?, ? ,? ,? )";
				try {
					PreparedStatement ps = connection.prepareStatement(qry);
					ps.setString(1, instructors[i]);
					ps.setString(2, courseID);
					ps.setInt(3, year);
					ps.setString(4, term);
					ps.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteInstructorAssign(String[] instructors, String courseID, int year, String term) {
		for(int i = 0; i < instructors.length; i++) {
			String qry ="delete from Lectures where InstrID = ? and CourseID = ? and  Year = ? and Term = ?";
			try {
				PreparedStatement ps = connection.prepareStatement(qry);
				ps.setString(1, instructors[i]);
				ps.setString(2, courseID);
				ps.setInt(3, year);
				ps.setString(4, term);
				ps.executeUpdate();
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	}
	
	public void deleteStudentAssign(String[] students, String courseID, int year, String term) {
		for(int i = 0; i < students.length; i++) {
			String qry ="delete from Attend where StudentID = ? and CourseID = ? and  Year = ? and Term = ?";
			try {
				PreparedStatement ps = connection.prepareStatement(qry);
				ps.setString(1, students[i]);
				ps.setString(2, courseID);
				ps.setInt(3, year);
				ps.setString(4, term);
				ps.executeUpdate();
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
		
	}
	
	public ArrayList<Instructor> retrieveAssignedInstructors(int year, String term, String courseID){
		String query = "select  Instructor.InstrID, FName, LName, Title from Instructor, Lectures where Instructor.InstrID = Lectures.InstrID and Year = ? and Term = ? and CourseID = ?";
		Instructor instructor = null;
		ArrayList<Instructor> container = new ArrayList<Instructor>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, year);
			ps.setString(2, term);
			ps.setString(3, courseID);
			result = ps.executeQuery();
			while(this.result.next()){
				instructor = new Instructor(result.getString("InstrID"), result.getString("FName"), result.getString("LName"), result.getString("Title"));
				container.add(instructor);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}
	
	public ArrayList<Student> retrieveAssignedstudents(int year, String term, String courseID){
		String query = "select  Student.StudentID, FName, LName, Student.Year from Student, Attend where Student.StudentID = Attend.StudentID and Attend.Year = ? and Term = ? and CourseID = ?";
		Student student = null;
		ArrayList<Student> container = new ArrayList<Student>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, year);
			ps.setString(2, term);
			ps.setString(3, courseID);
			result = ps.executeQuery();
			while(this.result.next()){
				student = new Student(result.getString("StudentID"), result.getString("FName"), result.getString("LName"), result.getInt("Year"));
				container.add(student);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}
	
	public ArrayList<Course> retrieveAssignedCourses(String instrID){
		String query = "select  Course.CourseID, CourseName, CreditHr, CourseType, CourseYear from Course, Lectures where Course.CourseID = Lectures.CourseID and InstrID = ?";
		Course course = null;
		ArrayList<Course> container = new ArrayList<Course>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, instrID);
			result = ps.executeQuery();
			while(this.result.next()){
				course = new Course(result.getString("CourseID"), result.getString("CourseName"), result.getDouble("CreditHr"), result.getString("CourseType"), result.getString("CourseYear"));
				container.add(course);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}
	
	public ArrayList<Integer> getYearEvaluation(String courseID, String instrID) {
		String query = "select  Year from Evaluation where CourseID = ? and InstrID = ?";
		ArrayList<Integer> container = new ArrayList<Integer>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, courseID);
			ps.setString(2, instrID);
			result = ps.executeQuery();
			while(this.result.next()){
				container.add(result.getInt("Year"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}
	
	public ArrayList<String> getTermEvaluation(String courseID, String instrID, int year) {
		String query = "select  Term from Evaluation where CourseID = ? and InstrID = ? and Year = ?";
		ArrayList<String> container = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, courseID);
			ps.setString(2, instrID);
			ps.setInt(3, year);
			result = ps.executeQuery();
			while(this.result.next()){
				container.add(result.getString("Term"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}
	
	public void studentAssignEvaluation(String[] students, Evaluation eval) {
		ArrayList<String> existStudent = checkStudentAssignEvaluation(eval);
		for(int i = 0; i < students.length; i++) {
			if(!existStudent.contains(students[i])){
				String qry ="insert into Assignments (EvalID, StudentID, Status) values (?, ? ,? )";
				try {
					PreparedStatement ps = connection.prepareStatement(qry);
					ps.setInt(1, eval.getEvalID());
					ps.setString(2, students[i]);
					ps.setString(3, "incomplete");
					ps.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
}
	
	public ArrayList<String> checkStudentAssignEvaluation(Evaluation eval){
		String query = "select  StudentID from Assignments where EvalID = ?";
		ArrayList<String> existing = new ArrayList<String>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eval.getEvalID());
			result = ps.executeQuery();
			while(this.result.next()){
				existing.add(result.getString("StudentID"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		
		return existing;
		
	}

	public ArrayList<Student> StudentAssignEvaluation(Evaluation eval) {
		String query = "select Student.StudentID, FName, LName, Year from Student, Assignments where Student.StudentID = Assignments.StudentID and EvalID = ?";
		Student student = null;
		ArrayList<Student> container = new ArrayList<Student>();
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, eval.getEvalID());
			result = ps.executeQuery();
			while(this.result.next()){
				student = new Student(result.getString("StudentID"), result.getString("FName"), result.getString("LName"), result.getInt("Year"));
				container.add(student);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return container;
	}

	public void undoStudentEvaluationAssignment(Evaluation eval, String[] students) {
		for(int i = 0; i < students.length; i++) {
			String qry ="delete from Assignments where StudentID = ? and EvalID = ? ";
			try {
				PreparedStatement ps = connection.prepareStatement(qry);
				ps.setString(1, students[i]);
				ps.setInt(2, eval.getEvalID());
				ps.executeUpdate();
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
		
	}

}
