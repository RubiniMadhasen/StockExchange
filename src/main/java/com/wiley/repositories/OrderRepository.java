package com.wiley.repositories;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wiley.dto.LoginDTO;
import com.wiley.dto.OrderDTO;
import com.wiley.models.OrderTable;



@Repository
public interface OrderRepository extends JpaRepository<OrderTable,Integer>{
    
	@Query("SELECT new com.wiley.dto.OrderDTO(o.orderId,o.noOfShares,o.companyName,o.sharePrice,o.status) FROM OrderTable o ")
	public List<OrderDTO> findAllOrders();
    
    @Query(value="INSERT INTO order_table (order_id,no_of_shares,company_name,share_price,status,orderbook_id) VALUES(:orderId,:noOfShares,:companyName,:sharePrice,:status,:oBookId)",nativeQuery=true)
    @Transactional
    @Modifying
    public int addorders(@Param("orderId")int orderId,@Param("noOfShares")int noOfShares,@Param("companyName")String companyName,@Param("sharePrice")int sharePrice,@Param("status")boolean status,@Param("oBookId")int orderBookID);
    
    @Query(value="DELETE FROM order_table WHERE order_id=:orderId",nativeQuery=true)
    @Transactional
    @Modifying
    public int deleteOrder(@Param("orderId")int orderId);
    
}
