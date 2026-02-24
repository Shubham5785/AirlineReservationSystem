# ✈️ Airline Reservation System (Spring Boot + PostgreSQL)

 ## 📌 Project Overview
A RESTful Airline Reservation System built using Spring Boot and PostgreSQL.

This project demonstrates secure authentication using JWT, role-based authorization, clean layered architecture, request validation, and global exception handling.
It simulates a real-world backend system for managing flights and bookings.

## 🚀 Features
• User Registration & Login (JWT Authentication)
• Role-Based Access (ADMIN / USER)
• Create Flight (Admin)
• Update Flight (Admin)
• Delete Flight (Admin)
• View All Flights with Pagination & Sorting
• Book Flight
• DTO Pattern Implementation
• Input Validation using Jakarta Validation
• Global Exception Handling
• Clean Layered Architecture (Controller → Service → Repository)
• Swagger API Documentation

## 🛠 Tech Stack
• Java 17
• Spring Boot 3
• Spring Security
• JWT (JSON Web Token)
• Spring Data JPA
• PostgreSQL
• Swagger (OpenAPI)
• Maven

## 🔐 Security
• JWT-based authentication
• BCrypt password encryption
• Role-based endpoint protection
• Secure configuration using environment variables

## 📖 API Documentation
Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

## ⚙️ Environment Configuration
Set the following environment variables before running the project:

DB_URL = jdbc:postgresql://localhost:5432/airline_db
DB_USER = your_username
DB_PASS = your_password

## ▶️ How to Run
Clone the repository

Configure environment variables

Run the application using:

mvn spring-boot:run

The server will start at:

http://localhost:8080

## 👨‍💻 Author
Shubham Patil
Java & Spring Boot Developer
