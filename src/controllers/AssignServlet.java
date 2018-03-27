package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.RetrieveInstructors;
import model.Course;
import model.Evaluation;

/**
 * Servlet implementation class AssignServlet
 */
@WebServlet("/assignServlet")
public class AssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Course course = (Course)session.getAttribute("course");
		String[] instructors = request.getParameterValues("instructor");
		int year = Integer.parseInt(request.getParameter("year"));
		String term = request.getParameter("term");
		RetrieveInstructors ri = new RetrieveInstructors("srcus_master", "root", "root");
		String courseID = course.getCourseID();
		ArrayList<String> assignments = ri.checkAssignment(courseID, year, term);
		if(assignments.isEmpty()) {
			ri.doAssign(instructors, courseID, year, term);
		}else {
			ri.deleteAssign(courseID, year, term);
			ri.doAssign(instructors, courseID, year, term);
		}
		session.removeAttribute("course");
		String url = "/selectCourse.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
