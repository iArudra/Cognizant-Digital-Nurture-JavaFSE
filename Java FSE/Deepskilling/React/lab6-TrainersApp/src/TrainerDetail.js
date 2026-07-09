import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { trainers } from './TrainersMock';

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainers.find(t => t.id === parseInt(id));

  if (!trainer) return <div style={{ padding: '30px' }}><h2>Trainer not found</h2><Link to="/trainers">Back</Link></div>;

  return (
    <div style={{ padding: '30px', fontFamily: 'Arial', border: '2px solid #007bff', borderRadius: '10px', maxWidth: '400px', margin: '30px' }}>
      <h2>{trainer.name}</h2>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Experience:</strong> {trainer.experience} years</p>
      <p><strong>Email:</strong> {trainer.email}</p>
      <Link to="/trainers"> Back to Trainers</Link>
    </div>
  );
}

export default TrainerDetail;
