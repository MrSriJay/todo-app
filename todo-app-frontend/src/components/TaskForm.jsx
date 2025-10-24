import { useState } from 'react';
import { createTask } from '../api/tasks';
import toast from 'react-hot-toast';

export default function TaskForm({ onTaskAdded }) {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!title.trim()) return toast.error('Title is required');

    setLoading(true);
    try {
      await createTask({ title, description });
      setTitle('');
      setDescription('');
      toast.success('Task added successfully!');
      onTaskAdded();
    } catch (err) {
      toast.error('Failed to add task');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2 className="text-2xl font-bold text-stone-900 mb-6 flex items-center gap-2">
        📝 Add a Task
      </h2>
      <form onSubmit={handleSubmit} className="space-y-5">
        <div>
          <label className="label flex items-center gap-1">
            ✏️ Title
          </label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder="What needs to be done?"
            className="input-field"
          />
        </div>
        <div>
          <label className="label flex items-center gap-1">
            🗒 Description <span className="text-stone-500">(optional)</span>
          </label>
          <textarea
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            placeholder="Add details..."
            rows="4"
            className="input-field resize-none"
          />
        </div>
        <button type="submit" disabled={loading} className="btn-primary flex items-center justify-center gap-2">
          {loading ? '⏳ Adding...' : 'Add Task'}
        </button>
      </form>
    </div>
  );
}
