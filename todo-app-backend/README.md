# Todo App Backend

A **Spring Boot 3.5.6** REST API backend for a **Todo Application**, built with **JPA, Hibernate, H2 (in-memory), MySQL support**, and **OpenAPI (Swagger UI)**.

---

## Features

- Create, Read, Update, Delete (CRUD) tasks
- Filter incomplete tasks with **limit of 5 most recent**
- Auto-generated OpenAPI documentation at `/swagger-ui.html`
- Fully tested with **JUnit 5 + Spring Boot Test**
- Profile-based configuration: `test` (H2), `dev/prod` (MySQL)

---

## Tech Stack

| Technology           | Version       |
|----------------------|---------------|
| Java                 | 17            |
| Spring Boot          | 3.5.6         |
| Spring Data JPA      | Included      |
| Hibernate            | 6.6.29.Final  |
| H2 Database (test)   | 2.3.232       |
| MySQL (prod)         | 8.0+          |
| Lombok               | 1.18.36       |
| Maven                | 3.9+          |
| OpenAPI / Swagger UI | 2.1.0         |

---
## Project Structure

Below is the directory structure for the project:

```plaintext
todo-app-backend/
├── src/
│   ├── main/
│   │   ├── java/com/todo_app_backend/todo_app_backend/
│   │   │   ├── controller/     # REST controllers
│   │   │   ├── entity/         # JPA entities
│   │   │   ├── repository/     # Spring Data JPA repositories
│   │   │   └── TodoAppBackendApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-test.properties
│   └── test/
│       └── java/com/todo_app_backend/todo_app_backend/
│           └── repository/     # Integration tests
├── pom.xml
└── README.md
```

---

## API Endpoints

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| `GET`    | `/api/tasks`           | Get all tasks                   |
| `POST`   | `/api/tasks`           | Create new task                 |
| `PUT`    | `/api/tasks/{id}`      | Update task                     |

> **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Setup & Run

### Prerequisites

- Java 17
- Maven 3.9+
- (Optional) MySQL 8.0+

---

## Swagger / OpenAPI

- UI: http://localhost:8080/swagger-ui.html
- JSON: http://localhost:8080/v3/api-docs
---