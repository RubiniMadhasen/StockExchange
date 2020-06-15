package com.wiley.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.dto.OrderDTO;
import com.wiley.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderDTO> loadOrders()
	{
		return orderRepository.findAllOrders();
	}
	
	public int insertOrders(int orderId,int noOfShares,String companyName,int sharePrice,boolean status,int orderBookID)
	{
		return orderRepository.addorders(orderId, noOfShares, companyName, sharePrice, status, orderBookID);
	}
	
    public int deleteOrders(int orderId)
    {
    	return orderRepository.deleteOrder(orderId);
    }

}
