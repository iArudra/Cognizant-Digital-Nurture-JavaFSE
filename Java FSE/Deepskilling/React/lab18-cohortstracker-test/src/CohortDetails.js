import React from 'react';

function CohortDetails({ cohort }) {
  if (!cohort) return null;
  const isOngoing = cohort.status === 'ongoing';
  return (
    <div style={{ border: '2px solid #ccc', borderRadius: '10px', padding: '20px', margin: '15px', width: '280px', display: 'inline-block' }}>
      <h3>{cohort.code}: {cohort.name}</h3>
      <p><strong>Trainer:</strong> {cohort.trainer}</p>
      <p><strong>Start:</strong> {cohort.startDate}</p>
      <p><strong>End:</strong> {cohort.endDate}</p>
      <p><strong>Status:</strong> <span style={{ color: isOngoing ? 'green' : 'blue' }}>{cohort.status}</span></p>
    </div>
  );
}

export default CohortDetails;
