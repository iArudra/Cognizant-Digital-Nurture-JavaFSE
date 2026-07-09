import React from 'react';
import CalculateScore from './CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore Name="John" School="Springfield High" total={500} goal={430} />
      <CalculateScore Name="Jane" School="Westlake Academy" total={500} goal={380} />
    </div>
  );
}

export default App;
