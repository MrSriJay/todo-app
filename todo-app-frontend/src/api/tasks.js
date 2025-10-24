import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/api/tasks',
  withCredentials: true,
});

export const createTask = (data) => API.post('', data);
export const getRecentTasks = () => API.get('');
export const completeTask = (id) => API.put(`/${id}/complete`);