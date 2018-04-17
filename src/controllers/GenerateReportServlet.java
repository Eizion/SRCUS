package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.CreateEvaluation;
import dbHelpers.Report;
import dbHelpers.RetrieveQuestion;
import model.Course;
import model.Evaluation;
import model.Instructor;
import model.Question;

/**
 * Servlet implementation class GenerateReportServlet
 */
@WebServlet("/generateReport")
public class GenerateReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String url;
		String instrID= request.getParameter("instrID");
		String courseID = request.getParameter("courseID");
		int year = Integer.parseInt(request.getParameter("year"));
		String term = request.getParameter("term");
		CreateEvaluation ce = new CreateEvaluation();
		Evaluation existing = ce.doCheck(instrID, courseID, year, term);
		if(existing == null) { //if Evaluation doesn't exist send error message
			 message = "There is no evaluation for the selected instructor and course.Please choose a different one.";
			 url="/generateReport.jsp";
		}
		else { //if evaluation exist generate report
		Report report = new Report();
		RetrieveQuestion re = new RetrieveQuestion(); // retrieve the question set for the evaluation
		Question[] container = re.getquestion(existing); 
		Course course = report.getCourse(courseID);
		Instructor instructor = report.getInstructor(instrID);
		message = report.generateReport(existing, container, year, course, instructor);
		url= "/Report.jsp";
		request.setAttribute("course", course);
		request.setAttribute("instructor", instructor);
		request.setAttribute("year", year);
		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		}
	}

}
