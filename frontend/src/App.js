import React, { Component } from 'react';
import axios from 'axios'
import monty from './monty.jpg';
import './App.css';
import BackendHealth from './BackendHealth/BackendHealth';

class App extends Component {
  constructor(props) {
		super(props);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
    e.preventDefault();
    var swapped;
    if(document.getElementById("swap").checked){
      swapped = true;
    }
    else
      swapped = false;
    var inputs = [document.getElementById("simNumber").value,
                  swapped];
	 onSend(inputs);
	}

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <BackendHealth/>
          <img src={monty} className="App-monty" alt="logo" />
          <h1 className="App-title">Welcome to the Monty Hall Simulator</h1>
        </header>
        <form method="post">
          Nr of simulations:<input required="true" type="number" min="1" placeholder="10" id="simNumber"/><br/>
          Swap door:<input required type="checkbox" id="swap"/><br/>
          <input name="submit" type="button" value="submit" onClick={this.handleSubmit} />                                        
        </form>
        <p id="response"></p>
      </div>
    );
  }
}

function onSend(inputs){
  
  const simulations = inputs[0];
  const swap = inputs[1];
  console.log()

  axios.post("http://localhost:8080/calculate", {
    simNum: simulations,
    changeDoor: swap
  },{
    headers:{
      'Content-Type': 'application/json',
    }
  })
  .then(res =>{
    document.getElementById('response').innerHTML = "You win "+res.data+" times out of "+simulations+" rounds.<br/>"+
    "(That is roughly "+Math.round((res.data/simulations)*100)+"% of the times)";
  })
  .catch(function (error) {
    console.log(error);
  });
}

export default App;
