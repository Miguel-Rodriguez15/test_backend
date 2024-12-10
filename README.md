# Demo Project: Spring Boot with PostgreSQL

This is a sample project developed using **Spring Boot** and **PostgreSQL** as the database. The project is configured to run in containers using **Docker** and **Docker Compose**, meeting specific requirements to ensure the functionality that characterizes the system.

## Requirements
- The project must be developed in Spring Boot.
- Expose an endpoint to add a new franchise.
- Expose an endpoint to add a new branch to a franchise.
- Expose an endpoint to add a new product to a branch.
- Expose an endpoint to delete a product from a branch.
- Expose an endpoint to modify the stock of a product.
- Expose an endpoint to display the product with the most stock for a specific franchise by branch. The response should return a list of products indicating their respective branches.
- Use data persistence systems such as Redis, MySQL, MongoDB, or DynamoDB on any cloud provider. The choice is left open.

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/) (version 20.10 or higher)
- [Docker Compose](https://docs.docker.com/compose/install/) (version 1.29 or higher)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) (version 17)
- [Maven](https://maven.apache.org/download.cgi) (to build the project)

## Project Structure


```
/demo
│
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │ └── test
│ │ │ └── demo
│ │ │ └── DemoApplication.java
│ │ └── resources
│ │ └── application.properties
│ └── test
├── pom.xml
|___DockerFile
└── docker-compose.yml

```


## Configuration

### Base de Datos

The project uses PostgreSQL as database. The database credentials are defined in the `docker-compose.yml` file:

```yaml
dbpostgresql:
  image: postgres:latest
  restart: always
  environment:
    POSTGRES_DB: mydb
    POSTGRES_USER: postgres
    POSTGRES_PASSWORD: password

    volumes:
  pgdata:/var/lib/postgresql/data # Data persistence

```
# Installation

```
https://github.com/Miguel-Rodriguez15/test_backend.git
```


# Construction of the project

```
mvn clean package
```

# Container construction

```
docker-compose up --build
```

## Access to the project
```
http://localhost:8080
```