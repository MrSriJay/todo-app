// todo-app-frontend/src/api.js
import axios from 'axios';

const API = axios.create({
  baseURL: '/api/tasks',  // Proxied by nginx
  withCredentials: true,
});

export const createTask = (data) => API.post('', data);
export const getRecentTasks = () => API.get('');
export const completeTask = (id) => API.put(`/${id}/complete`);