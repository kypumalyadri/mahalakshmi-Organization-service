
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY ./target/*.jar app.jar

USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
