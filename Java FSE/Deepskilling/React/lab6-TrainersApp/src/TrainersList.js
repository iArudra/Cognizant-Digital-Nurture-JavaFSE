import React from 'react';
import { Link } from 'react-router-dom';
import { trainers } from './TrainersMock';

function TrainersList() {
  return (
    <div style={{ padding: '30px', fontFamily: 'Arial' }}>
      <h1>All Trainers</h1>
      <ul>
        {trainers.map(t => (
          <li key={t.id} style={{ margin: '10px 0' }}>
            <Link to={`/trainers/${t.id}`}>{t.name}  {t.technology}</Link>
          </li>
        ))}
      </ul>
      <Link to="/"> Back to Home</Link>
    </div>
  );
}

export default TrainersList;
