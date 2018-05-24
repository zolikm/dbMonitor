# README #

[dbMonitor](https://github.com/zolikm/dbMonitor "DbMonitor project by Zoltán Katona") Java web application built with Maven. This project is about to monitor a database table's new rows.

### Prerequisites

* Java 8
* Git client
* git clone [dbMonitor](https://github.com/zolikm/dbMonitor.git "utils project by Zoltán Katona") project:

```
git clone https://github.com/zolikm/dbMonitor.git
```

### Build ###

```
mvnw clean install
```

### Run

```
mvnw spring-boot:run
```

## Description

The original task:
* Java is a must
* appreciated tech: Maven 3, Tomcat, Spring (core, mvc, integration), SL4j, lightweight db, websockets, ActiveMQ, EasyMock/Mockito
* The program should monitor inserts in a database table and notify all the browsers with a session established every time the contents of the table change.
* 2 endpoints, Ok if running and version of the app
* README

My way to solve:
* H2 in memory db and maven wrapper for easy build and run
* flyway to initialize db
* created endpoints to be able to interact with the system as simple and as smoothly as its possible
* 2 seconds scheduled check if the there are more rows in the specified table, and if there are then send to websocket
* 

### Endpoints
* [ / ](http://localhost:8080/) endpoint to check websocket
* [/health](http://localhost:8080/health) endpoint gives back "Ok" if its running
* [/info](http://localhost:8080/info) endpoint gives back the version
* [/insert/message](http://localhost:8080/insert/Hello%20Bet%20Victor!) will persist the "message" to table
* [/select](http://localhost:8080/select) show the content of the table
* H2 web console reacheable: [http://localhost:8082](http://localhost:8082) with 

  user name: "sa"

  password: [empty]

  driver class: "org.h2.Driver"

  jdbc url: "jdbc:h2:mem:itknowledge" 
