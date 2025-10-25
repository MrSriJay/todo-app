# ---- Build ----
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests clean package

# ---- Runtime ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/todo-app-backend-*.jar app.jar

# Copy from correct classpath location
COPY src/main/resources/application-docker.properties /app/application-docker.properties

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar", \
            "--spring.profiles.active=docker"]