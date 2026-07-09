import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe('Cohort Details Component', () => {
  test('should create the component', () => {
    const { container } = render(<CohortDetails cohort={CohortData[0]} />);
    expect(container).toBeTruthy();
  });

  test('should initialize the props', () => {
    const { getByText } = render(<CohortDetails cohort={CohortData[0]} />);
    expect(getByText(/Alice/i)).toBeInTheDocument();
  });

  test('should display cohort code in h3', () => {
    render(<CohortDetails cohort={CohortData[0]} />);
    const heading = screen.getByRole('heading', { level: 3 });
    expect(heading.textContent).toContain('C001');
  });

  test('should always render same html (snapshot)', () => {
    const { asFragment } = render(<CohortDetails cohort={CohortData[0]} />);
    expect(asFragment()).toMatchSnapshot();
  });
});
