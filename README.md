# Langton's Ant as a Service
Application providing graphical simulation of Langton's Ant via HTTP interface.

## Usage

### Standalone
```bash
$ ./gradlew build
$ java -jar ./build/libs/langtons-ant-http-1.0.jar
```

### via Docker
```bash
$ docker build -t langton:latest .
$ docker run -p 8080:8080 langton:latest
```

Service will be available under: http://localhost:8080

## OpenAPI Documentation
- [Swagger UI](http://petstore.swagger.io/?url=https://raw.githubusercontent.com/gogus/langton/master/doc/openapi.yml)
- [Raw file](https://github.com/gogus/langton/blob/master/doc/openapi.yml)