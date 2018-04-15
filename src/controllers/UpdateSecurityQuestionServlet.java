package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UpdateSecurityQuestionQuery;
import model.User;

/**
 * Servlet implementation class UpdateSecurityQuestionServlet
 */
@WebServlet({ "/UpdateSecurityQuestionServlet", "/updateSecurityQuestion" })
public class UpdateSecurityQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session; 
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSecurityQuestionServlet() {
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
		User user = (User) session.getAttribute("user");
		
		int sq_id = Integer.parseInt(request.getParameter("sq"));
		String answer = request.getParameter("answer");
		int user_id = user.getId();
		
		UpdateSecurityQuestionQuery usq = new UpdateSecurityQuestionQuery();
		usq.updateAnswer(sq_id, answer, user_id);
		
		String message = "You have successfully updated your security question.";
		request.setAttribute("message", message);
		url = "settings.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
		
	}

}