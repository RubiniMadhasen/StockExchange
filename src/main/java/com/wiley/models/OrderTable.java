package com.wiley.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderTable {
	@Id
	@GeneratedValue
	private int orderId;
	private int noOfShares;
	private String companyName;
	private int sharePrice;
	private boolean status;
	@ManyToOne
	@JoinColumn(name="orderbook_id")
	private OrderBook orderBook;
	public OrderTable() {}
	public OrderTable(int orderId, int noOfShares, String companyName, int sharePrice, boolean status,
			OrderBook orderBook) {
		super();
		this.orderId = orderId;
		this.noOfShares = noOfShares;
		this.companyName = companyName;
		this.sharePrice = sharePrice;
		this.status = status;
		this.orderBook = orderBook;
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
	public OrderBook getOrderBook() {
		return orderBook;
	}
	public void setOrderBook(OrderBook orderBook) {
		this.orderBook = orderBook;
	}
	@Override
	public String toString() {
		return "OrderTable [orderId=" + orderId + ", noOfShares=" + noOfShares + ", companyName=" + companyName
				+ ", sharePrice=" + sharePrice + ", status=" + status + ", orderBook=" + orderBook + "]";
	}
    
}
