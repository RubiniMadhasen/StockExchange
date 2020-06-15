import axios from 'axios';


class OrderServiceAPI{
	
	
	getOrders(){
		
		return axios.get("http://localhost:8085/vieworders");
	}
	
	
	
	
	
	
	
	
}


export default new OrderServiceAPI();

