package hu.citec.ediary.model;

public class CustomUser {
	private int userId;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private boolean activated;
	private int roleId;
	private String roleType;
	
	
	
	
	public CustomUser() {
	}


	public CustomUser(int userId, String userName, String password, String fullName, String email, boolean activated,
			int roleId, String roleType) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.activated = activated;
		this.roleId = roleId;
		this.roleType = roleType;
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


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleType() {
		return roleType;
	}


	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}


	@Override
	public String toString() {
		return "CustomUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName="
				+ fullName + ", email=" + email + ", activated=" + activated + ", roleId=" + roleId + ", roleType="
				+ roleType + "]";
	}
	
	
	
	
	
	
}
