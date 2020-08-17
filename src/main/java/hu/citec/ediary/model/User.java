package hu.citec.ediary.model;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private boolean activated;
	
	public User() {
	
	}


	public User(int userId, String userName, String password, String fullName, String email, boolean activated) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.activated = activated;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isActivated() {
		return activated;
	}


	public void setActivated(boolean activated) {
		this.activated = activated;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", activated=" + activated + "]";
	}

	
	
	
	
}
