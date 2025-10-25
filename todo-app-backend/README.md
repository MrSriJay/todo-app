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

## 🔐 CORS & Security Configuration

Before running the backend locally (especially when connecting from a frontend app like React or Angular), you need to **enable CORS** and **whitelist** your API endpoints in the security configuration.

In **Spring Boot 3**, define a `CorsConfiguration` bean and a `SecurityFilterChain` to allow specific HTTP methods, headers, and origins.

### ✅ Example: `SecurityConfig.java`

```java
package com.todo_app_backend.todo_app_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for local testing
            .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Apply CORS config
            .authorizeHttpRequests(auth -> auth
                // 👇 Whitelist public endpoints
                .requestMatchers("/api/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
```

### ⚡ Notes
- `http://localhost:3000` → React local dev server  
- `http://localhost:4200` → Angular local dev server (if used)  
- Add multiple origins in `setAllowedOrigins()` as needed.  
- Disabling CSRF is **only safe** for development or testing.  
- The whitelist ensures `/api/**` and `/swagger-ui.html` are **accessible** for local testing.

---