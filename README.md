# Expense Tracker Backend API

A RESTful Expense Tracker Backend application built using Spring Boot, Spring Data JPA, Spring Security, JWT, and MySQL. The application allows users to securely manage their personal expenses by providing authentication and expense management APIs.

---

## Features

* User Registration and Login
* JWT-based Authentication and Authorization
* Create New Expenses
* Retrieve Expense Details
* Update Existing Expenses
* Delete Expenses
* MySQL Database Integration
* Layered Architecture (Controller, Service, Repository)
* DTO Pattern and ModelMapper Integration
* RESTful API Design

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA (Hibernate)
* Spring Security
* JWT (JSON Web Token)
* MySQL
* Lombok
* ModelMapper
* Maven

---

## Project Structure

src/main/java/com/harshit/expense_tracker
├── Controller
├── Service
├── Repository
├── Model
├── DTO
├── Config
├── Security
└── Exception

---

## Database Schema

### User

* user_id
* firstname
* lastname
* username
* password
* email
* mobileNo

### Expense

* expense_id
* title
* amount
* category
* description
* expenseDate
* user_id (Foreign Key)

Relationship:
One User → Many Expenses

---

## REST APIs

### Authentication APIs

POST /auth/register

* Register a new user

POST /auth/login

* Authenticate user and generate JWT token

---

### Expense APIs

POST /expenses

* Add a new expense

GET /expenses/{id}

* Get expense by ID

PUT /expenses/{id}

* Update an existing expense

DELETE /expenses/{id}

* Delete an expense

---

## Getting Started

### Prerequisites

* JDK 21
* Maven
* MySQL Server
* IntelliJ IDEA (Recommended)

### Clone the Repository

git clone https://github.com/your-username/expense-tracker.git

cd expense-tracker

### Configure Database

Create a database:

CREATE DATABASE expense_tracker;

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

### Run the Application

mvn spring-boot:run

The application will start on:

http://localhost:8080

---

## Future Improvements

* Pagination and Sorting
* Filter Expenses by Category and Date
* Monthly Expense Reports
* Expense Analytics Dashboard
* Docker Support
* Unit and Integration Testing
* API Documentation using Swagger/OpenAPI

---

## Learning Outcomes

This project demonstrates:

* Building REST APIs using Spring Boot
* Implementing layered architecture
* Working with JPA and Hibernate relationships
* Applying DTO pattern and ModelMapper
* Implementing JWT Authentication with Spring Security
* Designing and integrating relational databases using MySQL
* Following clean code and backend development practices
