import React from 'react';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

function App() {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Cohorts Dashboard</h1>
      {CohortData.map(cohort => (
        <CohortDetails key={cohort.id} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
