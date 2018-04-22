package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateUserQuery;
import model.User;

/**
 * Servlet implementation class UpdateUserServlet2
 */
@WebServlet({ "/UpdateUserServlet2", "/updateUser2" })
public class UpdateUserServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet2() {
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
		
		int user_id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		int role = Integer.parseInt(request.getParameter("role"));
		
		User user = new User();
		user.setId(user_id);
		user.setEmail(email);
		user.setfName(fName);
		user.setlName(lName);
		user.setRole(role);
		
		UpdateUserQuery uuq = new UpdateUserQuery();
		uuq.updateUser(user);
		
		String message = "You have successfully updated the user.";
		request.setAttribute("message", message);
		String url="/search";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
