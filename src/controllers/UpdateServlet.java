package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		
		try {
		    //Setup the Database datasource
		    Context    ctx = new InitialContext();
		    Context env = ( Context )ctx.lookup( "java:comp/env" );
		    DataSource ds = ( DataSource )env.lookup( "jdbc/srcus_master");
		    Connection conn = ds.getConnection();

		    //Prepare the SQL statmenet to insert the values
		    PreparedStatement stmt = conn.prepareStatement("UPDATE user(uname, fname, lname)  VALUES (?,?,?)");
		    stmt.setString(1, email);
		    stmt.setString(2, fname);
		    stmt.setString(3, lname);
	

		    //Execute the insert
		    stmt.executeUpdate();
		    conn.close();

		    //Dispatch into success page
		    RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewProfile.jsp");
		    requestDispatcher.forward(req, res);
		}
		    catch(Exception e){
		        System.out.println(e);
		    }
	
	}
	

}
