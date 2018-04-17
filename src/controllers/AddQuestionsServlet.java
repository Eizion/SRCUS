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
import model.Evaluation;

/**
 * Servlet implementation class AddQuestionsServlet
 */
@WebServlet("/addQuestions")
public class AddQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionsServlet() {
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
		String question = request.getParameter("question");
		String questionType = request.getParameter("questionType");
		HttpSession session = request.getSession();
		Evaluation eval = (Evaluation) session.getAttribute("eval");
		int questionNum = (Integer)session.getAttribute("questionNum");
		
		ArrayList<String> choices = new ArrayList<String>();
		int counter = 1;
		int i = 0;
		String option;
		while(request.getParameter(Integer.toString(counter)) != null ){
			choices.add(i, request.getParameter(Integer.toString(counter)));
			i++;
			counter++;

		 }
	
		AddQuestion aq = new AddQuestion();
		aq.doAddQuestion(question, questionType, eval, questionNum);
		
		//insert the choice options if question is a choose question or multi-select
		if (questionType.equals("chooseOne"))
		{
			aq.insertChoices(questionType, choices, eval, questionNum);
		}
		else if (questionType.equals("multiSelect")){
			aq.insertChoices(questionType, choices, eval, questionNum);
		}
		
		String url;
		String clicked = request.getParameter("submit");
		if(clicked.equals("Save & Continue")) {    //to save and continue adding more questions
		questionNum = questionNum +1;
		url ="/QuestionForm.jsp";
		session.setAttribute("questionNum", questionNum);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		}
		else if (clicked.equals("Finish")){     //marks the end of the evaluation entry
			url ="/courseevaluation.jsp";
			session.removeAttribute("questionNum");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
