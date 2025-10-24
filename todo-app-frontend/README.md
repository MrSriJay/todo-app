# Todo App Frontend

A **modern, responsive Todo App frontend** built with **React 18**, **Vite**, **Tailwind CSS**, and **Axios**, seamlessly integrated with the **Spring Boot backend**.

Live Demo: [http://localhost:5173](http://localhost:5173)

---

## Features

- Add new tasks with title & description
- View **5 most recent incomplete tasks**
- Mark tasks as **completed**
- **Auto-refresh every 5 seconds**
- Beautiful, **classy UI** with **Tailwind CSS**
- Toast notifications (`react-hot-toast`)
- Loading skeleton
- Fully **component-based architecture**
- **CORS-ready** for `localhost:5173`

---

## Tech Stack

| Technology            | Version       |
|-----------------------|---------------|
| React                 | 18.3.1        |
| Vite                  | 5.4.10        |
| Tailwind CSS          | **4.1.14**    |
| Axios                 | 1.12.2        |
| Lucide React Icons    | 0.546.0       |
| react-hot-toast       | 2.6.0         |
| tailwind-merge        | 3.3.1         |
| ESLint                | 9.13.0        |

---

## Project Structure

Below is the directory structure for the project:

```plaintext

todo-app-frontend/
├── public/
│   └── index.html
├── src/
│   ├── api/
│   │   └── tasks.js               API service
│   ├── components/
│   │   ├── TaskForm.jsx           Add task form
│   │   ├── TaskList.jsx           Task cards
│   │   └── TasksContainer.jsx     Data fetching
│   ├── App.jsx                    Main layout
│   ├── main.jsx
│   └── index.css                  Tailwind + custom styles
├── tailwind.config.js
├── postcss.config.js
├── vite.config.js
├── package.json
└── README.md

```
---

## Setup & Run

### 1. Prerequisites

- Node.js **18+**
- npm **9+**

### 2. Clone & Install

```bash
git clone <your-repo-url>
cd todo-app-frontend
```

### 3. Run Development Server

```bash
npm run dev
```
Open: http://localhost:5173

---

# Backend Integration

**API Base URL:** `http://localhost:8080/api/tasks`

| Endpoint                  | Method | Purpose                  |
|----------------------------|--------|--------------------------|
| `/api/tasks`               | POST   | Create a task            |
| `/api/tasks`               | GET    | Get recent incomplete tasks |
| `/api/tasks/{id}/complete` | PUT    | Mark task as done        |

---

# UI Snapshots

![UI Snapshot](https://github.com/MrSriJay/todo-app/blob/e2993d4238e080040810a83db5d19f435f033dfb/todo-app-frontend/public/ui-snapshot.png)



---
