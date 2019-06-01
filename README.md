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


## OpenAPI Documentation
[Available here](https://github.com/gogus/langton/blob/master/doc/openapi.yml)