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
import com.wiley.services.UserService;

@RestController
@CrossOrigin(origins = "*",maxAge=3600)
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SortService sortService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login/{userName}/{password}")
	public Boolean loginUser(@PathVariable("userName")String userName,@PathVariable("password")String password)
	{
		  int l = userService.loginUser(userName,password);
		  if(l==1)
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		  
	}
	
	@GetMapping("/vieworders")
	public List<OrderDTO> getOrders()
	{
		return orderService.loadOrders();
	}
	
	public void insert()
	{
		
	}
   
	@PostMapping("/addorders/{orderId}/{noOfShares}/{companyName}/{sharePrice}/{status}/{orderBookId}")
	public int insertOrder(@PathVariable("orderId")int orderId,@PathVariable("noOfShares")int noOfShares,@PathVariable("companyName")String companyName,@PathVariable("sharePrice")int sharePrice,@PathVariable("status")boolean status,@PathVariable("orderBookId")int orderBookID)
	{
		return sortService.insertOrders(orderId, noOfShares, companyName, sharePrice, status, orderBookID);
	}
	
	@PostMapping("/executeTrade/{}")
	public int executeTrade(@PathVariable("orderId")int orderId,@PathVariable("noOfShares")int noOfShares,@PathVariable("companyName")String companyName,@PathVariable("sharePrice")int sharePrice,@PathVariable("status")boolean status,@PathVariable("orderBookId")int orderBookID)
	{
		return sortService.insertOrders(orderId, noOfShares, companyName, sharePrice, status, orderBookID);
	}
	
	@PostMapping("cancelorder/{orderId}")
   public int cancelOrder(@PathVariable("orderId")int orderId)
   {
	   return orderService.deleteOrders(orderId);
   }
	
   
	@PostMapping("adduser/{userName}/{password}/{email}")
	public int addUser(@PathVariable("userName")String userName,@PathVariable("password")String password,@PathVariable("email")String email)
	{
		return userService.insertRecords(userName, password, email);
	}
	@PostMapping("deleteuser/{userId}")
	public int deleteUser(@PathVariable("userId")int userId)
	{
		return userService.deleteRecords(userId);
	}
	@PostMapping("updateuser/{email}/{password}")
	public int updateRecords(@PathVariable("email")String email,@PathVariable("password")String password)
	{
		return userService.updateRecords(email, password);
	}

}
