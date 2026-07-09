import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div style={{ padding: '30px', fontFamily: 'Arial' }}>
      <h1>Welcome to Trainers Portal</h1>
      <p>Find experienced trainers for your learning journey.</p>
      <Link to="/trainers" style={{ padding:'10px 20px', background:'#007bff', color:'white', borderRadius:'5px', textDecoration:'none' }}>
        View All Trainers
      </Link>
    </div>
  );
}

export default Home;
