# Use lightweight OpenJDK
FROM openjdk:17-jdk-slim

# Set working dir
WORKDIR /app

# Copy the fat JAR (built by Maven) into the container
COPY target/grpc-service-*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]