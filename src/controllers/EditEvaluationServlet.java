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

import dbHelpers.AddQuestion;
import dbHelpers.RetrieveQuestion;
import dbHelpers.UpdateQuestion;
import model.Evaluation;
import model.Question;

/**
 * Servlet implementation class EditEvaluationServlet
 */
@WebServlet("/editEvaluation")
public class EditEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEvaluationServlet() {
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
		//retrieve all parameters from modify form
		String question = request.getParameter("question");
		String questionType = request.getParameter("questionType");
		HttpSession session = request.getSession();
		Evaluation eval = (Evaluation) session.getAttribute("eval");
		Question[] container = (Question[])session.getAttribute("questionSet");
		int questionNum = (Integer)session.getAttribute("questionNum");
		Question oldQuestion = container[questionNum-1];
		String oldQuesType = oldQuestion.getQuestionType();
		
		boolean last = false;
		ArrayList<String> choices = new ArrayList<String>();
		String url;
		int counter = 1;
		int i=0;
		
		while(request.getParameter(Integer.toString(counter)) != null && request.getParameter(Integer.toString(counter)) != ""){ //insert all the choices to a question in an arraylist
			choices.add(i,request.getParameter(Integer.toString(counter)));
			System.out.println(request.getParameter(Integer.toString(counter)));
			counter++;
			i++;
		}
		
		String clicked = request.getParameter("submit");
		
		if(clicked.equals("Delete Question")){                // in case of delete question
			UpdateQuestion uq = new UpdateQuestion("srcus_master", "root", "Tsega12!");
			uq.doDelete(eval, questionNum, questionType);
			uq.updateTable(eval, questionNum ,container.length); //update table after delete
			RetrieveQuestion re = new RetrieveQuestion("srcus_master", "root", "Tsega12!");
			container = re.getquestion(eval);  //get the new array of questions
			if(questionNum <= container.length) {
				if(questionNum == container.length) { //last question in the array
					last = true;
				}
				request.setAttribute("last", last);
				Question current = container[questionNum-1];
				session.setAttribute("questionNum", questionNum);
				request.setAttribute("current", current);
				url ="/modifyEvaluation.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else if(questionNum > container.length) {
				url ="/evaluation.jsp";
				session.removeAttribute("questionNum");
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
			
		}else {
			//in case of update question 
			//create a connection to database and update entries
			UpdateQuestion uq = new UpdateQuestion("srcus_master", "root", "Tsega12!");
			uq.updateQuestion(question, questionType, eval, questionNum);
			
				if(questionType.equals("giveAnswer")){
					uq.deleteChoices(eval, questionNum);
				}
				else if (questionType.equals("multiSelect") || questionType.equals("chooseOne")){
					uq.deleteChoices(eval, questionNum);
				    uq.updateChoices(choices, eval, questionNum);
				}
		
				
		if(clicked.equals("Save & Continue")) {    //to save and continue editing more questions
			questionNum = questionNum +1;
			if(questionNum == container.length) {
				last = true;
			}
			request.setAttribute("last", last);
			Question current = container[questionNum-1];
			session.setAttribute("questionNum", questionNum);
			request.setAttribute("current", current);
			url ="/modifyEvaluation.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else if (clicked.equals("Save & Finish")){     //marks the end of the evaluation entry
			url ="/evaluation.jsp";
			session.removeAttribute("questionNum");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}


}

}