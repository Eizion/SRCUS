package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.Assignments;
import model.Course;
import model.Evaluation;
import model.Student;

/**
 * Servlet implementation class AssignServlet
 */
@WebServlet("/assignServlet")
public class AssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Assignments ri = new Assignments("srcus_master", "root", "root");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int year = (Integer)(session.getAttribute("year"));
		String term = (String) session.getAttribute("term");
		String courseID = (String) session.getAttribute("courseID");
		String button = request.getParameter("button");
		ArrayList<Student> students = new ArrayList<Student>();
		if(button.equals("assign")) { //to retrieve all students taking a course, to be assigned to it's evaluation
			students = ri.retrieveAssignedstudents(year, term, courseID);
		}else if(button.equals("undo")) {//to retrieve all students currently assigned to an evaluation, so as to undo assignment
			Evaluation eval = (Evaluation)session.getAttribute("eval");
			students = ri.StudentAssignEvaluation(eval);
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
		HttpSession session = request.getSession();
		String submit = request.getParameter("submit");
		Evaluation eval = (Evaluation)session.getAttribute("eval");
		String url = "";
		String message="";
		if(submit.equals("Assign Instructors")) {//assign instructor to a course
			Course course = (Course)session.getAttribute("course");
			String courseID = course.getCourseID();
			int year = Integer.parseInt(request.getParameter("year"));
			String term = request.getParameter("term");
			String[] instructors = request.getParameterValues("instructor");
			ri.instructorAssignCourse(instructors, courseID, year, term);
			message = "The selected instructors were successfully assigned to the course";
			url = "/selectCourse.jsp";
		}
		else if(submit.equals("Assign Students")){ //Assign student to a course
			Course course = (Course)session.getAttribute("course");
			String courseID = course.getCourseID();
			int year = Integer.parseInt(request.getParameter("year"));
			String term = request.getParameter("term");
			String[] students = request.getParameterValues("student");
			ri.studentAssignCourse(students,courseID, year, term);
			message = "The selected students were successfully assigned to the course";
			url = "/selectCourse.jsp";
		}
		else if(submit.equals("Assign Students to Evaluation")) { //assign student to an evaluation
			String[] students = request.getParameterValues("student");
			ri.studentAssignEvaluation(students, eval);
			message = "The selected students were successfully assigned to the evaluation";
			url = "/editEvaluation.jsp";
		}
		else if(submit.equals("Undo Student Assignment")) {  //undo student assignment to an evaluation
			String[] students = request.getParameterValues("student");
			ri.undoStudentEvaluationAssignment(eval, students);
			message = "The selected students were successfully unassigned from the evaluation";
			url="/editEvaluation.jsp";
		}
		
		request.setAttribute("message", message);
		session.removeAttribute("course");
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
