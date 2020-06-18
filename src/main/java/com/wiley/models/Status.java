package com.wiley.models;

public class Status {
	private int userId;
	
	private String userName;
	
	private boolean status;
	
     private String message;
     
     private int feeLader;
     
     public Status() {}
     
	public Status(boolean status, String message, int feeLader) {
		super();
		this.status = status;
		this.message = message;
		this.feeLader = feeLader;
	}


	public Status(int userId, String userName, boolean status, String message) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.status = status;
		this.message = message;
	}
     
     public Status(int userId, boolean status, String message) {
 		super();
 		this.userId = userId;
 		this.status = status;
 		this.message = message;
 	}


     
	public int getFeeLader() {
		return feeLader;
	}

	public void setFeeLader(int feeLader) {
		this.feeLader = feeLader;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	
	public Status(boolean status, String message){
		this.status=status;
		this.message=message;
     }
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Status [userId=" + userId + ", userName=" + userName + ", status=" + status + ", message=" + message
				+ ", feeLader=" + feeLader + "]";
	}



	



}
