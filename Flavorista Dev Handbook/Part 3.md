# 31. React Frontend Setup

The frontend is responsible for the user interface of Flavorista.

It handles:

* Pages
* Forms
* Buttons
* User interaction
* Displaying data
* Sending requests to Spring Boot

The frontend communicates with the backend through REST APIs.

Flow:

React Frontend

↓

HTTP Request

↓

Spring Boot Backend

↓

Database

---

# 32. React Environment Verification

Before creating the project, verify Node.js and npm.

Check Node.js:

node -v

Expected:

v24.18.0

Check npm:

npm -v

Check Vite:

npm create vite@latest --version

Expected:

create-vite version information

---

# 33. Create React Project

Go to your project location:

E:\Projects\Flavorista

Create frontend folder:

E:\Projects\Flavorista\frontend

Create React application:

npm create vite@latest frontend

Select:

Framework:

React

Language:

JavaScript

Move into frontend:

cd frontend

Install packages:

npm install

Start development server:

npm run dev

---

# 34. React Development Test

Successful output:

VITE running

Local:

[http://localhost:5173/](http://localhost:5173/)

Open the browser.

If the React page appears:

React setup is complete.

---

# Alternatively,
Microsoft Windows [Version 10.0.26200.8737]
(c) Microsoft Corporation. All rights reserved.

E:\flavorista> dir
 
 Directory of E:\flavorista

07/02/2026  04:35 PM    <DIR>          .
07/02/2026  12:01 AM                38 .gitattributes
07/02/2026  04:24 PM    <DIR>          .github
07/02/2026  12:01 AM               394 .gitignore
07/02/2026  04:24 PM    <DIR>          .vscode
07/02/2026  04:28 PM    <DIR>          backend
07/02/2026  04:35 PM    <DIR>          frontend
07/02/2026  04:24 PM    <DIR>          target
               2 File(s)            432 bytes
               6 Dir(s)  132,360,409,088 bytes free

E:\flavorista> npm create vite@latest frontend -- --template react
Need to install the following packages:
create-vite@9.1.1
Ok to proceed? (y) y

> npx
> create-vite frontend --template react

|
o  Which linter to use?
|  ESLint
|
o  Install with npm and start now?
|  Yes
|
o  Scaffolding project in E:\flavorista\frontend...
|
o  Installing dependencies with npm...

added 135 packages, and audited 136 packages in 2m

31 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities
|
o  Starting dev server...

> frontend@0.0.0 dev
> vite


  VITE v8.1.3  ready in 6073 ms

  ➜  Local:   http://localhost:5173/
  ➜  Network: use --host to expose
  ➜  press h + enter to show help

# Tailwind
E:\flavorista\frontend> npm list vite
frontend@0.0.0 E:\flavorista\frontend
+-- @vitejs/plugin-react@6.0.3
| `-- vite@8.1.3 deduped
`-- vite@8.1.3


E:\flavorista\frontend> npm list react
frontend@0.0.0 E:\flavorista\frontend
+-- react-dom@19.2.7
| `-- react@19.2.7 deduped
`-- react@19.2.7


E:\flavorista\frontend> java -version
openjdk version "21.0.11" 2026-04-21 LTS
OpenJDK Runtime Environment Zulu21.50+19-CA (build 21.0.11+10-LTS)
OpenJDK 64-Bit Server VM Zulu21.50+19-CA (build 21.0.11+10-LTS, mixed mode, sharing)

E:\flavorista\frontend> javac -version
javac 21.0.11

E:\flavorista\frontend> npm install tailwindcss @tailwindcss/vite

added 10 packages, and audited 146 packages in 6s

32 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities

E:\flavorista\frontend> npm run dev

> frontend@0.0.0 dev
> vite

5:10:07 PM [vite] (client) Re-optimizing dependencies because lockfile has changed

  VITE v8.1.3  ready in 4239 ms

  ➜  Local:   http://localhost:5173/
  ➜  Network: use --host to expose
  ➜  press h + enter to show help
5:11:11 PM [vite] vite.config.js changed, restarting server...
5:11:11 PM [vite] vite.config.js changed, restarting server... (x2)
5:11:12 PM [vite] server restarted.

# 35. Frontend Structure

Final frontend structure:

frontend/

├── src/

│   ├── components/

│   │   ├── Navbar.jsx

│   │   ├── Button.jsx

│   │   └── CourseCard.jsx

│   │

│   ├── pages/

│   │   ├── Login.jsx

│   │   ├── Register.jsx

│   │   ├── Dashboard.jsx

│   │   └── Courses.jsx

│   │

│   ├── services/

│   │   └── api.js

│   │

│   ├── App.jsx

│   └── main.jsx

│

├── package.json

├── package-lock.json

└── node_modules/

---

# 36. Frontend Pages

## Login Page

Purpose:

Allows existing users to access their accounts.

Contains:

* Email input
* Password input
* Login button

Flow:

User

↓

Login Form

↓

Spring Boot Login API

↓

Database Verification

↓

Dashboard

---

# Register Page

Purpose:

Creates new accounts.

Input:

* Name
* Email
* Password

Flow:

Register Form

↓

POST Request

↓

Spring Boot Controller

↓

Database Save

---

# Dashboard Page

Displays:

* User information
* Available courses
* Enrollment information

---

# Courses Page

Displays:

* Course title
* Course details
* Price
* Enrollment option

---

# 37. Connecting React With Spring Boot

Frontend:

[http://localhost:5173](http://localhost:5173)

Backend:

[http://localhost:8080](http://localhost:8080)

Communication:

React

↓

REST API

↓

Spring Boot

Example API requests:

GET:

/api/courses

POST:

/api/users/register

POST:

/api/users/login

---

# 38. API Service Layer

Frontend uses a separate service layer.

Purpose:

Keep API communication organized.

Structure:

src/

└── services/

```
└── api.js
```

Responsibilities:

* Store backend URL
* Send requests
* Receive responses

---

# 39. GitHub Workflow

GitHub is used for:

* Source control
* Version history
* Collaboration
* Deployment connection

---

# Create GitHub Repository

Steps:

1. Open GitHub

2. Select:

New Repository

3. Name:

Flavorista

4. Create repository

---

# 40. Upload Project To GitHub

Open terminal inside Flavorista folder.

Initialize Git:

git init

Add files:

git add .

Create first commit:

git commit -m "Initial Flavorista project"

Connect repository:

git remote add origin [https://github.com/yourusername/Flavorista.git](https://github.com/yourusername/Flavorista.git)

Rename branch:

git branch -M main

Push:

git push -u origin main

---

# 41. Future Git Workflow

After every update:

Check changed files:

git status

Add changes:

git add .

Create commit:

git commit -m "describe your changes"

Upload:

git push

---

# 42. GitHub Repository Structure

Final repository:

Flavorista/

├── backend/

│   ├── src/

│   ├── pom.xml

│   └── mvnw

│

├── frontend/

│   ├── src/

│   ├── package.json

│   └── node_modules/

│

├── desktop/

│

├── database/

│

├── README.md

└── setup.md

---

# 43. Render Deployment

Render provides public hosting.

Purpose:

Make Flavorista available online.

Deployment flow:

GitHub

↓

Render

↓

Build Application

↓

Public Website

---

# 44. Backend Deployment

Create Render account.

Choose:

New Web Service

Connect:

GitHub Repository

Select:

Flavorista/backend

---

# Backend Build Settings

Build Command:

./mvnw clean package

Start Command:

java -jar target/flavorista.jar

---

# Backend Deployment Result

Render creates:

Public backend URL

Example:

[https://flavorista-api.onrender.com](https://flavorista-api.onrender.com)

---

# 45. Frontend Deployment

Create:

Static Site

Connect:

frontend folder

Build command:

npm run build

Output directory:

dist

---

# Frontend Deployment Flow

React Source

↓

Production Build

↓

Render Hosting

↓

Public Website

---

# 46. Connecting Production Frontend And Backend

Development:

React:

localhost:5173

Spring Boot:

localhost:8080

Production:

React:

Render URL

↓

Spring Boot:

Render API URL

The frontend API address should point to the deployed backend.

---

# 47. Cloud Database Deployment

The application should not depend on local databases.

Old:

localhost MySQL

New:

Cloud Database

Benefits:

* Public access
* Better availability
* No local storage usage
* Multiple users supported

---

# 48. Database Options

## Supabase

Website:

[https://supabase.com/](https://supabase.com/)

Provides:

* PostgreSQL database
* Authentication options
* Cloud storage

---

## Neon

Website:

[https://neon.tech/](https://neon.tech/)

Provides:

* Serverless PostgreSQL
* Automatic scaling

---

# 49. JavaFX Desktop Future Version

The desktop version will reuse the same backend.

Architecture:

JavaFX Application

↓

HTTP Requests

↓

Spring Boot API

↓

Cloud Database

---

# 50. Scene Builder Setup

Scene Builder is used for designing JavaFX interfaces.

Download:

[https://gluonhq.com/products/scene-builder/](https://gluonhq.com/products/scene-builder/)

Install location:

E:\DevTools\SceneBuilder

Purpose:

Create:

* Windows
* Forms
* Buttons
* Layouts

---

# 51. Hydraulic Conveyor Packaging

Conveyor creates desktop installers.

Website:

[https://hydraulic.dev/](https://hydraulic.dev/)

Documentation:

[https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev)

Purpose:

Convert JavaFX project into:

* .exe installer
* Desktop application package

---

# 52. Conveyor Setup

Folder:

E:\DevTools\Conveyor

Add to Windows Path.

After configuration:

VS Code terminal can run:

conveyor commands

---

# 53. Desktop Packaging Flow

JavaFX Source Code

↓

Conveyor

↓

Windows Installer

↓

Flavorista.exe

---

# 54. Conveyor Build Command

Inside desktop project:

conveyor make windows-app

Output:

Flavorista installer file

---

# 55. Future Payment Integration

Possible future features:

* Course payments
* Subscription system
* Premium courses

---

# Stripe

Website:

[https://stripe.com/](https://stripe.com/)

Purpose:

International payment processing.

---

# Paddle

Website:

[https://www.paddle.com/](https://www.paddle.com/)

Purpose:

Merchant management and subscriptions.

---

# SSLCOMMERZ

Developer:

[https://developer.sslcommerz.com/](https://developer.sslcommerz.com/)

Purpose:

Bangladesh payment gateway integration.

---

# AmarPay

Website:

[https://amarpay.com/](https://amarpay.com/)

Purpose:

Payment processing.

---

# 56. Complete Final Project Structure

Flavorista/

│

├── backend/

│

│   ├── src/main/java/fridaytcbd/flavorista/

│   │

│   ├── FlavoristaApp.java

│   │

│   ├── controller/

│   │

│   ├── service/

│   │

│   ├── repository/

│   │

│   ├── model/

│   │

│   ├── security/

│   │

│   └── config/

│

│   ├── pom.xml

│

│

├── frontend/

│

│   ├── src/

│   │

│   ├── components/

│   │

│   ├── pages/

│   │

│   ├── services/

│   │

│   └── App.jsx

│

│

├── desktop/

│

│   ├── JavaFX Client

│   └── Conveyor Config

│

│

├── database/

│

├── README.md

│

└── setup.md

---

# 57. Final Architecture Overview

User

↓

Browser / Desktop App

↓

React / JavaFX

↓

Spring Boot Backend

↓

Controller Layer

↓

Service Layer

↓

Repository Layer

↓

JPA/Hibernate

↓

Cloud Database

---

# 58. Complete Development Roadmap

Phase 1:

Setup Environment

↓

Phase 2:

Create Backend

↓

Phase 3:

Create Database

↓

Phase 4:

Create APIs

↓

Phase 5:

Create React Frontend

↓

Phase 6:

Connect Frontend + Backend

↓

Phase 7:

GitHub Upload

↓

Phase 8:

Render Deployment

↓

Phase 9:

Desktop Application

↓

Phase 10:

Packaging With Conveyor

---

# 59. Final Product Vision

Flavorista becomes:

One Backend

*

Multiple Clients

Web Application:

React + Browser

Desktop Application:

JavaFX + .exe

Database:

Cloud Storage

#60. Links: 

Further Reading: 

[1] [https://www.jetbrains.com](https://www.jetbrains.com/help/idea/preparing-for-rest-development.html)
[2] [https://www.naukri.com](https://www.naukri.com/code360/library/spring-boot-starter-parent)
[3] [https://tomgregory.com](https://tomgregory.com/how-to-add-a-gradle-dependency)
[4] [https://medium.com](https://medium.com/maven-by-nature/introduction-to-maven-the-build-tool-that-modernized-java-development-f3c038b4d32e)
[5] [https://toolsntechniques.ca](https://toolsntechniques.ca/topic10/topic-4.html)
[6] [https://medium.com](https://medium.com/@adetutuoluwasanmi/building-a-continuous-integration-and-continuous-delivery-ci-cd-pipeline-with-github-actions-5964d43b5be1)
[7] [https://www.pixelqa.com](https://www.pixelqa.com/blog/post/deciphering-selenium-dependency-management-a-guide-to-pom-xml)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
[1] [https://foojay.io](https://foojay.io/today/learn-javafx-with-jshell-in-60-seconds/)
[2] [https://www.infoq.com](https://www.infoq.com/presentations/netflix-java/)
[3] [https://coderanch.com](https://coderanch.com/t/753670/java/JavaFx-worth-learning)
[4] [https://www.youtube.com](https://www.youtube.com/watch?v=SkquCbOLwOQ)
[5] [https://www.ssec.wisc.edu](https://www.ssec.wisc.edu/~tomw/visadtutor/index.html)
[6] [https://www.youtube.com](https://www.youtube.com/watch?v=BB0gZFpukJU)
[7] [https://www.infoworld.com](https://www.infoworld.com/article/2266032/build-a-java-application-in-visual-studio-code.html)
[8] [https://www.youtube.com](https://www.youtube.com/watch?v=YVF08E7Xd_Y)
[9] [https://sookocheff.com](https://sookocheff.com/post/java/building-a-modern-java-web-app-with-spring-boot/)
[10] [https://fusion.works](https://fusion.works/lovable-production-environment-without-rebuilding/)
[11] [https://www.codejava.net](https://www.codejava.net/java-core/how-to-write-compile-and-run-a-hello-world-java-program-for-beginners)
[12] [https://clouddevs.com](https://clouddevs.com/java/desktop-apps-with-scene-builder/)
------------------------------------------------------------------------------------------------------------------------------------------------------
[1] [https://www.youtube.com](https://www.youtube.com/watch?v=rWVaxSWvxUQ)
[2] [https://discuss.ipfs.tech](https://discuss.ipfs.tech/t/windows-ipfs-can-you-move-the-datastore-off-the-system-drive/5827)
[3] [https://github.com](https://github.com/microsoft/vscode/issues/29251)
------------------------------------------------------------------------------------------------------------------------------------------------------
[1] [https://github.com](https://github.com/orgs/sslcommerz/repositories)
[2] [https://www.pinelabs.com](https://www.pinelabs.com/blog/payment-gateway-integration-explained-api-setup-webhooks-and-error-handling-for-developers)
-------------------------------------------------------------------------------------------------------------------------------------------------------------
[1] https://conveyor.hydraulic.dev
[2] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/2/tutorial/8-explore-the-integration/)
[3] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/1.0/tutorial/8-explore-the-integration/)
[4] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/22.0/tutorial/tortoise/4-build-unpackaged/)
[5] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/3.0/tutorial/4-build-unpackaged/)
[6] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/22.0/tutorial/tortoise/3-compile/)
[7] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/8.0/)
[8] [https://conveyor.hydraulic.dev](https://conveyor.hydraulic.dev/6.0/configs/jvm/)

The same backend powers every platform.
