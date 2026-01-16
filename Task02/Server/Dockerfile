FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

FROM eclipse-temurin:17-jdk-focal
WORKDIR /app
COPY --from=build /app/target/rabbitmq-app-1.0.jar app.jar
CMD ["java", "-cp", "app.jar", "RPCServer"]