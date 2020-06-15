import React, {Component} from 'react'
import OrderServiceAPI from '../services/OrderServiceAPI';
class OrderComponent extends Component{

	
	constructor(props){
		super(props);
		
		this.state = {
			
			orders : [],
			result:''
			
		}
		
		
		this.getAllOrders= this.getAllOrders.bind(this);
		
		
	}
		
	componentDidMount(){
		
		this.getAllOrders();
	}
	
	
	getAllOrders(){
				
		OrderServiceAPI.getOrders()
							.then( res => {
								
								this.setState({orders: res.data})
								
							}
		
			)	
		}
	
	
	render(){
		
		return (
		
		
		<div>
		
			<table>
			
			
			  <thead>
				
				<th> order_id </th>
				<th> no_of_shares </th>
				<th> company_name </th>
				<th> share_price </th>
				<th> status </th>
			  
			  </thead>
			  
			  <tbody>
			  
			  {
				  
				this.state.orders.map(
					order =>
					
						<tr key={order.orderId}>
						
						
							<td> {order.orderId} </td>
							<td> {order.noOfShares} </td>
							<td> {order.companyName} </td>
							<td> {order.sharePrice} </td>
							<td> {order.status.toString()} </td>
						
						</tr>
					
									  
				 ) 
			  }
				
			  
			  </tbody>
			
			
			</table>
		
		
		</div>
		
		
		
	   )
		
		
	}
	
	


}

export default OrderComponent;