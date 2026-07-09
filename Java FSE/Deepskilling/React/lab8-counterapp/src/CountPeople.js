import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = { entrycount: 0, exitcount: 0 };
  }

  handleEntry = () => {
    this.setState(prev => ({ entrycount: prev.entrycount + 1 }));
  };

  handleExit = () => {
    this.setState(prev => ({
      exitcount: prev.exitcount < prev.entrycount ? prev.exitcount + 1 : prev.exitcount
    }));
  };

  render() {
    const { entrycount, exitcount } = this.state;
    const inside = entrycount - exitcount;
    return (
      <div style={{ textAlign: 'center', padding: '40px', fontFamily: 'Arial' }}>
        <h1>People Counter</h1>
        <div style={{ fontSize: '20px', margin: '20px 0' }}>
          <p>People Entered: <strong>{entrycount}</strong></p>
          <p>People Exited: <strong>{exitcount}</strong></p>
          <p>Currently Inside: <strong>{inside}</strong></p>
        </div>
        <button
          onClick={this.handleEntry}
          style={{ margin: '10px', padding: '10px 20px', fontSize: '16px', background: '#28a745', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}
        >
          Entry 
        </button>
        <button
          onClick={this.handleExit}
          style={{ margin: '10px', padding: '10px 20px', fontSize: '16px', background: '#dc3545', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer' }}
        >
          Exit 
        </button>
      </div>
    );
  }
}

export default CountPeople;
