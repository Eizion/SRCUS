package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.ReadUserQuery;
import dbHelpers.UpdateCredsQuery;
import model.User;
import utilities.Encryption;

/**
 * Servlet implementation class AdminChangePasswordServlet
 */
@WebServlet({ "/AdminChangePasswordServlet", "/generatePassword" })
public class AdminChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePasswordServlet() {
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
		//getting variables
		HttpSession session = request.getSession();
		int newPasswordUserID = (int) session.getAttribute("newPasswordUserID");
		ReadUserQuery ruq = new ReadUserQuery();
		ruq.readUser(newPasswordUserID);
		User newPasswordUser = ruq.getUser();
		String email = newPasswordUser.getEmail();
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		String errorMessage = "";
		String url = "";
		
		//encryption
		Encryption encrypted = new Encryption();
		String encryptedNewPass = encrypted.encrypt(newPassword1);
		
		//check to see if passwords match
		if (newPassword1.compareTo(newPassword2) != 0){
			errorMessage = "The new passwords do not match.";
			request.setAttribute("errorMessage", errorMessage);
			url="newPassword.jsp";
		} else {
			UpdateCredsQuery ucq = new UpdateCredsQuery ();
			ucq.updatePassword(encryptedNewPass, email);
			String message = "You have successfully updated password.";
			request.setAttribute("message", message);
			url = "/search";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
