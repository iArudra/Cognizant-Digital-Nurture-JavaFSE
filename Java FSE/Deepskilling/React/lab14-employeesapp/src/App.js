import React, { Component } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';

const employees = [
  { id: 1, name: 'Alice Johnson', role: 'React Developer' },
  { id: 2, name: 'Bob Smith', role: 'Angular Developer' },
  { id: 3, name: 'Carol White', role: 'Full Stack Developer' },
];

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { theme: 'light' };
  }

  toggleTheme = () => {
    this.setState(prev => ({ theme: prev.theme === 'light' ? 'dark' : 'light' }));
  };

  render() {
    const { theme } = this.state;
    const appStyle = {
      padding: '30px',
      fontFamily: 'Arial',
      background: theme === 'dark' ? '#1a1a1a' : '#fff',
      minHeight: '100vh',
      color: theme === 'dark' ? '#fff' : '#333',
    };
    return (
      <ThemeContext.Provider value={theme}>
        <div style={appStyle}>
          <h1>Employee Management App</h1>
          <p>Current Theme: <strong>{theme}</strong></p>
          <button
            onClick={this.toggleTheme}
            style={{ padding: '10px 20px', marginBottom: '20px', cursor: 'pointer', borderRadius: '5px', border: 'none', background: '#007bff', color: 'white' }}
          >
            Toggle Theme
          </button>
          <EmployeesList employees={employees} />
        </div>
      </ThemeContext.Provider>
    );
  }
}

export default App;
