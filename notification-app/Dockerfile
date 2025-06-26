# Use a lightweight OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy your Spring Boot jar into the container (adjust the name if needed)
COPY build/libs/notification-app-*.jar app.jar

# Expose the port your app uses (match application.properties)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
