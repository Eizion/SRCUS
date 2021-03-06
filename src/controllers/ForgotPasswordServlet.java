package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.CheckUserQuery;
import dbHelpers.RegisterQuery;
import dbHelpers.ForgotPasswordQuery;
import dbHelpers.GenerateSecurityQuery;
import model.SecurityAnswer;
import model.SecurityQuestion;
import model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet({ "/ForgotPasswordServlet", "/forgotpassword" })
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
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
		
		String email = request.getParameter("email");
		CheckUserQuery cu = new CheckUserQuery();
		User forgotUser = cu.checkUser(email);
		String question = "";
		
		if (forgotUser == null){
			String errorMessage = "Error: That email does not exist. Please contact an administrator.";
			request.setAttribute("errorMessage", errorMessage);
			url = "forgotpassword.jsp";
		} else {
			request.setAttribute("email", email);
			int user_id = forgotUser.getId();
			
			ForgotPasswordQuery fp = new ForgotPasswordQuery();
			fp.getAnswers(user_id);
			SecurityAnswer securityAnswer = fp.getSecurityAnswer();
			int sq_id = securityAnswer.getSq_id();
			fp.getQuestions(sq_id);
			SecurityQuestion securityQuestion = fp.getSecurityQuestion();
			question = securityQuestion.getS_question();
			
			session.setAttribute("securityAnswer", securityAnswer);
			session.setAttribute("securityQuestion", securityQuestion);
			session.setAttribute("forgotUser", forgotUser);
			request.setAttribute("question", question);
			url = "challenge.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
