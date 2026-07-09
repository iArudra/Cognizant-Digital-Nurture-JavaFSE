import React from 'react';
import { books, courses, blogs } from './BookData';

// Conditional rendering using map and &&
function BookDetails({ books }) {
  const bookdet = (
    <ul>
      {books.map(book => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );
  return (
    <div style={{ borderRight: '3px solid green', paddingRight: '20px' }}>
      <h1>Book Details</h1>
      {bookdet}
    </div>
  );
}

// Conditional rendering using ternary
function CourseDetails({ courses }) {
  const coursedet = courses.length > 0 ? (
    <ul>
      {courses.map(c => (
        <div key={c.id}>
          <h3>{c.name}</h3>
          <p>{c.date}</p>
        </div>
      ))}
    </ul>
  ) : <p>No courses available</p>;
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {coursedet}
    </div>
  );
}

// Conditional rendering using logical &&
function BlogDetails({ blogs }) {
  const content = blogs && blogs.map(b => (
    <div key={b.id}>
      <h2>{b.title}</h2>
      <h4>{b.author}</h4>
      <p>{b.body}</p>
    </div>
  ));
  return (
    <div className="v1" style={{ borderLeft: '3px solid green', paddingLeft: '20px' }}>
      <h1>Blog Details</h1>
      {content}
    </div>
  );
}

function App() {
  return (
    <div style={{ display: 'flex', gap: '30px', padding: '20px', fontFamily: 'Arial' }}>
      <CourseDetails courses={courses} />
      <BookDetails books={books} />
      <BlogDetails blogs={blogs} />
    </div>
  );
}

export default App;
