package com.bean;

public class LoginReqBean {
	
	private String username;
	private String password;
	
	public LoginReqBean() {
		// TODO Auto-generated constructor stub
	}

	public LoginReqBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
