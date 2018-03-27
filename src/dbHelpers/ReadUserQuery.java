package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class ReadUserQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadUserQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up drive
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				table += "<td>";
					table += "<a href=update?user_id=" + user.getId() + ">update</a>";
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
	
	
}
