import React from 'react';

const players = [
  { id: 1, name: 'Rohit Sharma', score: 85, team: 'T20', t20: true, ranji: false },
  { id: 2, name: 'Virat Kohli', score: 120, team: 'Both', t20: true, ranji: true },
  { id: 3, name: 'Shubman Gill', score: 75, team: 'Ranji', t20: false, ranji: true },
  { id: 4, name: 'KL Rahul', score: 95, team: 'T20', t20: true, ranji: false },
  { id: 5, name: 'Hardik Pandya', score: 60, team: 'Both', t20: true, ranji: true },
];

function App() {
  // map, filter, destructuring, spread
  const scores = players.map(({ id, name, score }) => ({ id, name, score }));
  const t20Team = players.filter(p => p.t20);
  const ranjiTeam = players.filter(p => p.ranji);
  const allPlayers = [...t20Team, ...ranjiTeam.filter(p => !p.t20)];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Cricket App</h1>

      <h2>All Player Scores</h2>
      <table border="1" cellPadding="8" style={{ borderCollapse: 'collapse' }}>
        <thead><tr><th>Name</th><th>Score</th></tr></thead>
        <tbody>
          {scores.map(({ id, name, score }) => (
            <tr key={id}><td>{name}</td><td>{score}</td></tr>
          ))}
        </tbody>
      </table>

      <h2>T20 Team</h2>
      <ul>{t20Team.map(p => <li key={p.id}>{p.name}</li>)}</ul>

      <h2>Ranji Team</h2>
      <ul>{ranjiTeam.map(p => <li key={p.id}>{p.name}</li>)}</ul>

      <h2>All Unique Players (Spread)</h2>
      <ul>{allPlayers.map(p => <li key={p.id}>{p.name}  {p.team}</li>)}</ul>
    </div>
  );
}

export default App;
