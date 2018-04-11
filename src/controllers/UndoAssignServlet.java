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
import model.Course;
import model.Instructor;
import model.Student;

/**
 * Servlet implementation class UndoAssignServlet
 */
@WebServlet("/undoAssignServlet")
public class UndoAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Assignments ri = new Assignments("srcus_master", "root", "root"); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UndoAssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int year = Integer.parseInt(request.getParameter("year"));
		Course course = (Course)session.getAttribute("course");
		String courseID = course.getCourseID();
		String term = request.getParameter("term");
		String button = request.getParameter("button");
		if(button.equals("Get Assigned Instructors")) { // code for retrieving assigned instructors to a course
			ArrayList<Instructor> instructors = new ArrayList<Instructor>();
			instructors = ri.retrieveAssignedInstructors(year, term, courseID);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String title= "";
			out.write("<table>");
        	for(int i = 0; i < instructors.size(); i++) {
        		Instructor current= instructors.get(i);
        		if(current.getTitle() != null) {
        			title= current.getTitle();
        		}
        		out.write("<tr><td>");
        		out.write("<input type='checkbox' name='instructor' value=" +current.getInstrID()+" /> "+ title +" "+ current.getfName()+" "+ current.getlName());
        		out.write("</td><tr>");
        		
        		}
        	out.write("</table>");
		}
		else if(button.equals("Get Assigned Students")) { // code for retrieving assigned students to a course
			ArrayList<Student> students = new ArrayList<Student>();
			students = ri.retrieveAssignedstudents(year, term, courseID);
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
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String url = "/selectCourse.jsp";
		int year = Integer.parseInt(request.getParameter("year"));
		String term = request.getParameter("term");
		HttpSession session = request.getSession();
		Course course = (Course)session.getAttribute("course");
		String courseID = course.getCourseID();
		String submit = request.getParameter("submit");
		if(submit.equals("Undo Instructor Assignments")){ //undo instructor assignment to a course
			String[] instructors = request.getParameterValues("instructor");
			ri.deleteInstructorAssign(instructors,  courseID,  year, term);
			message= "The instructor(s) are no longer assigned to the course.";
		}
		else if(submit.equals("Undo Student Assignments")) { //undo student assignment to a course
			String[] students = request.getParameterValues("student");
			ri.deleteStudentAssign(students, courseID, year, term);
			message="The selected student(s) are no longer assigned to the course.";
		}
		request.setAttribute("message", message);
		session.removeAttribute("course");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
