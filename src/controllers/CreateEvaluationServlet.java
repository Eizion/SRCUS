package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.Assignments;
import dbHelpers.CreateEvaluation;
import model.Course;
import model.Evaluation;
import model.Instructor;
import model.Student;

/**
 * Servlet implementation class CreateEvaluationServlet
 */
@WebServlet("/createEvaluation")
public class CreateEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEvaluationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item = request.getParameter("item");
		String instrID = "";
		String courseID = "";
		Assignments assign = new Assignments("srcus_master", "root", "root");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(item.equals("instructor")) {
			ArrayList<Instructor> instructor = new ArrayList<Instructor>();
			instructor = assign.retrieveInstructors();
			String title = "";
        		out.write("<option value=\"\" selected='selected' >---Instructor Name---</option>");
        		for(int i = 0; i < instructor.size(); i++) {
        			Instructor current= instructor.get(i);
        				if(current.getTitle() != null){
        					title = current.getTitle();
        				}
        				out.write("<option value=" +current.getInstrID() +" /> "+ title + " " +current.getfName()+" "+ current.getlName());
        				out.write("</option>");
        		}
		}
		else if(item.equals("course")){
			instrID = request.getParameter("instrID");
			ArrayList<Course> courses = new ArrayList<Course>();
			courses = assign.retrieveAssignedCourses(instrID);
			out.write("<option value=\"\" selected='selected' >---Course Name---</option>");
			for(int i = 0; i < courses.size(); i++) {
    			Course current= courses.get(i);
    				out.write("<option value=" +current.getCourseID() +" /> "+current.getCourseID()+":"+ current.getCourseName());
    				out.write("</option>");
    		}
		} 
		else if(item.equals("year")) {
			instrID = request.getParameter("instrID");
			courseID = request.getParameter("courseID");
			ArrayList<Integer> year = assign.getYearEvaluation(courseID, instrID);
			out.write("<option value=\"\" selected='selected' >---Year---</option>");
			for(int i = 0; i < year.size(); i++) {
    			int current= year.get(i);
    				out.write("<option value=" +current +" /> " + current);
    				out.write("</option>");
    		}
		}
		else if(item.equals("term")) {
			instrID = request.getParameter("instrID");
			courseID = request.getParameter("courseID");
			int year = Integer.parseInt(request.getParameter("year"));
			ArrayList<String> term = assign.getTermEvaluation(courseID, instrID, year);
			out.write("<option value=\"\" selected='selected' >---Term---</option>");
			for(int i = 0; i < term.size(); i++) {
    			String current= term.get(i);
    				out.write("<option value=" +current +" /> " + current + " Semester");
    				out.write("</option>");
    		}
			
		}
	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Get the parameters from the form
		String message = "";
		String  url ="";
		int questionNum = 1; //initialize question number
		String instrID= request.getParameter("instrID");
		String courseID = request.getParameter("courseID");
		int year = Integer.parseInt(request.getParameter("year"));
		String term = request.getParameter("term");
		String activeDate = request.getParameter("activeDate");
		String submDate = request.getParameter("submDate");
		
		//Create a connection to database and add the info
		CreateEvaluation ce = new CreateEvaluation("srcus_master", "root", "root");
		
		//Check to see if the same evaluation already exists 
		Evaluation existing = ce.doCheck(instrID, courseID, year, term);
		if(existing == null) {
		ce.doCreate(instrID, courseID, year, term, activeDate, submDate);
		int evalID = ce.retrieveEvalID(instrID, courseID, year, term);
		
		//create an evaluation object
		Evaluation eval = new Evaluation(instrID, courseID, evalID, year, term);
		url ="/QuestionForm.jsp";
		HttpSession session = request.getSession();
		session.setAttribute("eval", eval);
		session.setAttribute("questionNum", Integer.toString(questionNum));
		}
		else{
		    message = "An evaluation already exists for the selected instructor and course. Please select a different one.";
			url="/CreateEvaluation.jsp";
		}
		
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
