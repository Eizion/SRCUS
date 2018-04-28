package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbHelpers.UpdateUserQuery;
import model.ContactInfo;
import model.User;

/**
 * Servlet implementation class UpdateInstructorServlet
 */
@WebServlet({ "/UpdateInstructorServlet", "/UpdateInstructor" })
public class UpdateInstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInstructorServlet() {
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
		User updatedUser = (User) session.getAttribute("updatedUser");
		int userID = updatedUser.getId();
		int role = updatedUser.getRole();
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String organization = request.getParameter("organization");
		String phone = request.getParameter("phone");
		
		User user = new User();
		user.setId(userID);
		user.setEmail(email);
		user.setfName(fName);
		user.setlName(lName);
		user.setRole(role);
		
		ContactInfo contact = new ContactInfo();
		contact.setAddressLine1(addressLine1);
		contact.setAddressLine2(addressLine2);
		contact.setCity(city);
		contact.setState(state);
		contact.setZipcode(zipcode);
		contact.setOrganization(organization);
		contact.setPhone(phone);
		
		UpdateUserQuery uuq = new UpdateUserQuery();
		uuq.updateUser(user);
		uuq.updateInstructor(user, contact, title);
		
		String message = "You have successfully updated the user.";
		request.setAttribute("message", message);
		String url="/search";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
