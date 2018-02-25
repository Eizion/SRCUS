package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.SecurityQuestionQuery;
import model.SecurityAnswer;
import model.User;

/**
 * Servlet implementation class SecurityServlet
 */
@WebServlet("/SecurityServlet")
public class SecurityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecurityServlet() {
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
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		int s_question1 = Integer.parseInt(request.getParameter("SQ1"));
		int s_question2 = Integer.parseInt(request.getParameter("SQ2"));
		int s_question3 = Integer.parseInt(request.getParameter("SQ3"));
		String s_answer1 = request.getParameter("answer1");
		String s_answer2 = request.getParameter("answer2");
		String s_answer3 = request.getParameter("answer3");
		
		SecurityAnswer sa1 = new SecurityAnswer();
		
		sa1.setSq_id(s_question1);
		sa1.setUser_id(user.getId());
		sa1.setAnswer(s_answer1);
		
		SecurityAnswer sa2 = new SecurityAnswer();
		
		sa2.setSq_id(s_question2);
		sa2.setUser_id(user.getId());
		sa2.setAnswer(s_answer2);
		
		SecurityAnswer sa3 = new SecurityAnswer();
		
		sa3.setSq_id(s_question3);
		sa3.setUser_id(user.getId());
		sa3.setAnswer(s_answer3);
		
		SecurityQuestionQuery questionQuery = new SecurityQuestionQuery ("srcus_master", "root", "root");
		
		questionQuery.addAnswers(sa1);
		questionQuery.addAnswers(sa2);
		questionQuery.addAnswers(sa3);
		
		url = "securitySuccess.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
