import React, { Component } from 'react';

const flights = [
  { id: 'AI101', from: 'Chennai', to: 'Mumbai', time: '08:00', price: 4500 },
  { id: 'AI202', from: 'Bangalore', to: 'Delhi', time: '12:00', price: 5200 },
  { id: 'AI303', from: 'Hyderabad', to: 'Kolkata', time: '16:00', price: 3800 },
];

function LoginButton({ onClick }) {
  return <button onClick={onClick} style={{ padding:'10px 20px', background:'#007bff', color:'white', border:'none', borderRadius:'5px', cursor:'pointer' }}>Login</button>;
}

function LogoutButton({ onClick }) {
  return <button onClick={onClick} style={{ padding:'10px 20px', background:'#dc3545', color:'white', border:'none', borderRadius:'5px', cursor:'pointer' }}>Logout</button>;
}

function UserGreeting({ username }) {
  return <p>Welcome back, <strong>{username}</strong>! Book your flight below.</p>;
}

function GuestGreeting() {
  return <p>Please <strong>login</strong> to book a flight ticket.</p>;
}

function Greeting({ isLoggedIn, username }) {
  return isLoggedIn ? <UserGreeting username={username} /> : <GuestGreeting />;
}

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false, username: 'Arun', selectedFlight: null, booked: false };
  }

  handleLogin = () => this.setState({ isLoggedIn: true, booked: false });
  handleLogout = () => this.setState({ isLoggedIn: false, selectedFlight: null, booked: false });
  handleBook = (flight) => this.setState({ selectedFlight: flight, booked: true });

  render() {
    const { isLoggedIn, username, selectedFlight, booked } = this.state;
    return (
      <div style={{ padding: '30px', fontFamily: 'Arial' }}>
        <h1>Flight Ticket Booking</h1>
        <Greeting isLoggedIn={isLoggedIn} username={username} />
        {isLoggedIn ? <LogoutButton onClick={this.handleLogout} /> : <LoginButton onClick={this.handleLogin} />}

        <h2 style={{ marginTop: '30px' }}>Available Flights</h2>
        <table border="1" cellPadding="10" style={{ borderCollapse: 'collapse', width: '100%', maxWidth: '600px' }}>
          <thead><tr style={{ background: '#f0f0f0' }}><th>Flight</th><th>Route</th><th>Time</th><th>Price</th>{isLoggedIn && <th>Action</th>}</tr></thead>
          <tbody>
            {flights.map(f => (
              <tr key={f.id}>
                <td>{f.id}</td>
                <td>{f.from}  {f.to}</td>
                <td>{f.time}</td>
                <td>{f.price}</td>
                {isLoggedIn && (
                  <td>
                    <button
                      onClick={() => this.handleBook(f)}
                      style={{ padding:'5px 12px', background:'#28a745', color:'white', border:'none', borderRadius:'4px', cursor:'pointer' }}
                    >Book</button>
                  </td>
                )}
              </tr>
            ))}
          </tbody>
        </table>

        {booked && selectedFlight && (
          <div style={{ marginTop: '20px', padding: '15px', background: '#e6ffe6', borderRadius: '8px', maxWidth: '400px' }}>
            <h3> Booking Confirmed!</h3>
            <p>Flight: <strong>{selectedFlight.id}</strong></p>
            <p>Route: <strong>{selectedFlight.from}  {selectedFlight.to}</strong></p>
            <p>Amount: <strong>{selectedFlight.price}</strong></p>
          </div>
        )}
      </div>
    );
  }
}

export default App;
