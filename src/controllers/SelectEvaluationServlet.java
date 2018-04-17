package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.Assignments;
import dbHelpers.CreateEvaluation;
import dbHelpers.RetrieveQuestion;
import dbHelpers.UpdateQuestion;
import model.Course;
import model.Evaluation;
import model.Instructor;
import model.Question;
import model.User;

/**
 * Servlet implementation class SelectEvaluationServlet
 */
@WebServlet("/selectEvaluation")
public class SelectEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEvaluationServlet() {
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
		Assignments assign = new Assignments();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(item.equals("instructor")) {
			int year = Integer.parseInt(request.getParameter("year"));
			String term = request.getParameter("term");
			courseID = request.getParameter("courseID");
			ArrayList<Instructor> instructor = new ArrayList<Instructor>();
			instructor = assign.retrieveAssignedInstructors(year, term, courseID);
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
			int year = Integer.parseInt(request.getParameter("year"));
			String term = request.getParameter("term");
			ArrayList<Course> courses = new ArrayList<Course>();
			if(user.getRole() == 2) {
				int studentID = user.getId();
				courses = assign.getCourseForStudent(studentID, year, term);
			}else {
				courses = assign.getCourse();
			}
			out.write("<option value=\"\" selected='selected' >---Course Name---</option>");
			for(int i = 0; i < courses.size(); i++) {
    			Course current= courses.get(i);
    				out.write("<option value=" +current.getCourseID() +" /> "+current.getCourseID()+":"+ current.getCourseName());
    				out.write("</option>");
    		}
		} 
		else if(item.equals("year")) {
			if(user.getRole() == 2) { //student can open evaluations of current year only
				Calendar now = Calendar.getInstance();   // Gets the current date and time
				int year = now.get(Calendar.YEAR);
				out.write("<option value=\"\" selected='selected' >---Year---</option>");
				out.write("<option value=" + year +" /> " + year);
				out.write("</option>");
			}else {
			out.write("<option value=\"\" selected='selected' >---Year---</option>");
			for(int i = 2018; i <= 2020; i++) { //admin can open evaluation for all years
    				out.write("<option value=" +i +" /> " + i);
    				out.write("</option>");
    			}
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message="";
		String url= "";
		int questionNum = 1;
		boolean last = false;
		String instrID= request.getParameter("instrID");
		String courseID = request.getParameter("courseID");
		int year = Integer.parseInt(request.getParameter("year"));
		String term = request.getParameter("term");
		String submit = request.getParameter("submit");
		CreateEvaluation ce = new CreateEvaluation();
		UpdateQuestion uq = new UpdateQuestion();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//Check to see if the evaluation already exists 
		//if it exists it returns the evaluation if not it returns null
		Evaluation existing = ce.doCheck(instrID, courseID, year, term);
		if(existing == null) { //if Evaluation doesn't exist
			 message = "There is no evaluation for the selected instructor and course.Please choose a different one.";
			if(submit.equals("Open Evaluation")) {
				url="/selectEvaluation.jsp";
			}else if(submit.equals("Edit Evaluation")){
				url="/editEvaluation.jsp";
			}
		}else if(existing != null){
			//Retrieve the questions for the evaluation
			RetrieveQuestion re = new RetrieveQuestion();
			Question[] container = re.getquestion(existing); 
			if (container.length < questionNum) {
					if(!submit.equals("Delete Evaluation")) {
					message = "There are no questions for this evaluation. Please try deleting the evaluation and creating a new one.";
					url="/editEvaluation.jsp";
				}
					else if (submit.equals("Delete Evaluation")) { // deleting evaluation that has no questions
				  	uq.deleteEvaluation(existing);
				  	message ="The evaluation was successfully deleted";
					url="/editEvaluation.jsp";
					}
			}
			else {
				if(container.length == questionNum){
					last = true; // question is last question
				 }
					session = request.getSession();
					Question current = container[questionNum-1];
					session.setAttribute("eval", existing);
					session.setAttribute("questionSet" , container);
					session.setAttribute("questionNum", questionNum);
					request.setAttribute("current", current);
					request.setAttribute("last", last);
					request.setAttribute("message", message);
					if(submit.equals("Open Evaluation")) {
						if(user.getRole() == 2) {
							String result = ce.checkActivationEvaluation(existing);
							boolean complete = ce.checkStatus(existing, user);
							if(!result.equals("")) {
								message=result;
								url="/selectEvaluation.jsp";
								}
							else if(complete){
								message= "You have already completed this evaluation";
								url="/selectEvaluation.jsp";
								}
							else {
								url = "/loadEvaluation.jsp";
							}
						}else {
						url = "/loadEvaluation.jsp";
						}
					}else if(submit.equals("Edit Evaluation")){
						url = "/modifyEvaluation.jsp";
					}
					else if(submit.equals("Delete Evaluation")) {
						if(container.length > 0) {
							for(int i =0; i < container.length; i++) {
								questionNum = i+1;
								String questionType = container[i].getQuestionType();
								uq.doDelete(existing, questionNum, questionType);
							}
						}
						uq.deleteEvaluation(existing);
						String confirm ="The evaluation was successfully deleted";
						request.setAttribute("message", confirm);
						url="/editEvaluation.jsp";
					}
					else if(submit.equals("Assign Students")) {
						session.setAttribute("courseID", courseID);
						session.setAttribute("year", year);
						session.setAttribute("term", term);
						url="/assignStudentEvaluation.jsp";
					}
					else if(submit.equals("Undo Assigned Students")) {
						session.setAttribute("courseID", courseID);
						session.setAttribute("year", year);
						session.setAttribute("term", term);
						url="/undoAssignedStudentEvaluation.jsp";
					}
				}
			}
 		request.setAttribute("message", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
