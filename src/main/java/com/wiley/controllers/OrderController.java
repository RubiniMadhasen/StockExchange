package com.wiley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.dto.OrderDTO;
import com.wiley.services.OrderService;
import com.wiley.services.SortService;

@RestController
@CrossOrigin(origins = "*",maxAge=3600)
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SortService sortService;
	
	@GetMapping("/vieworders")
	public List<OrderDTO> getOrders()
	{
		return orderService.loadOrders();
	}
	
	@PostMapping("/addorders/{orderId}/{noOfShares}/{companyName}/{sharePrice}/{status}/{orderBookId}")
	public int insertOrders(@PathVariable("orderId")int orderId,@PathVariable("noOfShares")int noOfShares,@PathVariable("companyName")String companyName,@PathVariable("sharePrice")int sharePrice,@PathVariable("status")boolean status,@PathVariable("orderBookId")int orderBookID)
	{
		return sortService.insertOrders(orderId, noOfShares, companyName, sharePrice, status, orderBookID);
	}
   
	@PostMapping("cancelorder/{orderId}")
   public int cancelOrder(@PathVariable("orderId")int orderId)
   {
	   return orderService.deleteOrders(orderId);
   }

}
