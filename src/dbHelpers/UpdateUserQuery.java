package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;
import model.ContactInfo;

public class UpdateUserQuery {
	
	private Connection connection;
	
	public UpdateUserQuery() {
		connection = MyDbConnection.getConnection();
	}
	
	public void updateUser(User user) {
		String query = "update user set email=?, fName=?, lName=?, role=? where user_id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getfName());
			ps.setString(3, user.getlName());
			ps.setInt(4, user.getRole());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent(User user, ContactInfo contactInfo, int year){
		String query = "update student set fname=?, lname=?, email=?, year=?, addressline1=?, addressline2=?, city=?, state=?, zipcode=?, organization=?, phone=? where studentid=? ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getfName());
			ps.setString(2, user.getlName());
			ps.setString(3, user.getEmail());
			ps.setInt(4, year);
			ps.setString(5, contactInfo.getAddressLine1());
			ps.setString(6, contactInfo.getAddressLine2());
			ps.setString(7, contactInfo.getCity());
			ps.setString(8, contactInfo.getState());
			ps.setInt(9, contactInfo.getZipcode());
			ps.setString(10, contactInfo.getOrganization());
			ps.setString(11, contactInfo.getPhone());
			ps.setInt(12, user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateInstructor(User user, ContactInfo contactInfo, String title){
		String query = "update instructor set fname=?, lname=?, email=?, title=?, addressline1=?, addressline2=?, city=?, state=?, zipcode=?, organization=?, phone=? where InstrID=? ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getfName());
			ps.setString(2, user.getlName());
			ps.setString(3, user.getEmail());
			ps.setString(4, title);
			ps.setString(5, contactInfo.getAddressLine1());
			ps.setString(6, contactInfo.getAddressLine2());
			ps.setString(7, contactInfo.getCity());
			ps.setString(8, contactInfo.getState());
			ps.setInt(9, contactInfo.getZipcode());
			ps.setString(10, contactInfo.getOrganization());
			ps.setString(11, contactInfo.getPhone());
			ps.setInt(12, user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateAdmin(User user){
		String query = "update administrator set fname=?, lname=?, email=? where AdminID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, user.getfName());
			ps.setString(2, user.getlName());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
