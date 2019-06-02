FROM openjdk:11-jdk-slim

RUN mkdir -p /app
COPY . /app/
WORKDIR /app/

RUN ["./gradlew", "build"]
CMD ["java", "-jar", "./build/libs/langtons-ant-http-1.0.jar"]