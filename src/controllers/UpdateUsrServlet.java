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
import model.ContactInfo;
import model.Title;
import model.Year;

/**
 * Servlet implementation class UpdateUsrServlet
 */
@WebServlet({ "/UpdateUsrServlet", "/updateUser" })
public class UpdateUsrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsrServlet() {
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
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int studentID = Integer.parseInt(request.getParameter("user_id"));
		int InstrID = Integer.parseInt(request.getParameter("user_id"));
		String url = "";
		
		ReadUserQuery ruq = new ReadUserQuery();
		ruq.readUser(user_id);
		User updatedUser = ruq.getUser();
		
		session.setAttribute("updatedUser", updatedUser);
		
		if (updatedUser.getRole() == 1){
			url = "/updateForm.jsp";
		} else if (updatedUser.getRole() == 2){
			ruq.viewStudent(studentID);
			ContactInfo updatedContactInfo = ruq.getContactInfo();
			Year year = ruq.getYear();
			request.setAttribute("updatedContactInfo", updatedContactInfo);
			request.setAttribute("year", year);
			url = "/updateStudentForm.jsp";
		} else if (updatedUser.getRole() == 3){
			ruq.viewInstructor(InstrID);
			ContactInfo updatedContactInfo = ruq.getContactInfo();
			Title title = ruq.getTitle();
			request.setAttribute("updatedContactInfo", updatedContactInfo);
			request.setAttribute("title", title);
			url = "/updateInstructorForm.jsp";
		} else {
			String message = "Error retriving record.";
			request.setAttribute("message", message);
			url = "/search";
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
