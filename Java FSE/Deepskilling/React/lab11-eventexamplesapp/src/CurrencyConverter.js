import React, { Component } from 'react';

class CurrencyConverter extends Component {
  constructor(props) {
    super(props);
    this.state = { inr: '', euro: '' };
  }

  handleChange = (e) => {
    const inr = e.target.value;
    const euro = (inr / 90.5).toFixed(2);
    this.setState({ inr, euro });
  };

  render() {
    return (
      <div style={{ border: '1px solid #007bff', borderRadius: '8px', padding: '20px', margin: '20px 0', maxWidth: '350px' }}>
        <h2>Currency Converter (INR  Euro)</h2>
        <label>Amount in INR: </label>
        <input
          type="number"
          value={this.state.inr}
          onChange={this.handleChange}
          style={{ padding: '5px', margin: '10px', fontSize: '16px' }}
        />
        {this.state.euro && (
          <p>Euro: <strong>{this.state.euro}</strong></p>
        )}
      </div>
    );
  }
}

export default CurrencyConverter;
