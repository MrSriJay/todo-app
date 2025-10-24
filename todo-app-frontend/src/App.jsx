import TaskForm from './components/TaskForm';
import TasksContainer from './components/TasksContainer';
import { Toaster } from 'react-hot-toast';

export default function App() {
  return (
    <>
      <Toaster position="top-right" toastOptions={{ duration: 3000 }} />
      <div className="min-h-screen p-6">
        <div className="max-w-6xl mx-auto grid grid-cols-1 md:grid-cols-2 gap-8">
          {/* Left: Form */}
          <TaskForm onTaskAdded={() => window.location.reload()} />
          {/* Right: Tasks */}
          <div>
            <h2 className="text-2xl font-bold text-gray-800 mb-6">Recent Tasks</h2>
            <TasksContainer />
          </div>
        </div>
      </div>
    </>
  );
}