# TED REST API

This project was generated with [Spring Initializer](https://start.spring.io/) with Spring Boot version 2.0.5.

## Build and Run the application

To run the application, execute:

`./gradlew build && java -jar build/libs/ted-0.0.1-SNAPSHOT.jar`

If you are using Maven, execute:

`mvn package && java -jar target/ted-0.0.1-SNAPSHOT.jar`

## REST Endpoints

- http://localhost:8081/tedevent/all - retrieves of first 5 ted events.
- http://localhost:8081/tedevent/page/0 - first page containg 10 ted events will be retrived.
- http://localhost:8081/tedevent/page?number=1&event=TED2006 - secong page containg 10 ted events filtered by event name **"TED2006"** will be retrived.

## Running unit tests

Run `mvn test` to execute the unit tests.
