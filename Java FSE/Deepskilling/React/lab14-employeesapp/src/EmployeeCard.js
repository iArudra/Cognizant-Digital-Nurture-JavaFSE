import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);
  const btnStyle = theme === 'dark'
    ? { background: '#333', color: '#fff', border: '1px solid #555' }
    : { background: '#e0e0e0', color: '#333', border: '1px solid #ccc' };

  const cardStyle = {
    border: '1px solid #ccc',
    borderRadius: '8px',
    padding: '15px',
    margin: '10px',
    background: theme === 'dark' ? '#2d2d2d' : '#f9f9f9',
    color: theme === 'dark' ? '#fff' : '#333',
    width: '220px',
    display: 'inline-block',
  };

  return (
    <div style={cardStyle}>
      <h3>{employee.name}</h3>
      <p>{employee.role}</p>
      <button style={{ ...btnStyle, padding: '5px 12px', borderRadius: '4px', cursor: 'pointer' }}>
        View Profile
      </button>
    </div>
  );
}

export default EmployeeCard;
