# Doctor-Patient Management Platform

## Overview

This project is a Doctor-Patient Management Platform where doctors can register their patients through a mobile or web portal. The platform includes backend APIs to handle functionalities such as adding doctors and their specialties, adding patients and their symptoms, and suggesting doctors based on a patient's symptoms and location.

## Technologies Used

- **Java**
- **Spring Boot** - for building the REST APIs
- **Hibernate** - for database operations
- **MySQL** - as the database
- **Swagger** - for API documentation

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- MySQL 5.7 or higher

### Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/Avinash4231/Hospital-API-using-spring-boot
Navigate to the project directory



https://github.com/Avinash4231/Hospital-API-using-spring-boot/assets/119235391/7718bab1-47db-4b04-8349-e0ae2e5cf263


cd HOSPITALAPI
Configure the database

Create a MySQL database named avidb.
Update the application.properties file with your MySQL username and password.
properties

spring.datasource.url=jdbc:mysql://localhost:3306/avidb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
Build the project


mvn clean install
Run the application


mvn spring-boot:run
Access Swagger UI

Open your browser and go to http://localhost:8080/swagger-ui.html to view and test the APIs.
