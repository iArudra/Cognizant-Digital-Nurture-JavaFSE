import React, { Component } from 'react';
import GitClient from './GitClient';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { repos: [], loading: true, error: null };
  }

  componentDidMount() {
    GitClient.getRepositories('techiesyed')
      .then(repos => this.setState({ repos, loading: false }))
      .catch(err => this.setState({ error: err.message, loading: false }));
  }

  render() {
    const { repos, loading, error } = this.state;
    return (
      <div style={{ padding: '30px', fontFamily: 'Arial' }}>
        <h1>GitHub Repositories for <em>techiesyed</em></h1>
        {loading && <p>Loading repositories...</p>}
        {error && <p style={{ color: 'red' }}>Error: {error}</p>}
        <ul>
          {repos.map((name, idx) => (
            <li key={idx} style={{ margin: '5px 0' }}>{name}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;
