package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.CheckUserQuery;
import dbHelpers.RegisterQuery;
import model.User;
import utilities.Encryption;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		int role = Integer.parseInt(request.getParameter("role"));
		
		//encrypting password
		Encryption pwd = new Encryption();
		String encryptedPass = pwd.encrypt(password);
		
		//makes sure an user with same email does not already exist
		CheckUserQuery cu = new CheckUserQuery("srcus_master", "root", "root");
		User user = cu.checkUser(email);
		
		if (user != null){
			String errorMessage = "Error: Email already exists. Try another one.";
			request.setAttribute("errorMessage", errorMessage);
			url = "registerUser.jsp";
		} else {
			User newUser = new User();
			
			newUser.setEmail(email);
			newUser.setPassword(encryptedPass);
			newUser.setfName(fName);
			newUser.setlName(lName);
			newUser.setRole(role);
			
			RegisterQuery rq = new RegisterQuery("srcus_master", "root", "root");
			
			rq.doRegister(newUser);
			
			url = "regSuccess.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
