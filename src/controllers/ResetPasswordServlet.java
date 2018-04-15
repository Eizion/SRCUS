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
import model.User;
import utilities.Encryption;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet({ "/ResetPasswordServlet", "/resetPassword" })
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
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
		User user = (User) session.getAttribute("forgotUser");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String email = user.getEmail();
		String errorMessage = "";
		
		if (newPassword1.compareTo(newPassword2) != 0) {
			errorMessage = "The new passwords do not match.";
			request.setAttribute("errorMessage", errorMessage);
			url = "resetPassword.jsp";
		} else {
			Encryption encrypted = new Encryption();
			String encryptedNewPass = encrypted.encrypt(newPassword1);
			
			UpdateCredsQuery ucq = new UpdateCredsQuery ();
			ucq.updatePassword(encryptedNewPass, email);
			errorMessage = "You have successfully updated password.";
			request.setAttribute("errorMessage", errorMessage);
			url = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
	}

}
