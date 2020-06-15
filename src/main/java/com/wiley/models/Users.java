package com.wiley.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private int userId;
	@Column(unique=true)
	private String userName;
	private String password;
	private String email;
	@OneToMany(mappedBy="user_id")
	private List<OrderTable> orders;
	public Users() {}
	public Users(int userId, String userName, String password, String email, List<OrderTable> orders) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.orders = orders;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<OrderTable> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderTable> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", orders=" + orders + "]";
	}
	
	
	
	
	

}
