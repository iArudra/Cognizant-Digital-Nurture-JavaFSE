import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);
    this.state = { ename: '', complaint: '', NumberHolder: '' };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    const refNum = Math.floor(Math.random() * 100);
    this.setState({ NumberHolder: refNum });
    const msg = `Thanks ${this.state.ename}\nYour Complaint was Submitted.\nTransaction ID is: ${refNum}`;
    alert(msg);
    event.preventDefault();
  };

  render() {
    return (
      <div style={{ padding: '40px', fontFamily: 'Arial', textAlign: 'center' }}>
        <h1 style={{ color: 'red' }}>Register your complaints here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <table style={{ margin: '0 auto' }}>
            <tbody>
              <tr>
                <td><label>Name:</label></td>
                <td>
                  <input
                    type="text"
                    name="ename"
                    value={this.state.ename}
                    onChange={this.handleChange}
                    style={{ padding: '5px', width: '200px' }}
                    required
                  />
                </td>
              </tr>
              <tr>
                <td><label>Complaint:</label></td>
                <td>
                  <textarea
                    name="complaint"
                    value={this.state.complaint}
                    onChange={this.handleChange}
                    rows="4"
                    style={{ padding: '5px', width: '200px' }}
                    required
                  />
                </td>
              </tr>
              <tr>
                <td colSpan="2" style={{ textAlign: 'center', paddingTop: '10px' }}>
                  <button
                    type="submit"
                    style={{ padding: '8px 20px', background: '#007bff', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}
                  >
                    Submit
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
