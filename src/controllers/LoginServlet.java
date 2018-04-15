package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.CheckAnswerQuery;
import dbHelpers.LoginQuery;
import model.User;
import utilities.Encryption;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HttpSession session; 
	private String url;
	private int loginAttempts;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		
		if(request.getParameter("logout") !=null) {
			logout();
			url="index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		
		//check for initial amount of login attempts
		if(session.getAttribute("loginAttempts") == null) {
			loginAttempts = 0;
		}
		//error message for exceeding number of login attempts
		if(loginAttempts > 2) {
			String errorMessage = "Error: Number of login attempts exceeded.";
			request.setAttribute("errorMessage", errorMessage);
			url="index.jsp";
		} else {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			//running password user entered through encryption tool
			Encryption encrypted = new Encryption();
			String encryptedPassword = encrypted.encrypt(password);
			
			//Running query to pull up user
			LoginQuery lq = new LoginQuery();
			//Authenticating that the email and password is correct
			User user = lq.authenticateUser(email, encryptedPassword);
			
			//This checks to see if a user has an empty security question field. If it is empty, then it is their first time logging in and they need to set it and change their password
			boolean emptyAnswer;
			CheckAnswerQuery caq = new CheckAnswerQuery();
			emptyAnswer = caq.checkEmptyAnswer(email);
			System.out.println("Empty security answer:" + emptyAnswer);
			
			//check to see if user exists
			if (user != null && emptyAnswer == false){
				session.invalidate();
				session=request.getSession(true);
				session.setAttribute("user", user);
				url="home.jsp";
			} else if (user != null && emptyAnswer == true){
				session.invalidate();
				session=request.getSession(true);
				session.setAttribute("user", user);
				url="initialLogin.jsp";
			} else {
				String errorMessage = "Error: Unrecognized Email or Password <br>Login attempts remaining: "+(3-(loginAttempts));
				request.setAttribute("errorMessage", errorMessage);
				
				session.setAttribute("loginAttempts", loginAttempts++);
				url="index.jsp";
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
	
	public void logout() {
		session.invalidate();
	}

}