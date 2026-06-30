# Project Description

**Flavorista - Course Enrollment Management System**

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

# 1. Introduction

## 1.1 Purpose

Flavorista is a desktop-based cooking course enrollment management system developed using Java Swing. The system allows users to create accounts, log in securely, view available courses, and enroll in selected courses.

The application stores user and course-related information in a database and provides a simple graphical user interface for interaction.

---

## 1.2 Project Scope

The system provides:

* User registration
* User login authentication
* Course listing
* Course enrollment
* User data storage
* Course data retrieval from database
* Enrollment record management

The system is designed for users who want to browse available courses and enroll in them.

---

# 2. System Overview

## 2.1 Application Type

Desktop Application

---

## 2.2 Technology Stack

### Programming Language

* Java

### User Interface

* Java Swing

### Database

* MySQL

### Database Connectivity

* JDBC

### Architecture Pattern

* Layered architecture (UI, DAO, Model, Database)

---

# 3. System Architecture

The application follows a layered structure:

```
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
```

---

# 4. Functional Requirements

## FR-01: User Registration

### Description

The system shall allow new users to create an account.

### Input

User enters:

* Name
* Email
* Password

### Processing

The system creates a new User object and sends data to UserDAO.

The information is inserted into the users table.

### Output

If successful:

"Registration Successful"

If failed:

"Registration Failed"

---

# FR-02: User Login

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

# FR-03: Display Dashboard

### Description

After successful authentication, the system displays the dashboard.

### Information Displayed

* Welcome message
* Logged-in user ID

---

# FR-04: View Available Courses

### Description

The system shall retrieve available courses from the database.

### Course Information

The system displays:

* Course ID
* Course title
* Course price

Example:

```
1 - Java Programming ($50)
2 - Database Systems ($60)
```

---

# FR-05: Course Enrollment

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

# FR-06: Database Connection

### Description

The system shall connect to the MySQL database using JDBC.

### Connection Information

Database:

```
flavorista
```

Connection handled by:

```
DBConnection.java
```

---

# 5. User Requirements

## User

A user should be able to:

* Create an account
* Login
* Browse courses
* Enroll in courses

---

# 6. System Modules

## 6.1 Main Module

File:

```
Main.java
```

Responsibility:

* Starts application
* Opens login window

---

## 6.2 Authentication Module

Files:

```
LoginFrame.java
RegisterFrame.java
UserDAO.java
```

Responsibilities:

* Registration
* Login verification
* User management

---

## 6.3 Course Module

Files:

```
CourseListFrame.java
CourseDAO.java
```

Responsibilities:

* Fetch courses
* Display courses

---

## 6.4 Enrollment Module

Files:

```
EnrollmentDAO.java
```

Responsibilities:

* Store enrollment information

---

## 6.5 Database Module

File:

```
DBConnection.java
```

Responsibilities:

* Establish JDBC connection
* Communicate with MySQL

---

# 7. Database Requirements

Database Name:

```
flavorista
```

---

## Table: users

Purpose:

Stores registered users.

Fields:

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

Fields:

| Field | Type    |
| ----- | ------- |
| id    | Integer |
| title | String  |
| price | Double  |

---

## Table: enrollments

Purpose:

Stores user course registrations.

Fields:

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


