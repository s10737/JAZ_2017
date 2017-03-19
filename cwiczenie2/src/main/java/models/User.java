package models;

public class User {

	private String userName;
	private String password;
	private String email;
	public enum roleType { normal, premium, admin}
	private roleType role = roleType.normal;
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}
	public roleType getRole() {
		return role;
	}
	public void setRole(roleType role) {
		this.role = role;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
