package com.wiley.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.dto.BseDTO;
import com.wiley.dto.LoginDTO;
import com.wiley.dto.NseDTO;
import com.wiley.models.BseOrderTable;
import com.wiley.models.NseOrderTable;
import com.wiley.models.Status;
import com.wiley.models.Users;
import com.wiley.services.BuyOrderService;
import com.wiley.services.ExchangeService;
import com.wiley.services.SellOrderService;
import com.wiley.services.SortService;
import com.wiley.services.UserService;

@RestController
@CrossOrigin(origins="*",maxAge=3000)
public class OrderController {
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@Autowired
	private SellOrderService sellOrderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ExchangeService exchangeService;
	
	@Autowired
	private SortService sortService;
	
	@PostMapping("/login")
	public Status login(@RequestBody LoginDTO l)
	{
		
		String userName = l.getUserName();
		String password = l.getPassword();
		System.out.println(userName+" "+password);
		int status = userService.loginUser(userName,password);
		if(status != 0)
		{
			 return new Status(status,userName,true,"Login Success");
		}
		else
		{
			 return new Status(false,"Login Failed");
		}
	}
	
	@PostMapping("/addUser")
	public Status addUser(@RequestBody Users u)
	{
		String userName=u.getUserName();
		String password=u.getPassword();
		String email=u.getEmail();
		int i= userService.insertRecords(userName, password, email);
		if (i==1)
		{
			return new Status(true,"success");
		}
		else
		{
			return new Status(false,"failed");
		}
		
	}

	@GetMapping("/viewNseOrders")
	public List<NseDTO> getNseOrders()
	{      /* {
        "orderId": 1,
        "companyName": "apple",
        "noOfShares": 50,
        "orderType": "buy",
        "sharePrice": 2000
    }*/
		System.out.println("NSE");
		return exchangeService.loadNseOrders();
	}
	
	@GetMapping("/viewBseOrders")
	public List<BseDTO> getBseOrders()
	{  
		   /* {
        "orderId": 1,
        "companyName": "apple",
        "noOfShares": 50,
        "orderType": "buy",
        "sharePrice": 2000
    }*/
		System.out.println("BSE");
		return exchangeService.loadBseOrders();
	}
	

	@PostMapping("/buyOrder")
	public Status buyOrder(@RequestBody NseOrderTable bot)
	{
		/*
		 * userId
		 * noOfShares
		 * companyName
		 * sharePrice
		 */
		System.out.println(bot);
		int res[];
		int userId = bot.getUserId();
		int noOfShares = bot.getNoOfShares();
		String companyName = bot.getCompanyName();
		int sharePrice = bot.getSharePrice();
		res=sortService.executeBuyTrade(userId,noOfShares, companyName, sharePrice);
		if (res[0]==1)
		{
			return new Status(true,"success",res[1]);
		}
		else
		{
			return new Status(false,"failed",res[1]);
		}	
	}
	
	@PostMapping("/sellOrder")
	public Status sellOrder(@RequestBody NseOrderTable sot)
	{
		int res[];
		int userId = sot.getUserId();
		int noOfShares = sot.getNoOfShares();
		String companyName = sot.getCompanyName();
		int sharePrice = sot.getSharePrice();
	    res = sortService.executeSellTrade(userId,noOfShares, companyName, sharePrice);
		if (res[0]==1)
		{
			return new Status(true,"success",res[1]);
		}
		else
		{
			return new Status(false,"failed",res[1]);
		}	
	}
	
	@PostMapping("/viewNseUserOrder")
	public List<NseDTO> getUsersNseOrders(@RequestBody NseOrderTable sot)
	{
		
		/* {
        "orderId": 1,
        "companyName": "apple",
        "noOfShares": 50,
        "orderType": "Sell",
        "sharePrice": 2000
    }*/
		
		int userId = sot.getUserId();
		return exchangeService.loadUsersNseOrders(userId);
	}
	
	@PostMapping("/viewBseUserOrder")
	public List<BseDTO> getUsersBseOrders(@RequestBody BseOrderTable sot)
	{
		
		/* {
        "orderId": 1,
        "companyName": "apple",
        "noOfShares": 50,
        "orderType": "Sell",
        "sharePrice": 2000
    }*/
		
		int userId = sot.getUserId();
		return exchangeService.loadUsersBseOrders(userId);
	}
	
	@PostMapping("/updateUser")
	public Status updateRecords(@RequestBody Users u)
	{
		int id=u.getUserId();
		String password=u.getPassword();
		int i=userService.updateRecords(id, password);
		if (i==1)
		{
			return new Status(true,"success");
		}
		else
		{
			return new Status(false,"failed");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@PostMapping("/cancelbuyorder")
	public Status cancelBuyOrder(@RequestBody BuyOrderTable bot)
	{
		int orderId=bot.getOrderId();
		int i= buyOrderService.deleteBuyOrders(orderId);
		if (i==1)
		{
			return new Status(true,"success");
		}
		else
		{
			return new Status(false,"failed");
		}
	}
	@PostMapping("/cancelsellorder")
	public Status cancelSellOrder(@RequestBody SellOrderTable sot )
	{
		int orderId=sot.getOrderId();
		int i= sellOrderService.deleteSellOrders(orderId);
		if (i==1)
		{
			return new Status(true,"success");
		}
		else
		{
			return new Status(false,"failed");
		}
		
	}
	
	@PostMapping("/deleteuser")
	public Status deleteUser(@RequestBody Users u)
	{
		int userId=u.getUserId();
		int i= userService.deleteRecords(userId);
		if (i==1)
		{
			return new Status(true,"success");
		}
		else
		{
			return new Status(false,"failed");
		}
		
		
	}
	@PostMapping("/updateuser")
	public Status updateRecords(@RequestBody Users u)
	{
		String email=u.getEmail();
		String password=u.getPassword();
		int i=userService.updateRecords(email, password);
		if (i==1)
		{
			return new Status(true,"success");
		}
		else
		{
			return new Status(false,"failed");
		}
	}
	*/
}
