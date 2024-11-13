# Spanner with Liquibase Example

This project demonstrates how to connect to Google Cloud Spanner using Java 17 and apply database schema changes using Liquibase.

## Overview

The purpose of this project is to provide a working example of:
- Connecting to a Google Cloud Spanner instance
- Applying schema changes with Liquibase changelogs

## Prerequisites

- **Java 17**: This project requires Java 17. Ensure it is installed and configured on your system.
- **Google Cloud Spanner**: You will need access to a Google Cloud Spanner instance.
- **Liquibase**: Liquibase is used to manage and apply database schema changes.

## Setup Instructions

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <project-directory>
```

## Configuration

1. Add Cloud Spanner JDBC driver and Hibernate dialect
   ```xml
   <dependency>
       <groupId>com.google.cloud</groupId>
       <artifactId>google-cloud-spanner-hibernate-dialect</artifactId>
       <version>0.1.0</version>
   </dependency>
   <dependency>
       <groupId>com.google.cloud</groupId>
       <artifactId>google-cloud-spanner-jdbc</artifactId>
       <version>1.7.0</version>
   </dependency>
   ```

1. Configure [application.properties](src/main/resources/applications.properties)
   ```
   spring.datasource.url=jdbc:cloudspanner:/projects/YOUR_PROJECT_ID/instances/demo/databases/demo
   spring.datasource.driver-class-name=com.google.cloud.spanner.jdbc.JdbcDriver
   spring.jpa.database-platform=com.google.cloud.spanner.hibernate.SpannerDialect
   ```

## Run

* From JAR:
  ```
  mvn package
  java -jar target/....jar
  ````

## Setup emulator:
```shell
gcloud config configurations create emulator
```
```shell
gcloud config set project rezende
```

```shell
gcloud config set auth/disable_credentials true
```

```shell
gcloud config set api_endpoint_overrides/spanner http://localhost:9020/
```

```shell
gcloud emulators spanner start
```
In a new Terminal run:
```shell
gcloud spanner instances create demoinstance --config=emulator-config --description="Emulated Test Instance" --nodes=1
```

```shell
gcloud spanner databases create demodb --instance demoinstance