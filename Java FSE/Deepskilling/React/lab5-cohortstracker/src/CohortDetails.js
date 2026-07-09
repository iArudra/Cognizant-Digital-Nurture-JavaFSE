import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const isOngoing = cohort.status === 'ongoing';
  const cardClass = `${styles.card} ${isOngoing ? styles.ongoing : styles.completed}`;
  const statusClass = isOngoing ? styles.statusOngoing : styles.statusCompleted;

  return (
    <div className={cardClass}>
      <h3>{cohort.code}: {cohort.name}</h3>
      <p><strong>Trainer:</strong> {cohort.trainer}</p>
      <p><strong>Start:</strong> {cohort.startDate}</p>
      <p><strong>End:</strong> {cohort.endDate}</p>
      <p><strong>Status:</strong> <span className={statusClass}>{cohort.status}</span></p>
    </div>
  );
}

export default CohortDetails;
