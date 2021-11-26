# hotel-reservation-service
> Hotel reservation management system.

[![Spring-Boot Version](spring-boot-sm.png)][spring-boot-url]
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

This project is a RestFul application, in which it is possible to manage an online reservation system of a network of fictional hotels in Miami. The network comprises three hotels: Lakewood, Bridgewood and Ridgewood. Each hotel has different rates for a weekday or weekend, including specific rates for loyalty program participants. Additionally, each hotel has a rating, indicating the excellence of the service.

It were used JPA, Spring Boot and PostegreSql.

Persistence and endpoints Tests were implemented using Junit.


## Requirements
For building and running the application you need:

- [JDK 1.8](https://www.oracle.com/java/technologies/javase-downloads.html#JDK11)
- [Maven 3](https://maven.apache.org/) (or later)
- [Postgres 13](https://www.postgresql.org/about/news/postgresql-13-released-2077/)


## Installation

1. Clone the repository

```sh
git clone https://github.com/andrehgustavo/hotel-reservation-service
```

2. Configure PostgreSQL
First run the 'create_database.sql' file found in the src\main\resources\static directory in your Postgres database manager. Then run the second script, 'populate_db.sql' to populate the Database  . Then, open src/main/resources/application.properties file and change the spring datasource username and password as per your PostgreSQL installation.

## Usage example

- As a user, I would like to list all hotels;
- As a user, I would like to register a new hotel;
- As a user, I would like to edit an existing hotel;
- As a user, I would like to know the cheapest hotel from a date list.

## Development setup


There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the src\main\java\br\com\projects\HotelReservationServiceApplication class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) plugin like:

```shell
cd hotel-reservation-service
mvn spring-boot:run
```

## Endpoints
    - [GET] List all hotels ("hotel-reservation/api/v1/hotels")
    - [GET] Get a specific hotel ("hotel-reservation/api/v1/hotels/{id}")
    - [POST] Add new hotel ("hotel-reservation/api/v1/hotels/")
    - [PUT] Update a hotel ("hotel-reservation/api/v1/hotels/")
    - [DELETE] Delete a hotel ("hotel-reservation/api/v1/hotels/{id}")

//TODO: Terminar endpoints
## Meta

André Gustavo Barros – [@andrehgustavo](https://www.linkedin.com/in/andr%C3%A9-gustavo-barros-457b9a43/) – andreh_gustavo@hotmail.com

[hotel-reservation-service](https://github.com/andrehgustavo/hotel-reservation-service)

<!-- Markdown link & img dfn's -->
[spring-boot-url]: https://ci.spring.io/teams/spring-boot/pipelines/spring-boot-2.4.x

