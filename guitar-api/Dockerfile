FROM openjdk:21-jdk

ENV FUNCTIONS_WORKER_RUNTIME=custom
ENV PORT=8080

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
