FROM maven:4.0.0-rc-4-amazoncorretto-25 as builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn package -DskipTests

FROM openjdk:21-slim

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]