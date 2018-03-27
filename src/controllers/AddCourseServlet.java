package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddCourse;
import dbHelpers.CheckCourse;
import model.Course;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/courseServlet")

public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
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
		//retrieve parameters from add course form
		String message;
		String courseID = request.getParameter("courseID");
		String courseName = request.getParameter("courseName");
		Double creditHr = Double.parseDouble(request.getParameter("creditHr"));
		String courseType = request.getParameter("courseType");
		String classYear = request.getParameter("classYear");
		Course course = new Course(courseID, courseName, creditHr, courseType, classYear);
		//check for existing course in database
		CheckCourse check = new CheckCourse("srcus_master", "root", "Tsega12!");
		Course existCourse = check.doCheckID(courseID);
		Course existName = check.doCheckName(courseName);
		
		//Add new course into database if it doesn't already exist
		if(existCourse == null && existName == null){
		AddCourse ac = new AddCourse("srcus_master", "root", "Tsega12!");
		ac.doAdd(course);
		message = "The new course "+ courseName + " was successfully created!"; 
		}
		else{
		message ="The course "+ courseName + " already exists.";
		}
		url="/addCourse.jsp";
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
