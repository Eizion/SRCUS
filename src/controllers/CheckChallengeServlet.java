package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SecurityAnswer;
import model.SecurityQuestion;
import model.User;

/**
 * Servlet implementation class CheckChallengeServlet
 */
@WebServlet({ "/CheckChallengeServlet", "/checkChallenge" })
public class CheckChallengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckChallengeServlet() {
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
		
		User forgotUser = (User) session.getAttribute("forgotUser");
		SecurityQuestion securityQuestion = (SecurityQuestion) session.getAttribute("securityQuestion");
		SecurityAnswer securityAnswer = (SecurityAnswer) session.getAttribute("securityAnswer");
		String savedAnswer = securityAnswer.getAnswer();
		String answer = request.getParameter("answer");
		String errorMessage = "";
		
		if (savedAnswer.compareTo(answer) != 0) {
			errorMessage = "The answer you input is incorrect. Please try again or contact an administrator.";
			request.setAttribute("errorMessage", errorMessage);
			url="challenge.jsp";
		} else {
			url="resetPassword.jsp";
		}
		
		//url = "resetPassword.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
