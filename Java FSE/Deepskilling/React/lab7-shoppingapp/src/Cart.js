import React, { Component } from 'react';

class Cart extends Component {
  render() {
    const { items } = this.props;
    const total = items.reduce((sum, item) => sum + item.price * item.qty, 0);
    return (
      <div>
        <h2>Shopping Cart</h2>
        <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%' }}>
          <thead>
            <tr style={{ background: '#f0f0f0' }}>
              <th>Item</th>
              <th>Price</th>
              <th>Qty</th>
              <th>Subtotal</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, idx) => (
              <tr key={idx}>
                <td>{item.name}</td>
                <td>{item.price}</td>
                <td>{item.qty}</td>
                <td>{item.price * item.qty}</td>
              </tr>
            ))}
          </tbody>
          <tfoot>
            <tr>
              <td colSpan="3"><strong>Total</strong></td>
              <td><strong>{total}</strong></td>
            </tr>
          </tfoot>
        </table>
      </div>
    );
  }
}

export default Cart;
