import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = { name: '', email: '', password: '', errors: {} };
  }

  validate = () => {
    const { name, email, password } = this.state;
    const errors = {};
    if (name.length < 5) errors.name = 'Full Name must be 5 characters long!';
    if (!email.includes('@') || !email.includes('.')) errors.email = 'Email is not valid!';
    if (password.length < 8) errors.password = 'Password must be 8 characters long!';
    return errors;
  };

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const errors = this.validate();
    if (Object.keys(errors).length > 0) {
      const firstError = Object.values(errors)[0];
      alert(firstError);
      this.setState({ errors });
    } else {
      alert('Registration Successful!');
      this.setState({ name: '', email: '', password: '', errors: {} });
    }
  };

  render() {
    const { name, email, password } = this.state;
    const inputStyle = { padding: '5px', width: '200px' };
    return (
      <div style={{ padding: '40px', fontFamily: 'Arial', textAlign: 'center' }}>
        <h1 style={{ color: 'red' }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <table style={{ margin: '0 auto' }}>
            <tbody>
              <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" value={name} onChange={this.handleChange} style={inputStyle} /></td>
              </tr>
              <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email" value={email} onChange={this.handleChange} style={inputStyle} /></td>
              </tr>
              <tr>
                <td><label>Password:</label></td>
                <td><input type="password" name="password" value={password} onChange={this.handleChange} style={inputStyle} /></td>
              </tr>
              <tr>
                <td colSpan="2" style={{ textAlign: 'center', paddingTop: '10px' }}>
                  <button type="submit" style={{ padding: '8px 20px', background: '#007bff', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}>
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

export default Register;
