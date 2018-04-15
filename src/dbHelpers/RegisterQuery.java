package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import model.ContactInfo;
import model.User;

public class RegisterQuery {
	
	private Connection connection;
	
	public RegisterQuery() {
		connection = MyDbConnection.getConnection();
	}
	
	public void doRegister(User user) {
		
		String query = "insert into user (email, password, fName, lName, role) values (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getfName());
			ps.setString(4, user.getlName());
			ps.setInt(5, user.getRole());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void addToAdmin(User user, int userID){
		
		String query = "insert into administrator (adminid, fName, lName, email) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, userID);
			ps.setString(2, user.getfName());
			ps.setString(3, user.getlName());
			ps.setString(4, user.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void addToStudent(User user, ContactInfo contactInfo, int year, int userID ){
		
		String query = "insert into student (studentid, fName, lName, email, year, addressline1, addressline2, city, state, zipcode, organization, phone) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, userID);
			ps.setString(2, user.getfName());
			ps.setString(3, user.getlName());
			ps.setString(4, user.getEmail());
			ps.setInt(5, year);
			ps.setString(6, contactInfo.getAddressLine1());
			ps.setString(7, contactInfo.getAddressLine2());
			ps.setString(8, contactInfo.getCity());
			ps.setString(9, contactInfo.getState());
			ps.setInt(10, contactInfo.getZipcode());
			ps.setString(11, contactInfo.getOrganization());
			ps.setString(12, contactInfo.getPhone());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public void addToInstructor(User user, ContactInfo contactInfo, String title, int userID){
		
String query = "insert into instructor (InstrID, fName, lName, email, title, addressline1, addressline2, city, state, zipcode, organization, phone) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, userID);
			ps.setString(2, user.getfName());
			ps.setString(3, user.getlName());
			ps.setString(4, user.getEmail());
			ps.setString(5, title);
			ps.setString(6, contactInfo.getAddressLine1());
			ps.setString(7, contactInfo.getAddressLine2());
			ps.setString(8, contactInfo.getCity());
			ps.setString(9, contactInfo.getState());
			ps.setInt(10, contactInfo.getZipcode());
			ps.setString(11, contactInfo.getOrganization());
			ps.setString(12, contactInfo.getPhone());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
