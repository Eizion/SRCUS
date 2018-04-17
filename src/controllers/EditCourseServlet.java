package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.Assignments;
import dbHelpers.CheckCourse;
import model.Course;
import model.Evaluation;
import model.Instructor;
import model.Student;

/**
 * Servlet implementation class EditCourseServlet
 */
@WebServlet("/editCourse")

public class EditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Assignments ri = new Assignments();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String level = request.getParameter("level");
		ArrayList<Student> students = new ArrayList<Student>();
		if(level.equals("1") || level.equals("2") || level.equals("3")) {
			students = ri.retrieveSelectStudents(level);
		}else if(level.equals("all")) {
			students = ri.retrieveAllStudents();
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("<table>");
    	for(int i = 0; i < students.size(); i++) {
    		Student current= students.get(i);
    		out.write("<tr><td>");
    		out.write("<input type='checkbox' name='student' value=" +current.getStudentID()+" />" + current.getfName()+" "+ current.getlName());
    		out.write("</td><tr>");
    		
    		}
    	out.write("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		String url = "";
		HttpSession session = request.getSession();
		String courseID = request.getParameter("courseID");
		String submit = request.getParameter("submit");
		CheckCourse check= new CheckCourse();
		Course selected = check.doCheckID(courseID);
		session.setAttribute("course", selected);
		if(submit.equals("Edit")) {
		if(courseID == null){
			message="Please select a course to edit.";
			request.setAttribute("message", message); 
			url="/selectCourse.jsp";
		}
		else{
			url="/editCourse.jsp";
			}
		}
		else if(submit.equals("Assign Instructors")) {
			Assignments ri = new Assignments();
			ArrayList<Instructor> instrList = ri.retrieveInstructors();  //retrieve the current list of instructors for assignment
			request.setAttribute("instructors", instrList);
			url="assignInstructor.jsp";
		}
		else if(submit.equals("Assign Students")) {
			url="assignStudents.jsp";
		}
		else if(submit.equals("Undo Assigned Instructors")) {
			url="undoInstructorAssign.jsp";
		}
		else if(submit.equals("Undo Assigned Students")) {
			url="undoStudentAssign.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
