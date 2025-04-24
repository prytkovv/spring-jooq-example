# Spring Jooq Example

## Overview

This project demonstrates how to integrate [Spring Boot](https://spring.io/projects/spring-boot) with [jOOQ](https://www.jooq.org/) using for  for dynamic query generation, offering a type-safe and fluent API for building SQL queries.

## Features

- **jOOQ Integration**: Leverages [jOOQ](https://www.jooq.org/) for type-safe and expressive SQL query generation. Enables fluent, compile-time-safe SQL DSL with support for dynamic filters and pagination strategies.
- **Automatic jOOQ Code Generation**: Generates schema-based Java classes (POJOs, records) from your PostgreSQL database using the jooq-codegen-maven plugin at build time. This eliminates manual mapping and keeps your code in sync with the database schema.
- **PostgreSQL Support**: Integrates with a PostgreSQL database using the official JDBC driver and runtime-scoped dependency management for production-readiness.
- **Flyway Migrations**: Uses [Flyway](https://www.red-gate.com/products/flyway/community/) to manage schema versioning and database migrations, ensuring smooth updates and consistency across environments.
- **Spring Boot Integration**: Built with Spring Boot for easy configuration and deployment.

## Prerequisites

- Java 21 or later
- PostgreSQL
- curl
- jq

## Installation

Build the Java project:
```
mvn clean install
```

## Running the Application

Start the application:
```
mvn spring-boot:run
```

## Usage

You can interact with the API using simple shell scripts and curl. The responses are piped through jq for pretty-printing JSON output.

[Get a single product by id](scripts/get_product.sh)

[Get a list of products with filter](scripts/get_products.sh)
