# 💻 Todo App Frontend

A **modern, responsive Todo App frontend** built with **React 18**, **Vite**, **Tailwind CSS**, and **Axios**, seamlessly integrated with the **Spring Boot backend**.

Live Demo: [http://localhost:5173](http://localhost:5173)

---

## 🚀 Features

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

## 🛠️ Tech Stack

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

## 📁 Project Structure

```plaintext
todo-app-frontend/
├── public/
│   └── index.html
├── src/
│   ├── api/
│   │   └── tasks.js               # API service
│   ├── components/
│   │   ├── TaskForm.jsx           # Add task form
│   │   ├── TaskList.jsx           # Task cards
│   │   └── TasksContainer.jsx     # Data fetching
│   ├── App.jsx                    # Main layout
│   ├── main.jsx
│   └── index.css                  # Tailwind + custom styles
├── tailwind.config.js
├── postcss.config.js
├── vite.config.js
├── package.json
└── README.md
```

---

## ⚙️ Setup & Run

### 1. Prerequisites
- Node.js **18+**
- npm **9+**

### 2. Run Development Server (without Docker)

```bash
npm install
npm run dev
```
Then open [http://localhost:5173](http://localhost:5173)

---

## 🔗 Backend Integration

**API Base URL:** `http://localhost:8080/api/tasks`

| Endpoint                  | Method | Purpose                       |
|----------------------------|--------|-------------------------------|
| `/api/tasks`               | POST   | Create a new task             |
| `/api/tasks`               | GET    | Get recent incomplete tasks   |
| `/api/tasks/{id}/complete` | PUT    | Mark task as done             |

---

## 🧠 CORS Configuration Notes

If you are running the backend locally, ensure your backend’s **CORS configuration** allows requests from your frontend (`localhost:5173`).

In Spring Boot, you can enable this by updating your **`CorsConfiguration`** in the backend config class:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(List.of("http://localhost:5173"));
            config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            config.setAllowedHeaders(List.of("*"));
            return config;
        }))
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .antMatchers("/api/**").permitAll()
            .anyRequest().authenticated()
        );
    return http.build();
}
```

This ensures your frontend can communicate with the backend without CORS issues during local development.

---
# 🖼️ UI Guide

An interactive walkthrough of the Todo App interface:
<p align="center">
  <img 
    src="https://github.com/MrSriJay/todo-app/blob/main/todo-app-frontend/public/ui-guide.gif" 
    alt="UI Guide Animation"
    width="80%"
    style="border-radius: 12px; box-shadow: 0 4px 10px rgba(0,0,0,0.2); margin: 10px 0;"
  />
</p>

> 💡 This animation demonstrates how tasks are added, viewed, and marked as complete in real-time.

<p align="center">
  <img 
    src="https://github.com/MrSriJay/todo-app/blob/e2993d4238e080040810a83db5d19f435f033dfb/todo-app-frontend/public/ui-snapshot.png"
    alt="UI Snapshot"
    width="75%"
    style="border-radius: 12px; box-shadow: 0 4px 10px rgba(0,0,0,0.2); margin-top: 15px;"
  />
</p>

> 🪶 The Todo App features a notebook-inspired UI with soft yellow and cream tones for a relaxing, minimalist experience.

---