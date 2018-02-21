package model;

public class User {
	
	private int user_id;
	private String email;
	private String password;
	private String fName;
	private String lName;
	private String role;
	
	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param fName
	 * @param lName
	 */
	public User(int user_id, String email, String password, String fName, String lName, String role) {
		this.user_id = user_id;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return user_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.user_id = id;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
