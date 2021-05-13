package com.example.todorest.todo;

public class LoginUser {
	private int userId;
	private String username;
	private String password;
	

	
	public LoginUser(int userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}