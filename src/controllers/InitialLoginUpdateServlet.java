package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UpdateCredsQuery;
import model.SecurityAnswer;
import model.User;
import utilities.Encryption;

/**
 * Servlet implementation class InitialLoginUpdateServlet
 */
@WebServlet("/InitialLoginUpdateServlet")
public class InitialLoginUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialLoginUpdateServlet() {
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
		
		//Getting variables and whatnot
		User user = (User) session.getAttribute("user");
		
		int s_question = Integer.parseInt(request.getParameter("sq"));
		String s_answer = request.getParameter("answer");
		String password = request.getParameter("password");
		
		Encryption pwd = new Encryption();
		String encryptedPass = pwd.encrypt(password);
		
		//Setting security question and answer for user
		SecurityAnswer sa = new SecurityAnswer();
		
		sa.setSq_id(s_question);
		sa.setUser_id(user.getId());
		sa.setAnswer(s_answer);
		
		UpdateCredsQuery ucq = new UpdateCredsQuery ("srcus_master", "root", "root");
		
		ucq.addAnswers(sa);
		
		//Update password
		String email = user.getEmail();
		ucq.updatePassword(encryptedPass, email);
		
		//setting success message and url for redirect
		String message = "You have successfully updated your security question and password.";
		request.setAttribute("message", message);
		url = "home.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
