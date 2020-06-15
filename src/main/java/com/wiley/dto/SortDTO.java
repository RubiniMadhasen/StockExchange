package com.wiley.dto;

public class SortDTO {

	
	public int orderId;
	private String companyName;
	private int noOfShares;
	private int sharePrice;
	private boolean status;
	
	public SortDTO()
	{
		
	}

	public SortDTO(int orderId, String companyName, int noOfShares, int sharePrice, boolean status) {
		super();
		this.orderId = orderId;
		this.companyName = companyName;
		this.noOfShares = noOfShares;
		this.sharePrice = sharePrice;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
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
		return "SortDTO [orderId=" + orderId + ", companyName=" + companyName + ", noOfShares=" + noOfShares
				+ ", sharePrice=" + sharePrice + ", status=" + status + "]";
	}

	
	
}
