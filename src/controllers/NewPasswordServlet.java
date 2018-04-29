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
import model.User;

/**
 * Servlet implementation class NewPasswordServlet
 */
@WebServlet({"/NewPasswordServlet", "/newPassword"})
public class NewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPasswordServlet() {
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
		session = request.getSession();
		int newPasswordUserID = Integer.parseInt(request.getParameter("user_id"));
		ReadUserQuery ruq = new ReadUserQuery();
		ruq.readUser(newPasswordUserID);
		User newPasswordUser = ruq.getUser();
		String message = "Updating password for " + newPasswordUser.getfName() + " " + newPasswordUser.getlName();
		
		session.setAttribute("newPasswordUserID", newPasswordUserID);
		request.setAttribute("message", message);
		String url ="newPassword.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
