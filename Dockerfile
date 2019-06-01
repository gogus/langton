FROM openjdk:8-jdk-alpine

RUN mkdir -p /app
COPY . /app/
WORKDIR /app/

RUN ["./gradlew", "build"]
CMD ["/usr/bin/java", "-jar", "./build/libs/langtons-ant-http-1.0.jar"]