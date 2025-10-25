# 📒 Full-Stack Todo Application | Dockerized with React & Spring Boot

[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE) [![Node.js](https://img.shields.io/badge/node-%3E%3D%2020.0-brightgreen?logo=node.js)](https://nodejs.org) [![React](https://img.shields.io/badge/React-18.2.0-61DAFB?logo=react)](https://reactjs.org) [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-6DB33F?logo=spring)](https://spring.io/projects/spring-boot) [![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql)](https://www.mysql.com/) [![Docker](https://img.shields.io/badge/Docker-20.10+-2496ED?logo=docker)](https://www.docker.com)

A modern, containerized **Todo List** application demonstrating a robust **Full-Stack** architecture. The project features a fast **React + Vite + Tailwind** frontend and a secure **Spring Boot + MySQL** backend, all orchestrated using **Docker Compose**.

---

## ✨ Key Features

This application is built for simplicity and scale, offering:

* ✅ **Core Functionality:** Seamlessly create, view, and mark tasks as complete.
* 📱 **Responsive Design:** A modern, adaptive user interface powered by **Tailwind CSS**.
* 🔒 **Secure API:** Implemented CORS and credential handling for secure communication.
* 📦 **Containerization:** Production-ready and development-friendly **Docker** setup.
* 🔥 **Hot Reload:** Rapid development iteration with instant updates in the development environment.
* 🔎 **API Testing:** Integrated **Swagger UI** for easy endpoint exploration and testing.

---

## 🛠️ Technology Stack

This project leverages a powerful and modern stack for a high-performance application:

| Layer | Technology | Version / Tooling |
| :--- | :--- | :--- |
| **Frontend** | **React** | 18, Vite, **Tailwind CSS** |
| **Backend** | **Spring Boot** | 3.5.6, Spring Data JPA |
| **Database** | **MySQL** | 8.0 |
| **Container** | **Docker** | Docker Compose |
| **Proxy** | **Nginx** | Reverse Proxy Configuration |

---

## 🚀 Quick Start Guide

Get the application running in three simple steps! Ensure you have **Docker** and **Docker Compose** installed before beginning.

### Prerequisites

* **[Docker](https://www.docker.com/get-started)**
* **[Docker Compose](https://docs.docker.com/compose/)**

---

## 🚀 Quick Start

### 🧩 Clone and Start the Application
```bash
git clone https://github.com/MrSriJay/todo-app.git
cd todo-app
docker compose up --build
```

### 🌐 Access the Application

Once all services are up and running, you can access the application using the following URLs:

- **Frontend:** [http://localhost:5174](http://localhost:5174)  
- **API Base URL:** [http://localhost:5174/api/tasks](http://localhost:5174/api/tasks)  
- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


---

### 🐳 Docker Setup

This project uses **Docker Compose** to orchestrate multiple services:

| Service              | Description                | Port  |
|---------------------|----------------------------|-------|
| `todo-app-frontend` | React + Tailwind Frontend  | 5174  |
| `todo-app-backend`  | Spring Boot REST API       | 8080  |
| `db`                | MySQL Database             | 3306  |
### ⚙️ Common Docker Commands

Rebuild and start containers:

```bash
docker compose up --build
```
Stop all running containers:

```bash
docker compose down -v
```

View container logs:

```bash
docker compose logs -f
```

---
### 📝 API Endpoints

| Method | Endpoint                    | Description            |
|--------|----------------------------|------------------------|
| GET    | /api/tasks                 | Get all tasks          |
| POST   | /api/tasks                 | Create task            |
| PUT    | /api/tasks/{id}/complete   | Mark task as completed |

---

### 🛠️ Tech Stack

| Layer     | Technology                           |
|-----------|-------------------------------------|
| Frontend  | React 18, Vite, Tailwind CSS         |
| Backend   | Spring Boot 3.5.6, Spring Data JPA   |
| Database  | MySQL 8.0                            |
| Container | Docker + Docker Compose               |
| Proxy     | Nginx (reverse proxy)                |

---

### 📚 More README

For detailed instructions and documentation for each project component, check the links below:

- **Backend Project README:** [todo-app-backend README](https://github.com/MrSriJay/todo-app/blob/d7f6df52dec15e09b2b80698387d88d46d5c13b5/todo-app-backend/README.md)  
- **Frontend Project README:** [todo-app-frontend README](https://github.com/MrSriJay/todo-app/blob/d7f6df52dec15e09b2b80698387d88d46d5c13b5/todo-app-frontend/README.md)

---

## Status Badges

<img src="https://img.shields.io/github/last-commit/MrSriJay/todo-app" alt="GitHub last commit">
<img src="https://img.shields.io/github/issues/MrSriJay/todo-app" alt="GitHub issues">
<img src="https://img.shields.io/github/issues-pr/MrSriJay/todo-app" alt="GitHub pull requests">
<img src="https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/MrSriJay/todo-app/main/.upptimerc.json" alt="Uptime">

---
