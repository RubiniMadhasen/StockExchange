import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import OrderComponent from './components/OrderComponent'
function App() {
  return (
    <div className="App">
     
	 <div className="container">
								
								
								<Router>
								
 								    <Switch>
									
										<Route path="/" exact component={OrderComponent} />
									
									</Switch>
								</Router>
								
	</div>
	 
	 
	 
	 
	 
	 
	 
	 
	 
    </div>
  );
}

export default App;
