FROM openjdk:11-jdk-slim as builder
COPY . .
WORKDIR /
RUN chmod +x ./gradlew
RUN ./gradlew bootjar

FROM openjdk:11-jre-slim
COPY --from=builder build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
