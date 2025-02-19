# Use the official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target folder to the container
COPY target/*.jar app.jar

# Expose port 8080 (or the port your Spring Boot app runs on)
EXPOSE 9090

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
