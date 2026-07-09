import React from 'react';

const offices = [
  { id: 1, name: 'Downtown Hub', location: 'Chennai', area: 500, rent: 45000 },
  { id: 2, name: 'Tech Park Suite', location: 'Bangalore', area: 1200, rent: 85000 },
  { id: 3, name: 'Cowork Space', location: 'Mumbai', area: 800, rent: 55000 },
  { id: 4, name: 'Premium Tower', location: 'Delhi', area: 2000, rent: 120000 },
];

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Office Space Rental</h1>
      {offices.map(office => {
        const color = office.rent < 60000 ? 'red' : 'green';
        return (
          <div key={office.id} style={{ border: '1px solid #ccc', borderRadius: '8px', padding: '15px', margin: '10px', maxWidth: '400px' }}>
            <h3 style={{ color }}>{office.name}</h3>
            <p><strong>Location:</strong> {office.location}</p>
            <p><strong>Area:</strong> {office.area} sq.ft</p>
            <p style={{ color }}><strong>Rent: {office.rent}/month</strong></p>
          </div>
        );
      })}
    </div>
  );
}

export default App;
