# Flavorista Development Handbook

## Full Stack Application Migration and Development Guide

---

# 1. Project Information

## Project Name

Flavorista

## Project Type

Cooking Course Enrollment Management System

## Current Development Direction

Flavorista is being transformed from a local desktop application into a modern full-stack application.

The project evolution:

Old Java Desktop Application

↓

Spring Boot Backend System

↓

React Web Application

↓

Cloud Deployment

↓

Future Desktop Application Using The Same Backend

---

# 2. Project Overview

Flavorista is a course enrollment management platform designed to allow users to create accounts, securely authenticate, browse available courses, and enroll in courses.

The original version was developed as a Java Swing desktop application connected to a local MySQL database.

The upgraded version follows a modern production architecture where:

* Frontend handles user interaction
* Backend handles business logic
* Database stores application data
* Cloud hosting makes the application publicly accessible

---

# 3. Original Application Version

## 3.1 Application Type

The first version of Flavorista was:

Java Swing Desktop Application

with:

* Java
* Swing UI
* JDBC
* MySQL

---

# 3.2 Original Architecture

The original system followed a layered architecture.

Structure:

User

↓

Swing UI Layer

↓

DAO Layer

↓

Database Connection Layer

↓

MySQL Database

---

# 3.3 Original Folder Structure

The original project structure:

src/

│

├── Main.java

│

├── ui/

│   ├── LoginFrame.java

│   ├── RegisterFrame.java

│   ├── DashboardFrame.java

│   └── CourseListFrame.java

│

├── dao/

│   ├── UserDAO.java

│   ├── CourseDAO.java

│   └── EnrollmentDAO.java

│

├── model/

│   ├── User.java

│   ├── Course.java

│   └── Enrollment.java

│

├── db/

│   └── DBConnection.java

│

└── logo/

```
└── flavorista.jpg
```

---

# 3.4 Original Features

## User Management

Users could:

* Create accounts
* Login
* Store user information

---

## Course Management

Users could:

* View available courses
* Select courses

---

## Enrollment Management

Users could:

* Enroll in courses
* Store enrollment records

---

# 4. Original System Limitations

The desktop version worked locally but had limitations.

## Limited Access

The application could only run on the computer where it was installed.

Users could not access it through a browser.

---

## Local Database Dependency

The system depended on:

Local MySQL

Meaning:

* Database existed only on one machine
* Other users could not access the system remotely

---

## No Public Deployment

The application could not be deployed easily as a public website.

---

## Limited Expansion

Future features such as:

* Mobile app
* Web users
* Online payments
* Cloud storage

would require major restructuring.

---

# 5. Migration Goal

The goal is not to throw away the old project.

The goal is to reuse the existing logic and move it into a production architecture.

The migration path:

Old:

Java Swing

↓

New:

Spring Boot Backend

*

React Frontend

---

# 6. New Application Architecture

The new Flavorista architecture follows a client-server model.

Architecture:

User

↓

Browser

↓

React Frontend

↓

HTTP Requests

↓

Spring Boot Backend

↓

Service Layer

↓

Repository Layer

↓

Cloud Database

---

# 7. New Technology Stack

## Frontend

### React

Purpose:

Creates the web interface.

Responsible for:

* Pages
* Forms
* Buttons
* User interaction
* Browser display

---

### HTML

Purpose:

Creates webpage structure.

---

### CSS

Purpose:

Controls design and appearance.

---

### JavaScript

Purpose:

Adds frontend logic and communication.

---

# Backend

## Java

Main programming language.

Used for:

* Application logic
* Backend development
* Desktop development

---

## Spring Boot

Spring Boot converts Java into a web server.

Instead of:

Java program running only locally

Spring Boot allows:

Java application running as a server.

Example:

localhost:

[http://localhost:8080](http://localhost:8080)

Responsibilities:

* API creation
* Request handling
* Backend processing

---

## Spring Security

Used for:

* Authentication
* Authorization
* Protecting user data

---

## Spring Data JPA

Used for:

* Database communication
* Entity management
* Repository operations

---

## Maven

Used for:

* Dependency management
* Building applications
* Running projects

---

# Database

The database moves from local storage into cloud storage.

Possible options:

* Supabase
* Neon
* Render PostgreSQL

Benefits:

* Public access
* No local storage pressure
* Scalable system

---

# Deployment

The application will use:

## GitHub

Purpose:

* Store source code
* Track changes
* Manage versions

---

## Render

Purpose:

* Host backend
* Deploy application publicly

Users can access:

A public URL

through a browser.

---

# 8. Backend Project Structure

The Spring Boot backend follows:

fridaytcbd.flavorista

Main Application:

FlavoristaApp

Purpose:

Starts the Spring Boot server.

The backend is divided into:

controller/

service/

repository/

model/

security/

config/

---

# 9. Backend Layer Explanation

## Controller Layer

Purpose:

Receives requests from frontend.

Examples:

* Register request
* Login request
* Course request

Flow:

React

↓

Controller

---

## Service Layer

Purpose:

Contains business rules.

Responsibilities:

* Process data
* Validate information
* Apply application logic

Flow:

Controller

↓

Service

---

## Repository Layer

Purpose:

Handles database communication.

Flow:

Service

↓

Repository

↓

Database

---

## Model Layer

Purpose:

Represents database objects.

Examples:

* User
* Course
* Enrollment

---

# 10. Software Design Patterns

The new version follows software architecture patterns.

---

# 10.1 MVC Pattern

Model:

Database objects

Examples:

User

Course

Enrollment

View:

React frontend

Controller:

Spring Boot controllers

Flow:

View

↓

Controller

↓

Model

---

# 10.2 Repository Pattern

Purpose:

Separates database operations from business logic.

Without pattern:

Controller

↓

Database

With pattern:

Controller

↓

Service

↓

Repository

↓

Database

Benefits:

* Cleaner code
* Easier maintenance
* Easier testing

---

# 10.3 Dependency Injection Pattern

Spring automatically manages objects.

Benefits:

* Less manual object creation
* Loose connection between classes
* Better scalability

---

# 10.4 Layered Architecture Pattern

Complete flow:

Frontend Layer

↓

Controller Layer

↓

Service Layer

↓

Repository Layer

↓

Database Layer

---

# 11. System Features

## Registration

Users can:

* Enter name
* Enter email
* Create password
* Create account

---

## Login

Users can:

* Enter credentials
* Authenticate
* Access dashboard

---

## Course Browsing

Users can:

* View available courses
* See course information

---

## Enrollment

Users can:

* Select courses
* Register for courses
* Save enrollment records

---

## Data Management

The system stores:

* Users
* Courses
* Enrollments

---

# 12. Functional Requirements

## User Registration

The system allows new users to create accounts.

Input:

* Name
* Email
* Password

Output:

Account created.

---

## User Login

The system verifies user credentials.

Successful:

Dashboard access

Failed:

Login error message

---

## Course Management

Users can view available courses.

Information:

* Course ID
* Course name
* Course details

---

## Enrollment Management

Users can enroll in courses.

Process:

User selects course

↓

Enrollment request

↓

Database update

---

# 13. Non Functional Requirements

## Performance

The system should:

* Load quickly
* Process requests efficiently

---

## Security

The system should:

* Protect accounts
* Validate user input
* Secure data

---

## Reliability

The system should:

* Store information safely
* Prevent data loss

---

## Usability

The interface should be:

* Simple
* Clear
* Easy to use

---

## Maintainability

The system should have:

* Organized code
* Separate layers
* Reusable components

---

## Scalability

The system should support:

* More users
* More courses
* More applications

---


* Backend creation workflow
* Dependency setup
