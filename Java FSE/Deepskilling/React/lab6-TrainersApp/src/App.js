import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetail from './TrainerDetail';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/trainers" element={<TrainersList />} />
      <Route path="/trainers/:id" element={<TrainerDetail />} />
    </Routes>
  );
}

export default App;
