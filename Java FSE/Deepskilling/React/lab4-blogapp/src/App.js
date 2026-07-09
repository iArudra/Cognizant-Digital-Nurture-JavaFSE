import React, { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { posts: [], error: null };
  }

  componentDidMount() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(res => {
        if (!res.ok) throw new Error('Network response was not ok');
        return res.json();
      })
      .then(data => this.setState({ posts: data.slice(0, 10) }))
      .catch(err => this.setState({ error: err.message }));
  }

  componentDidCatch(error, info) {
    this.setState({ error: error.message });
  }

  render() {
    const { posts, error } = this.state;
    if (error) return <div style={{color:'red'}}><h2>Error: {error}</h2></div>;
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>Blog Posts</h1>
        {posts.length === 0 ? (
          <p>Loading posts...</p>
        ) : (
          posts.map(post => (
            <div key={post.id} style={{ border:'1px solid #ccc', margin:'10px', padding:'15px', borderRadius:'8px' }}>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
            </div>
          ))
        )}
      </div>
    );
  }
}

export default App;
