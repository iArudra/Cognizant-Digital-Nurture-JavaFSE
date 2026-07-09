import React, { Component } from 'react';
import CurrencyConverter from './CurrencyConverter';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { message: '', formInput: '', submitted: '' };
  }

  handleClick = () => {
    this.setState({ message: 'Button was clicked!' });
  };

  handleChange = (e) => {
    this.setState({ formInput: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    this.setState({ submitted: this.state.formInput, formInput: '' });
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>Event Examples</h1>

        <section style={{ margin: '20px 0', padding: '15px', border: '1px solid #ccc', borderRadius: '8px' }}>
          <h2>Synthetic Click Event</h2>
          <button
            onClick={this.handleClick}
            style={{ padding: '10px 20px', background: '#007bff', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}
          >
            Click Me
          </button>
          {this.state.message && <p style={{ color: 'green' }}>{this.state.message}</p>}
        </section>

        <section style={{ margin: '20px 0', padding: '15px', border: '1px solid #ccc', borderRadius: '8px' }}>
          <h2>Synthetic Submit Event</h2>
          <form onSubmit={this.handleSubmit}>
            <input
              type="text"
              value={this.state.formInput}
              onChange={this.handleChange}
              placeholder="Type something..."
              style={{ padding: '8px', fontSize: '14px', marginRight: '10px' }}
            />
            <button type="submit" style={{ padding: '8px 16px', background: '#28a745', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}>
              Submit
            </button>
          </form>
          {this.state.submitted && <p>You submitted: <strong>{this.state.submitted}</strong></p>}
        </section>

        <CurrencyConverter />
      </div>
    );
  }
}

export default App;
