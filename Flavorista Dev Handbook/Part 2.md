
---

# 14. Development Environment

## Development Tools

The project uses:

* Visual Studio Code
* Java Development Kit
* Maven
* Git
* Spring Boot
* React
* Cloud Services

---

# 15. Storage Optimization Strategy

The development environment is designed to avoid filling the system drive.

All development tools, caches, and projects are stored on the E drive.

Purpose:

* Keep C drive clean
* Avoid duplicate dependencies
* Reuse libraries between projects
* Support multiple applications

---

# 16. Recommended E Drive Structure

Main development location:

E:\

├── JavaEnv\

│   └── jdk-azulyfx\

├── DevTools\

│   ├── SceneBuilder\

│   └── Conveyor\

├── GlobalCaches\

│   ├── MavenRepository\

│   ├── npm-cache\

│   └── VSCodeJavaData\

├── Projects\

│   └── Flavorista\

│       ├── backend\

│       ├── frontend\

│       └── desktop\

└── Documentation\

---

# 17. Required Software Installation

## 17.1 Install Git
Add Path to PC. Restart PC

Git is required for:

* Version control
* GitHub upload
* Deployment

---

# 17.2 Install Node.js

Node.js is required for React development.

Download:

[https://nodejs.org/en/download](https://nodejs.org/en/download)
Recommended version:

Node.js 24.18.0

Direct download:

[https://nodejs.org/dist/v24.18.0/node-v24.18.0-x64.msi](https://nodejs.org/dist/v24.18.0/node-v24.18.0-x64.msi)

After installation Add Path to PC. Restart PC.  verify:

node -v

Expected:

v24.18.0

Check npm:

npm -v

---

# 17.3 Install Azul Zulu JDK with JavaFX

Java is required for:

* Spring Boot
* JavaFX desktop version

Download:

[https://www.azul.com/downloads/](https://www.azul.com/downloads/)

Recommended:

* Java 17 or 21 LTS
* Windows
* x64
* JDK FX ZIP version

Avoid:

* Standard JDK
* MSI installer

Extract to:

E:\JavaEnv\jdk-azulyfx

---

# 17.4 Configure JAVA_HOME

Windows:

Open:

Environment Variables

Create:

Variable name:

JAVA_HOME

Value:

E:\JavaEnv\jdk-azulyfx

Add to Path:

E:\JavaEnv\jdk-azulyfx\bin

Restart PC
---

# Verify Java

Open VS Code terminal:

java -version

Expected:

OpenJDK Runtime Environment Zulu

---

# 18. Install Visual Studio Code Extensions

## Extension Pack for Java

Purpose:

Provides:

* Java support
* Debugging
* Project management


---

## Spring Boot Extension Pack

Purpose:

Provides:

* Spring Boot tools
* Project support
* Running Spring applications

---

# 19. Configure VS Code Storage

VS Code Java tools create large cache files.

Move them to E drive.

Location:

E:\GlobalCaches\VSCodeJavaData

Open VS Code settings.

Open:

settings.json

Add configuration:

java.jdt.ls.vmargs

Use E drive cache location.

java.jdt.ls.java.home

Point to:

E:\JavaEnv\jdk-azulyfx

Maven repository:

E:\GlobalCaches\MavenRepository

---

# 20. Maven Configuration

Maven downloads dependencies automatically.

Default location:

C:\Users\User.m2

This can become very large.

Move Maven repository:

E:\GlobalCaches\MavenRepository

---

# Maven Repository Purpose

The same repository is shared between projects.

Example:

Flavorista

uses:

Spring Boot libraries

Another project:

uses same libraries

Maven reuses existing files.

Benefits:

* Saves storage
* Faster builds
* No duplicate downloads

---

# 21. Create Maven Settings File

Inside:

E:\GlobalCaches\MavenRepository

Create:

settings.xml

Configure Maven to use this folder.

---

# 22. Spring Initializr Setup

Spring Initializr creates Spring Boot projects.

Website:

[https://start.spring.io/](https://start.spring.io/)

---

# Project Configuration

Select:

Project:Maven

Language: Java

Packaging: Jar

Java: 17 or 21 (Based on JDk you downloaded)

---

# Dependencies

Add:

## Spring Web

Purpose:

Creates backend server.

Allows:

HTTP requests

REST APIs

---

## Spring Security

Purpose:

Authentication and protection.

---

## Spring Data JPA

Purpose:

Database operations.

---

## MySQL Driver

Purpose:

Database connection.

---

# Generate Project

Click:

Generate

Spring Initializr downloads:

A zip file

Extract:

E:\Projects\Flavorista\backend

---

# 23. Spring Boot Project Structure

backend/

├── src/

│   ├── main/

│   │

│   └── test/

├── pom.xml

└── mvnw

---

# 24. Running Spring Boot

Open terminal inside backend:

Run:

./mvnw spring-boot:run

Expected:

Started FlavoristaApp

Tomcat started on port 8080

---

# Test Backend

Open browser:

[http://localhost:8080](http://localhost:8080)

The backend server should respond.

---

# 25. Dependency Management

Dependencies are controlled through:

pom.xml

The file manages:

* Spring Boot libraries
* Database drivers
* Security libraries
* Testing tools

---

# Adding New Dependencies

Process:

Open:

pom.xml

Find:

dependencies section

Add required dependency.

Save.

Then refresh using Maven.

---

# Maven Dependency Search

Official repository:

[https://mvnrepository.com/](https://mvnrepository.com/)

Steps:

1. Search library

2. Select version

3. Copy Maven dependency

4. Paste into pom.xml

---

# 26. Database Setup

The old system used:

Local MySQL

The new system supports:

Cloud Database

Options:

## Supabase

[https://supabase.com/](https://supabase.com/)

Purpose:

Cloud database service

---

## Neon

[https://neon.tech/](https://neon.tech/)

Purpose:

Serverless PostgreSQL database

---

# 27. Desktop Application Tools

The future desktop version uses:

JavaFX

---

# Scene Builder

Purpose:

Design JavaFX interfaces visually.

Download:

[https://gluonhq.com/products/scene-builder/](https://gluonhq.com/products/scene-builder/)

Install into:

E:\DevTools\SceneBuilder

---

# Hydraulic Conveyor

Purpose:

Package Java desktop applications into:

.exe installer

Website:

[https://hydraulic.dev/](https://hydraulic.dev/)

Documentation:

[https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev)

---

# 28. Desktop Application Future Flow

JavaFX Application

↓

HTTP Requests

↓

Spring Boot Backend

↓

Cloud Database

The desktop application does not duplicate backend logic.

---

# 29. Payment Integration Future

Possible payment systems:

## Stripe

[https://stripe.com/](https://stripe.com/)

Purpose:

Online payments and subscriptions

---

## Paddle

[https://www.paddle.com/](https://www.paddle.com/)

Purpose:

Merchant and subscription management

---

## SSLCOMMERZ

Developer:

[https://developer.sslcommerz.com/](https://developer.sslcommerz.com/)

Purpose:

Bangladesh payment integration

---

## AmarPay

Developer:

[https://amarpay.com/](https://amarpay.com/)

Purpose:

Payment gateway integration

---

# 30. Development Order

Follow this order:

1. Install tools

↓

2. Configure storage locations

↓

3. Create Spring Boot backend

↓

4. Create database connection

↓

5. Create REST APIs

↓

6. Create React frontend

↓

7. Connect frontend with backend

↓

8. Upload to GitHub

↓

9. Deploy Render

↓

10. Build desktop version

---

