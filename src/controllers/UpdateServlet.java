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
@WebServlet({ "/UpdateServlet", "/updateProfile" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String errorMessage = "";
		

		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);	
		
	}

}
