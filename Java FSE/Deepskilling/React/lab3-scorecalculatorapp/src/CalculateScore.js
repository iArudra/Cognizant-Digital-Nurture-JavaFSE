import React from 'react';
import './mystyle.css';

function CalculateScore(props) {
  const { Name, School, total, goal } = props;
  const percentage = ((goal / total) * 100).toFixed(2);
  let grade = '';
  if (percentage >= 90) grade = 'A+';
  else if (percentage >= 80) grade = 'A';
  else if (percentage >= 70) grade = 'B';
  else if (percentage >= 60) grade = 'C';
  else grade = 'F';

  return (
    <div className="scorecard">
      <h2>Score Card</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total Marks:</strong> {total}</p>
      <p><strong>Marks Scored:</strong> {goal}</p>
      <p><strong>Percentage:</strong> {percentage}%</p>
      <p><strong>Grade:</strong> {grade}</p>
    </div>
  );
}

export default CalculateScore;
