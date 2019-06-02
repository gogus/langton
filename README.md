# Langton's Ant as a Service
Application providing graphical simulation of Langton's Ant via HTTP interface.

Wiki: https://en.wikipedia.org/wiki/Langton%27s_ant

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

### Example simulation call
```bash
$ curl -X PUT "http://127.0.0.1:8080/simulate?steps=30000" > sim.png
```

## OpenAPI Documentation
- [Swagger UI](http://petstore.swagger.io/?url=https://raw.githubusercontent.com/gogus/langton/master/doc/openapi.yml)
- [Raw file](https://github.com/gogus/langton/blob/master/doc/openapi.yml)

## Improvements
- Full coverage unit tests
- API Tests
- Add limitation for host to create simulation which will take too much time