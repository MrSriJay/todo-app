import { completeTask } from '../api/tasks';
import toast from 'react-hot-toast';
import { CheckCircle, Clock } from 'lucide-react';

export default function TaskList({ tasks, onTaskUpdate }) {
  const handleComplete = async (id) => {
    try {
      await completeTask(id);
      toast.success('Task completed!');
      onTaskUpdate();
    } catch (err) {
      toast.error('Failed to complete task');
    }
  };

  if (tasks.length === 0) {
    return (
      <div className="card text-center py-12">
        <p className="text-stone-700 text-lg">No tasks yet. Add one to get started!</p>
      </div>
    );
  }

  return (
    <div className="space-y-4">
      {tasks.map((task) => (
        <div
          key={task.id}
          className="bg-yellow-50 rounded-2xl p-6 shadow-md hover:shadow-lg transition-all duration-300 flex justify-between items-start"
        >
          <div className="flex-1">
            <h3 className="text-lg font-bold text-stone-900 flex items-center gap-2">
              <Clock className="w-5 h-5 text-amber-600" /> {task.title}
            </h3>
            {task.description && (
              <p className="text-stone-700 mt-1 text-sm leading-relaxed">{task.description}</p>
            )}
            <p className="text-xs text-stone-500 mt-2 flex items-center gap-1">
              {new Date(task.createdAt).toLocaleString()}
            </p>
          </div>
          <button
            onClick={() => handleComplete(task.id)}
            className="btn-done flex items-center gap-2"
          >
            <CheckCircle className="w-4 h-4 text-amber-600" />
            Done
          </button>
        </div>
      ))}
    </div>
  );
}
