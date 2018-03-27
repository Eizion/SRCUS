package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UpdateCourse;
import model.Course;

/**
 * Servlet implementation class UpdateCourseServlet
 */
@WebServlet("/update")

public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseServlet() {
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
		// TODO Auto-generated method stub
		//retrieve parameters from the form
		HttpSession session = request.getSession();
		String oldCourseID = (String)session.getAttribute("oldCourseID");
		String courseID = request.getParameter("courseID");
		String courseName= request.getParameter("courseName");
		Double creditHr = Double.parseDouble(request.getParameter("creditHr"));
		String courseType = request.getParameter("courseType");
		String courseYear = request.getParameter("courseYear");
		
		//create a new objects of type Course and UpdateCourse 
		Course course = new Course(courseID, courseName, creditHr, courseType, courseYear);
		UpdateCourse up = new UpdateCourse("srcus_master", "root", "root");
		//Execute update
		up.doUpdate(course, oldCourseID);
		String message="You have succefully modified the course! Edit another one";
		request.setAttribute("message", message);
		String url= "/selectCourse.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
