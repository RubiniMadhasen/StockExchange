package com.wiley.dto;

public class LoginDTO {

	private String userName;
	private String passowrd;
	public LoginDTO(String userName, String passowrd) {
		super();
		this.userName = userName;
		this.passowrd = passowrd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", passowrd=" + passowrd + "]";
	}
	
	
	
}
