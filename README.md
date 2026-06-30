# Product Description

# Flavorista - Cooking Course Enrollment Management System

## Developed by Uzma, Tanni, Abida


## Purpose

This document defines the functional and non-functional requirements of the Flavorista Course Enrollment Management System.

It describes the system features, user interactions, application structure, database requirements, and limitations.

---

# 1. Product Summary

## 1.1 Product Overview

Flavorista is a Java-based cooking course enrollment management system developed as a desktop application.

The system allows users to create accounts, securely log in, browse available courses, and enroll in selected courses.

The application provides a graphical user interface using Java Swing and stores user, course, and enrollment information using a MySQL database through JDBC.

---

## 1.2 Product Background

Managing course information and user enrollments manually can become difficult when records increase.

Traditional methods may require maintaining separate records for users, courses, and enrollments, which can lead to difficulties in managing data efficiently.

Flavorista provides a centralized system where users, courses, and enrollment records can be handled through a single application.

---

## 1.3 Problem Statement

Manual course management may create problems such as:

* Difficulty maintaining user records
* Difficulty tracking course registrations
* Slow enrollment processes
* Lack of centralized information storage

Flavorista solves these problems by providing an automated course enrollment management system.

---

## 1.4 Product Motivation

This project was developed to apply practical software development concepts including:

* Object-oriented programming
* GUI application development
* Database integration
* CRUD operations
* Layered software architecture

---

## 1.5 Product Objectives

The objectives of Flavorista are:

* Develop a user-friendly course enrollment system
* Allow users to register and authenticate
* Store user and course information using a database
* Provide course browsing functionality
* Manage enrollment records
* Demonstrate Java application development with database connectivity

---

## 1.6 Target Users

### Learners

Users can:

* Create an account
* Login
* Browse available courses
* Enroll in courses

### Administrators (Future)

Administrators may:

* Manage courses
* Manage users
* Monitor enrollments

---

## 1.7 Product Scope

The system provides:

* User registration
* User login authentication
* Course listing
* Course enrollment
* User data storage
* Course data retrieval
* Enrollment record management

The system is designed for users who want to browse available courses and enroll in them.

---

## 1.8 Product Limitations

The current version does not include:

* Online payment system
* Instructor management
* Video lessons
* Certificate generation
* Mobile application
* Cloud deployment

---

# 2. Development Environment

## IDE

Visual Studio Code

## Programming Language

Java

## User Interface

Java Swing

## Database

MySQL

## Database Connectivity

JDBC

## Architecture Pattern

Layered Architecture:

* UI Layer
* DAO Layer
* Model Layer
* Database Connection Layer

---

# 3. Getting Started

## Folder Structure

The project contains the following structure:

Flavorista/

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
     └── flavorista.jpg

---

## Dependency Management

The project uses Java dependencies managed through the JAVA PROJECTS environment.

External database dependency:

* MySQL JDBC Driver

---

# 4. System Architecture

The application follows a layered structure:

User

↓

Swing UI Layer

(LoginFrame,
RegisterFrame,
DashboardFrame,
CourseListFrame)

↓

DAO Layer

(UserDAO,
CourseDAO,
EnrollmentDAO)

↓

Database Connection Layer

(DBConnection)

↓

MySQL Database

(flavorista)

---

# 5. Functional Requirements (FR)

## FR-01: User Registration

### Description

The system shall allow new users to create an account.

### Input

User enters:

* Name
* Email
* Password

### Processing

The system creates a User object and sends data to UserDAO.

The information is inserted into the users table.

### Output

If successful:

"Registration Successful"

If failed:

"Registration Failed"

---

## FR-02: User Login

### Description

The system shall authenticate existing users.

### Input

User provides:

* Email
* Password

### Processing

The system checks the users table using the provided credentials.

### Output

Successful login:

* Opens dashboard

Failed login:

* Shows invalid login message

---

## FR-03: Display Dashboard

### Description

After successful authentication, the system displays the dashboard.

### Information Displayed

* Welcome message
* Logged-in user ID

---

## FR-04: View Available Courses

### Description

The system shall retrieve available courses from the database.

### Course Information

The system displays:

* Course ID
* Course title
* Course price

Example:

1 - Java Programming ($50)

2 - Database Systems ($60)

---

## FR-05: Course Enrollment

### Description

The system shall allow logged-in users to enroll in courses.

### Input

User selects:

* Course

### Processing

EnrollmentDAO inserts:

* User ID
* Course ID

into the enrollments table.

### Output

Message:

"Enrolled Successfully"

---

## FR-06: Database Connection

### Description

The system shall connect to the MySQL database using JDBC.

Database:

flavorista

Connection handled by:

DBConnection.java

---

# 6. System Modules

## 6.1 Main Module

File:

Main.java

Responsibilities:

* Starts application
* Opens login window

---

## 6.2 Authentication Module

Files:

LoginFrame.java

RegisterFrame.java

UserDAO.java

Responsibilities:

* Registration
* Login verification
* User management

---

## 6.3 Course Module

Files:

CourseListFrame.java

CourseDAO.java

Responsibilities:

* Fetch courses
* Display courses

---

## 6.4 Enrollment Module

File:

EnrollmentDAO.java

Responsibilities:

* Store enrollment information

---

## 6.5 Database Module

File:

DBConnection.java

Responsibilities:

* Establish JDBC connection
* Communicate with MySQL

---

# 7. Database Requirements

Database Name:

flavorista

---

## Table: users

Purpose:

Stores registered users.

| Field    | Type    |
| -------- | ------- |
| id       | Integer |
| name     | String  |
| email    | String  |
| password | String  |

---

## Table: courses

Purpose:

Stores available courses.

| Field | Type    |
| ----- | ------- |
| id    | Integer |
| title | String  |
| price | Double  |

---

## Table: enrollments

Purpose:

Stores user course registrations.

| Field     | Type    |
| --------- | ------- |
| user_id   | Integer |
| course_id | Integer |

---

# 8. Non Functional Requirements

## Performance

The application should:

* Load screens quickly
* Retrieve database information efficiently

---

## Reliability

The system should:

* Maintain user records
* Prevent data loss

---

## Usability

The interface should be:

* Simple
* Easy to navigate
* Beginner-friendly

---

## Maintainability

The code should be separated into:

* UI layer
* DAO layer
* Model layer
* Database layer

---

# 9. Security Requirements

The system should:

* Validate empty input fields
* Restrict access to registered users
* Protect database operations using PreparedStatement

---

# 10. Future Improvements

Possible future upgrades:

* Convert desktop application into web application
* Add online payment system
* Add admin dashboard
* Add instructor accounts
* Add course reviews
* Add course progress tracking
* Add password encryption
* Deploy online using cloud hosting

---

# 11. Conclusion

Flavorista is a Java-based course enrollment system that demonstrates user authentication, database connectivity, CRUD operations, and GUI application development.

The current system provides the foundation for future conversion into a full-scale web-based learning platform.
