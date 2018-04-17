package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.SaveAnswer;
import model.Evaluation;
import model.Question;
import model.User;

/**
 * Servlet implementation class SaveAnswers
 */
@WebServlet("/saveAnswers")
public class SaveAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAnswersServlet() {
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
		String answer = "";
		boolean last= false;
		String url ="";
		int studentID = 0;
		HttpSession session = request.getSession();
			//get the attributes from the form
		Evaluation eval = (Evaluation)session.getAttribute("eval");
		Question[] container = (Question[])session.getAttribute("questionSet");
		int questionNum = (Integer)session.getAttribute("questionNum");
		User user = (User) session.getAttribute("user");
		if(user.getRole() == 2) {
			studentID = user.getId();
		}
		String clicked = request.getParameter("submit");
		if(clicked.equals("Next")) { // load next question without saving changes made to current question
			questionNum++;
			if(questionNum == container.length) {
				last = true;
			}
			if(questionNum > container.length) {
				url ="/courseevaluation.jsp";
				}
			else{
				request.setAttribute("last", last);
				Question current = container[questionNum-1];
				session.setAttribute("questionNum", questionNum);
				request.setAttribute("current", current);
				url ="/loadEvaluation.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);	
		}
		else if(clicked.equals("Back")) { //Go back to previous question without saving changes 
			questionNum--;  
			if(questionNum < 1) {
				url="/selectEvaluation.jsp";
			}else {
				if(last){last = false;}
				request.setAttribute("last", last);
				Question current = container[questionNum-1];
				session.setAttribute("questionNum", questionNum);
				request.setAttribute("current", current);
				url ="/loadEvaluation.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else {
		String[] result = request.getParameterValues("answer");
		if(result.length > 1) {
			for(int i = 0; i < result.length; i++) {
			answer = answer + result[i] + "^"; 
			}
		}
		else {
			answer = result[0];
		}
		
		//create a connection to database and save answer
		SaveAnswer sa = new SaveAnswer("srcus_master", "root", "Tsega12!");
		sa.doSave(eval.getEvalID(), questionNum, studentID, answer);
		questionNum++;
		if (questionNum <= container.length) {
			if(questionNum == container.length) {// the next question is the last question
				last = true;
			}
			//the next question isn't the last question
			session.setAttribute("last", last);
			Question current = container[questionNum-1];
			session.setAttribute("questionNum", questionNum);
			request.setAttribute("current", current);
			url = "/loadEvaluation.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else if(questionNum > container.length){
			sa.finalSubmit(eval.getEvalID(), studentID); // to set the status of the student's evaluation assignment to completed
			session.removeAttribute("questionNum");
			session.removeAttribute("questionSet");
			session.removeAttribute("eval");
			session.removeAttribute("last");
			url ="/courseevaluation.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
	
	}
}
