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
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet({ "/UpdatePasswordServlet", "/updatePassword" })
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
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
		String email = user.getEmail();
		String oldPassword1 = user.getPassword();
		String oldPassword2 = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String errorMessage = "";
		System.out.println("email" + email);
		
		//running in entered password through encryption tool
		Encryption encrypted = new Encryption();
		String encryptedPassword2 = encrypted.encrypt(oldPassword2);
		String encryptedNewPass = encrypted.encrypt(newPassword1);
		
		//check to make sure passwords match
		if (oldPassword1.compareTo(encryptedPassword2) != 0){
			errorMessage = "Your current password was incorect.";
			request.setAttribute("errorMessage", errorMessage);
			url="changePassword.jsp";
		}
		if (newPassword1.compareTo(newPassword2) != 0){
			errorMessage = "The new passwords do not match.";
			request.setAttribute("errorMessage", errorMessage);
			url="changePassword.jsp";
		} 
		if (oldPassword1.compareTo(encryptedPassword2) == 0 && newPassword1.compareTo(newPassword2) == 0){
			UpdateCredsQuery ucq = new UpdateCredsQuery ("srcus_master", "root", "root");
			ucq.updatePassword(encryptedNewPass, email);
			String message = "You have successfully updated password.";
			request.setAttribute("message", message);
			url = "settings.jsp";
		} else {
			errorMessage = "Something went wrong. We were unable to update your password.";
			request.setAttribute("errorMessage", errorMessage);
			url="changePassword.jsp";
		}
		
		System.out.println("encrypt2:" + encryptedPassword2);
		System.out.println("new1:" + newPassword1);
		System.out.println("new2:" + newPassword2);
		System.out.println("new encr:" + encryptedNewPass);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
		
	}

}
