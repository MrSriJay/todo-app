# 📝 Todo App Backend

A **Spring Boot 3.5.6** REST API backend for a **Todo Application**, built with **Spring Data JPA, Hibernate, H2 (in-memory), MySQL**, and **OpenAPI (Swagger UI)** for documentation.

---

## 🚀 Features

- ✅ Create, Read, Update, Delete (CRUD) operations for tasks  
- 🔍 Filter **incomplete tasks** (limited to 5 most recent)  
- 🧠 Auto-generated **OpenAPI documentation** at `/swagger-ui.html`  
- 🧪 Fully tested using **JUnit 5 + Spring Boot Test**  
- ⚙️ **Profile-based configuration**:  
  - `test` → uses **H2** (in-memory)  
  - `dev` / `prod` → uses **MySQL**

---

## 🧰 Tech Stack

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

## 📂 Project Structure

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

## 🌐 API Endpoints

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| `GET`  | `/api/tasks`           | Get all tasks                   |
| `POST` | `/api/tasks`           | Create a new task               |
| `PUT`  | `/api/tasks/{id}`      | Update a task                   |
| `DELETE` | `/api/tasks/{id}`    | Delete a task                   |

> **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
> **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## 📘 Example API Usage

### ➕ Create Task
**Request**
```http
POST /api/tasks
Content-Type: application/json
```

**Body**
```json
{
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs",
  "completed": false
}
```

**Response**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs",
  "completed": false
}
```

---

### ✅ Get All Tasks
```http
GET /api/tasks
```

**Response**
```json
[
  {
    "id": 1,
    "title": "Buy groceries",
    "completed": false
  },
  {
    "id": 2,
    "title": "Clean the room",
    "completed": true
  }
]
```

---

## ⚙️ Setup & Run

### 🧩 Prerequisites

- **Java 17**
- **Maven 3.9+**
- *(Optional)* **MySQL 8.0+**

---

### 🧠 Environment Variables (for MySQL)
If running in `dev` or `prod` profile, set the following:

```bash
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/todo_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=yourpassword
SPRING_JPA_HIBERNATE_DDL_AUTO=update
```

---

### ▶️ Run Locally (H2 - default)
```bash
mvn spring-boot:run
```

Access the app at:  
👉 `http://localhost:8080`  
Swagger UI:  
👉 `http://localhost:8080/swagger-ui.html`

---

### 🐳 Run with Docker

#### 1. Build JAR
```bash
mvn clean package -DskipTests
```

#### 2. Build Image
```bash
docker build -t todo-app-backend .
```

#### 3. Run Container
```bash
docker run -p 8080:8080 todo-app-backend
```

---

## 🧪 Running Tests

Run integration and unit tests with:
```bash
mvn test
```

> Tests use an **H2 in-memory database** under the `test` profile.

---

## 🧾 Swagger / OpenAPI

| Resource | URL |
|-----------|-----|
| Swagger UI | [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) |
| API Docs (JSON) | [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs) |

---

## 📦 Build Commands

| Command | Description |
|----------|-------------|
| `mvn clean` | Clean target directory |
| `mvn package` | Build JAR package |
| `mvn spring-boot:run` | Run application locally |
| `mvn test` | Run all tests |

---