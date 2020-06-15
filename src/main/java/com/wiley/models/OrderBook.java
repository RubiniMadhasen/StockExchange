package com.wiley.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderBook {
	@Id
	@GeneratedValue
	private int orderBookId;
	@OneToMany(mappedBy="orderBook")
	private List<OrderTable> orderTable;
	public OrderBook() {}
	public OrderBook(int orderBookId, List<OrderTable> orderTable) {
		super();
		this.orderBookId = orderBookId;
		this.orderTable = orderTable;
	}
	public int getOrderBookId() {
		return orderBookId;
	}
	public void setOrderBookId(int orderBookId) {
		this.orderBookId = orderBookId;
	}
	public List<OrderTable> getOrderTable() {
		return orderTable;
	}
	public void setOrderTable(List<OrderTable> orderTable) {
		this.orderTable = orderTable;
	}
	@Override
	public String toString() {
		return "OrderBook [orderBookId=" + orderBookId + ", orderTable=" + orderTable + "]";
	}

}
