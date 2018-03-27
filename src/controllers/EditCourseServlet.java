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

import dbHelpers.CheckCourse;
import dbHelpers.RetrieveInstructors;
import model.Course;
import model.Instructor;

/**
 * Servlet implementation class EditCourseServlet
 */
@WebServlet("/editCourse")

public class EditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		doPost(request , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		String url = "";
		String courseID = request.getParameter("courseID");
		String submit = request.getParameter("submit");
		if(submit.equals("Edit")) {
		if(courseID == null){
			message="Please select a course to edit.";
			request.setAttribute("message", message); 
			url="/selectCourse.jsp";
		}
		else{
			CheckCourse check= new CheckCourse("srcus_master", "root", "root");
			Course selected = check.doCheckID(courseID);
			request.setAttribute("course", selected);
			url="/editCourse.jsp";
			
		}
		}
		else if(submit.equals("Assign Instructors")) {
			CheckCourse check= new CheckCourse("srcus_master", "root", "root");
			Course selected = check.doCheckID(courseID);
			RetrieveInstructors ri = new RetrieveInstructors("srcus_master", "root", "root");
			ArrayList<Instructor> instrList = ri.doRetrieve();
			HttpSession session = request.getSession();
			session.setAttribute("course", selected);
			request.setAttribute("instructors", instrList);
			url="assignInstructor.jsp";
		}
		else if(submit.equals("Assign Students")) {
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
