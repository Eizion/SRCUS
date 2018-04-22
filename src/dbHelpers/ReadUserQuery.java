package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ContactInfo;
import model.User;
import model.Year;

public class ReadUserQuery {
	
	private Connection connection;
	private ResultSet results;
	
	private User user = new User();
	private int user_id;
	private ContactInfo contactInfo = new ContactInfo();
	private int studentID;
	private int intr_ID;
	private Year year = new Year();
	private String title;
	
	public ReadUserQuery() {
		connection = MyDbConnection.getConnection();
	}

	public void doRead() {
		
		String query = "select user_id, email, fName, lName, role from user;";
			try {
				PreparedStatement ps = this.connection.prepareStatement(query);
				this.results = ps.executeQuery();
			} catch (SQLException e) {					
			// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	
	public String getHTMLTable() {
		
		String table = "";
		table += "<table class='sortable' border='1'>";
		table += "<tr>";
		table += "<th>Email</th>";
		table += "<th>First Name</th>";
		table += "<th>Last Name</th>";
		table += "<th>Role</th>";
		table += "<th>Action</th>";
		table += "</tr>";
		
		try {
			while(this.results.next()) {
				User user = new User();
				user.setId(this.results.getInt("user_id"));
				user.setEmail(this.results.getString("email"));
				user.setfName(this.results.getString("fName"));
				user.setlName(this.results.getString("lName"));
				user.setRole(this.results.getInt("role"));
				
				table += "<tr>";
				table += "<td>";
				table += user.getEmail();
				table += "</td>";
				table += "<td>";
				table += user.getfName();
				table += "</td>";
				table += "<td>";
				table += user.getlName();
				table += "</td>";
				table += "<td>";
				//table += user.getRole();
				if (user.getRole() ==1) {
					table += "Administrator";
				} else if (user.getRole() == 2) {
					table += "Student";
				} else if (user.getRole() == 3) {
					table += "Instructor";
				} else {
					table += "<span style='color:red;'>Invalid role! Please update!</span>";
				}
				table += "</td>";
				/*if (user.getRole() == 1) {
					table += "<td>";
					table += "<a href=updateUser?user_id=" + user.getId() + ">update</a>";
					table += "</td>";
				} else if (user.getRole() == 2) {
					table += "<td>";
					table += "<a href=updateUser?user_id=" + user.getId() + ">update</a>";
					table += "</td>";
				} else if (user.getRole() == 3) {
					table += "<td>";
					table += "<a href=updateUser?user_id=" + user.getId() + ">update</a>";
					table += "</td>";
				} */
				table += "<td>";
				table += "<a href=updateUser?user_id=" + user.getId() + ">update</a>";
				table += "</td>";
				table += "</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		
		return table;
		
	}
	
	/*public void viewUser() {
		
		String query = "select user_id, email, fName, lName, role from user where user_id=?;";
			try {
				PreparedStatement ps = this.connection.prepareStatement(query);
				this.results = ps.executeQuery();
			} catch (SQLException e) {					
			// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	
	public void viewAdmin() {
		String query = "select user_id, email, fName, lName, role from user where user_id=?;";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {					
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void viewStudent(int studentID) {
		String query = "select Year, AddressLine1, AddressLine2, City, State, Zipcode, Organization, Phone from student where StudentID=?;";
		
		this.studentID = studentID;
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setInt(1, studentID);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			year.setYear(this.results.getInt("year"));
			contactInfo.setAddressLine1(this.results.getString("AddressLine1"));
			contactInfo.setAddressLine2(this.results.getString("AddressLine2"));
			contactInfo.setCity(this.results.getString("City"));
			contactInfo.setState(this.results.getString("State"));
			contactInfo.setZipcode(this.results.getInt("Zipcode"));
			contactInfo.setOrganization(this.results.getString("Organization"));
			contactInfo.setPhone(this.results.getString("Phone"));
			
			
		} catch (SQLException e) {					
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewInstructor(int InstrID) {
		String query = "select InstrID, Title, AddressLine1, AddressLine2, City, State, Zipcode, Organization, Phone from student where InstrID=?;";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setInt(1, InstrID);
			this.results = ps.executeQuery();
		} catch (SQLException e) {					
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readUser(int user_id) {
		String query = "select user_id, email, fName, lName, role from user where user_id=?";
		
		this.user_id = user_id;
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.user_id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			user.setId(this.results.getInt(1));
			user.setEmail(this.results.getString("email"));
			user.setfName(this.results.getString("fName"));
			user.setlName(this.results.getString("lName"));
			user.setRole(this.results.getInt("role"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public User getUser(){
		return this.user;
	}
	
	public ContactInfo getContactInfo(){
		return this.contactInfo;
	}
	
	public Year getYear(){
		return this.year;
	}
	
	
}
