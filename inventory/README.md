# HKTV coding task - java web inventory system

## System requirement
* Java
* Spring-boot
* MySQL Server
* XAMPP
* Visual Studio Code
* Postman

## Starting with Spring Initializr
* Java - java version "1.8.0_271"
* Maven - Apache Maven 3.6.3
* Dependencies: mysql, web-starter, hibernate(JPA), devTools

## MYSQL
```bash
create table inventory2(
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255),
    code varchar(255),
    created_at datetime,
    updated_at datetime,
    weight int(11),
    cwb int(11),
    tko int(11),
    tsw int(11),
    PRIMARY KEY (id)
);
```

## VS code extension for Java and Spring Boot
* Spring Boot Extension Pack
* Language support for Java by RedHat
*  Maven for Java by Microsoft
* Java Extension Pack by Microsoft
* Spring Initializr Java by Microsoft
* Debugger for Java by Microsoft
* Spring Boot Dashboard for VS code

## Run the application
run the following command in a terminal window directory
```bash
./mvnw spring-boot:run
```

Go to homepage on browser
```bash
localhost:8080/
```

Database
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/test
```

## Daily progress
Day 1
- study java framework and database
- create and run spring boot project w/ spring initializr
- set up MySQL
- connect spring boot to MySQL by adding MySQL configuration in application.properites
- create table in MySQL
- create item attributes in MySQL

Day 2
- build controller, model, repository, service
- develop homepage, item list
- create item
- update item
- delete item

Day 3
- csv helper
- csv service class
- response message
- upload controller
- file upload exception
- upload csv file
- search an item in item list
- transfer inventory in edit page

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.2/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#using-boot-devtools)

