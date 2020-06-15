package com.wiley.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.dto.SortDTO;
import com.wiley.repositories.SortRepository;

@Service
public class SortService {

	@Autowired
	private SortRepository sortRepository;
	
	public int insertOrders(int orderId,int noOfShares,String companyName,int sharePrice,boolean status,int orderBookID)
	{
		boolean flag = true;
		List<SortDTO> s = sortRepository.findAllOrders();
		for(SortDTO i : s)
		{
			System.out.println(i);
		}
		for(SortDTO i: s)
		{
			if(i.getCompanyName().equals(companyName) && i.getNoOfShares()>=noOfShares && i.getSharePrice()>=sharePrice && i.isStatus()!=status)
			{
				 int shares = i.getNoOfShares() - noOfShares;

				 if(shares == 0)
				 {
					 sortRepository.deleteOrderById(i.getOrderId());
				 }
				 else
				 {
					 sortRepository.updateOrderByOrderId(i.getOrderId(),shares);
				 }
				 flag=false;
				 break;
			}
		}
		if(flag == true)
		{
			//Take it to Exchange Class
		}
		return 0;
	}
}
