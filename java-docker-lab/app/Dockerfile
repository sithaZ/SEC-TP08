# Use Eclipse Temurin JDK 17 as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the source code
COPY Server.java .

# Compile the Java code
RUN javac Server.java

# Run the compiled class
CMD ["java", "Server"]