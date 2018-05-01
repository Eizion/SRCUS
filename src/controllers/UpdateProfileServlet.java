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
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet({ "/UpdateProfileServlet", "/updateProfile" })
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
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
		int role = user.getRole();
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String email = request.getParameter("email");
		int year = 0;
		String title = "";
		String addressLine1 = "";
		String addressLine2 = "";
		String city = "";
		String state = "";
		int zipcode = 0;
		String organization = "";
		String phone = "";
		
		User updatedProfile = new User();
		updatedProfile.setId(userID);
		updatedProfile.setEmail(email);
		updatedProfile.setfName(fName);
		updatedProfile.setlName(lName);
		updatedProfile.setRole(role);
		
		UpdateUserQuery uuq = new UpdateUserQuery();
		uuq.updateUser(updatedProfile);
		
		if (user.getRole() == 1){
			uuq.updateAdmin(updatedProfile);
		} else if (user.getRole() == 2){
			year = Integer.parseInt(request.getParameter("year"));
			addressLine1 = request.getParameter("addressLine1");
			addressLine2 = request.getParameter("addressLine2");
			city = request.getParameter("city");
			state = request.getParameter("state");
			zipcode = Integer.parseInt(request.getParameter("zipcode"));
			organization = request.getParameter("organization");
			phone = request.getParameter("phone");
			
			ContactInfo updatedProfileContact = new ContactInfo();
			updatedProfileContact.setAddressLine1(addressLine1);
			updatedProfileContact.setAddressLine2(addressLine2);
			updatedProfileContact.setCity(city);
			updatedProfileContact.setState(state);
			updatedProfileContact.setZipcode(zipcode);
			updatedProfileContact.setOrganization(organization);
			updatedProfileContact.setPhone(phone);
			
			uuq.updateStudent(updatedProfile, updatedProfileContact, year);
		} else if (user.getRole() == 3){
			title = request.getParameter("title");
			addressLine1 = request.getParameter("addressLine1");
			addressLine2 = request.getParameter("addressLine2");
			city = request.getParameter("city");
			state = request.getParameter("state");
			zipcode = Integer.parseInt(request.getParameter("zipcode"));
			organization = request.getParameter("organization");
			phone = request.getParameter("phone");
			
			ContactInfo updatedProfileContact = new ContactInfo();
			updatedProfileContact.setAddressLine1(addressLine1);
			updatedProfileContact.setAddressLine2(addressLine2);
			updatedProfileContact.setCity(city);
			updatedProfileContact.setState(state);
			updatedProfileContact.setZipcode(zipcode);
			updatedProfileContact.setOrganization(organization);
			updatedProfileContact.setPhone(phone);
			
			uuq.updateInstructor(updatedProfile, updatedProfileContact, title);
		}
		
		String message = "You have successfully updated the user.";
		request.setAttribute("message", message);
		String url="settings.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
