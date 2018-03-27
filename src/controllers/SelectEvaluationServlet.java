package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.CreateEvaluation;
import dbHelpers.RetrieveQuestion;
import dbHelpers.UpdateQuestion;
import model.Evaluation;
import model.Question;

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
		// TODO Auto-generated method stub
		doPost(request, response);
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
		CreateEvaluation ce = new CreateEvaluation("srcus_master", "root", "root");
		
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
			RetrieveQuestion re = new RetrieveQuestion("srcus_master", "root", "root");
			Question[] container = re.getquestion(existing); 
			if (container.length == questionNum) {
				last = true;          // to check if it is the last question
			}else if(container.length >= questionNum) {
			HttpSession session = request.getSession();
			Question current = container[questionNum-1];
			session.setAttribute("eval", existing);
			session.setAttribute("questionSet" , container);
			session.setAttribute("questionNum", questionNum);
			request.setAttribute("current", current);
			request.setAttribute("last", last);
			request.setAttribute("message", message);
			if(submit.equals("Open Evaluation")) {
				url = "/loadEvaluation.jsp";
			}else if(submit.equals("Edit Evaluation")){
				url = "/modifyEvaluation.jsp";
			}
			}
			else if(submit.equals("Delete Evaluation")) {
				UpdateQuestion uq = new UpdateQuestion("srcus_master", "root", "root");
				for(int i =0; i < container.length; i++) {
					questionNum = i+1;
					String questionType = container[i].getQuestionType();
					uq.doDelete(existing, questionNum, questionType);
				}
				uq.deleteEvaluation(existing);
				String confirm ="The evaluation was successfully deleted";
				request.setAttribute("message", confirm);
				url="/editEvaluation.jsp";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
