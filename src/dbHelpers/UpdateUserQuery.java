package dbHelpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

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

}
