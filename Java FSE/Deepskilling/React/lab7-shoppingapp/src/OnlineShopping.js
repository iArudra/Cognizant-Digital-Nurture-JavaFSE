import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        { name: 'Laptop', price: 45000, qty: 1 },
        { name: 'Mouse', price: 500, qty: 2 },
        { name: 'Keyboard', price: 800, qty: 1 },
        { name: 'Monitor', price: 12000, qty: 1 },
      ]
    };
  }

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>Online Shopping</h1>
        <Cart items={this.state.items} />
      </div>
    );
  }
}

export default OnlineShopping;
