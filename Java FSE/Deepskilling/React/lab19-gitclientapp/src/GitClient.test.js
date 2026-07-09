import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockRepos = [
      { name: 'react-demo' },
      { name: 'angular-project' },
      { name: 'node-api' },
    ];
    axios.get.mockResolvedValue({ data: mockRepos });

    const repos = await GitClient.getRepositories('techiesyed');
    expect(repos).toEqual(['react-demo', 'angular-project', 'node-api']);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
