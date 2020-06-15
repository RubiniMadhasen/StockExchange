package com.wiley.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wiley.dto.SortDTO;
import com.wiley.models.OrderTable;

@Repository
public interface SortRepository extends JpaRepository<OrderTable,Integer>{	
		
		@Query("SELECT new com.wiley.dto.SortDTO(o.orderId,o.companyName,o.noOfShares,o.sharePrice,o.status) FROM OrderTable o ")
		public List<SortDTO> findAllOrders();
	
		@Query(value="DELETE FROM order_table WHERE order_id=:orderId",nativeQuery=true)
	    @Transactional
	    @Modifying
	    public int deleteOrderById(@Param("orderId")int orderId);
		
		@Query("UPDATE OrderTable o SET o.noOfShares=:shares WHERE order_id=:OrderId")
		@Modifying
		@Transactional
		public int updateOrderByOrderId(@Param("OrderId") int OrderId,@Param("shares") int shares);
		
}
