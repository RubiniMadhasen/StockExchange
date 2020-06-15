package com.wiley.dto;

public class OrderDTO {
	private int orderId;
	private int noOfShares;
	private String companyName;
	private int sharePrice;
	private boolean status;
	public OrderDTO() {}
	public OrderDTO(int orderId, int noOfShares, String companyName, int sharePrice, boolean status) {
		super();
		this.orderId = orderId;
		this.noOfShares = noOfShares;
		this.companyName = companyName;
		this.sharePrice = sharePrice;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", noOfShares=" + noOfShares + ", companyName=" + companyName
				+ ", sharePrice=" + sharePrice + ", status=" + status + "]";
	}
	
}
