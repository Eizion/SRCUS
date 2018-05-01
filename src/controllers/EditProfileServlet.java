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
import model.ContactInfo;
import model.Title;
import model.User;
import model.Year;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet({ "/EditProfileServlet", "/editProfile" })
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
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
		User user = (User) session.getAttribute("user");
		
		int userID = user.getId();
		ReadUserQuery ruq = new ReadUserQuery();
		ruq.readUser(userID);
		User profile = ruq.getUser();
		request.setAttribute("profile", profile);
		
		if (user.getRole() == 2) {
			ruq.viewStudent(userID);
			ContactInfo profileContact = ruq.getContactInfo();
			Year year = ruq.getYear();
			request.setAttribute("profileContact", profileContact);
			request.setAttribute("year", year);
		}
		if (user.getRole() == 3) {
			ruq.viewInstructor(userID);
			ContactInfo profileContact = ruq.getContactInfo();
			Title title = ruq.getTitle();
			request.setAttribute("profileContact", profileContact);
			request.setAttribute("title", title);
		}
		
		String url = "editProfile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
