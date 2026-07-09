import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = { user: null, error: null, loading: true };
  }

  componentDidMount() {
    fetch('https://api.randomuser.me/')
      .then(res => res.json())
      .then(data => {
        const user = data.results[0];
        this.setState({ user, loading: false });
      })
      .catch(err => this.setState({ error: err.message, loading: false }));
  }

  render() {
    const { user, error, loading } = this.state;
    if (loading) return <p>Loading user...</p>;
    if (error) return <p style={{ color: 'red' }}>Error: {error}</p>;
    if (!user) return null;

    const { title, first, last } = user.name;
    const imgSrc = user.picture.large;

    return (
      <div style={{ textAlign: 'center', padding: '40px', fontFamily: 'Arial' }}>
        <h1>Random User</h1>
        <img src={imgSrc} alt="User" style={{ borderRadius: '50%', width: '120px', height: '120px', border: '3px solid #007bff' }} />
        <h2>{title}. {first} {last}</h2>
        <p>{user.email}</p>
        <p>{user.location.city}, {user.location.country}</p>
      </div>
    );
  }
}

export default Getuser;
