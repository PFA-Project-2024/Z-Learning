# ZLearning: A Modern Online Learning Platform

![logo](https://github.com/PFA-Project-2024/Z-Learning/assets/121774474/d1ac8223-df37-4376-afaa-20eb6938cf70)

This project is all about creating a virtual school where you can take certification courses online and access resources easily. We're making an online learning platform with courses in different subjects like IT, business management, and data science. What's cool about our platform is that you can get all the learning stuff like courses, videos, and documents directly online without having to download anything. This makes learning easier and more flexible for everyone.

## Table of Contents

- [Overview](#overview)
- [Software Architecture](#software-architecture)
- [Frontend Infrastructure](#frontend-infrastructure)
- [Backend Infrastructure](#backend-infrastructure)
- [Getting Started](#getting-started)
- [Folder Structure](#folder-structure)
- [Video Demonstration](#video-demonstration)
- [Contributing](#contributing)

## Overview

ZLearning is on a mission to revolutionize blended learning with a user-friendly platform that prioritizes efficiency and empowerment. Our goal is to create an environment where both teachers and students can thrive, taking into account their individual constraints and preferences.

Our platform is designed to streamline scheduling and planning, optimizing resource allocation while enhancing student engagement through adaptable learning schedules. For educators, ZLearning provides intuitive tools to input their constraints and teaching modes, while administrators benefit from real-time updates and data-driven insights.

At the heart of our project is the aim to improve learning outcomes by making blended learning more organized, accessible, and effective than ever before. Join us as we transform the educational landscape with ZLearning.

## Software Architecture

The software architecture of Z-Learning is designed with a decoupled approach, utilizing React for the frontend and Spring Boot for the backend. This architecture ensures efficient communication, scalability, and maintainability of the platform.

### Backend Infrastructure

- **Spring Boot:** Serves as the foundation of our backend infrastructure, providing a robust framework for handling HTTP requests and responses, along with managing database interactions.
- **Controllers:** Dedicated controllers such as `AdminDashBoardController`, `UserController`, and `CourseController` are responsible for handling incoming HTTP requests, processing data, and returning appropriate responses.
- **Repositories:** Repositories, such as `StudentRepository` and `CourseRepository`, interact with MongoDB to perform data persistence operations, including CRUD operations and query executions.
- **Services:** Backend services, such as `StudentService`, `CourseService`, and `CategoryService`, provide a layer of abstraction between the controllers and repositories, promoting code reusability and maintainability.

## Frontend Infrastructure

The React frontend project is organized around five pages: `AdminPage`, `CoursesPage`, `HomePage`, `LoginPage`, `RegisterPage`, and `SessionsPage`, each serving a specific purpose and contributing to the overall architecture and maintainability of the application.

### AdminPage

**Purpose:** This page is typically for administrators who manage the application. It might include features like user management, course management, session management, and other administrative tasks.

**Key Components:**
- **User Management:** List of users, add/edit/delete users.
- **Course Management:** List of courses, add/edit/delete courses.
- **Session Management:** List of sessions, add/edit/delete sessions.
- **Reports and Analytics:** Dashboard for viewing various reports and analytics.

### RegisterPage

**Purpose:** This page allows new users to sign up for an account.

**Key Components:**
- **Registration Form:** Fields for user details like name, email, password, etc.
- **Validation:** Form validation to ensure correct data entry.
- **Submission:** Handle form submission and provide feedback (e.g., success or error messages).

### LoginPage

**Purpose:** This page is for existing users to log into their accounts.

**Key Components:**
- **Login Form:** Fields for email/username and password.
- **Authentication:** Handle authentication logic and user sessions.
- **Feedback:** Provide feedback for incorrect login details.
- **Forgot Password:** Link or option to reset password.

### CoursesPage

**Purpose:** This page displays a list of available courses for users.

**Key Components:**
- **Course List:** Display a list of courses with details like title, description, instructor, etc.
- **Search/Filter:** Options to search and filter courses based on various criteria.
- **Course Details:** Link to a detailed view of each course.
- **Enrollment:** Option to enroll in a course.

### SessionsPage

**Purpose:** This page manages user sessions, which might include both course sessions and personal user sessions.

**Key Components:**
- **Session List:** Display a list of current and upcoming sessions.
- **Session Details:** Detailed view of each session.
- **Attendance:** Mark attendance or view attendance records.
- **Feedback:** Option to provide feedback for sessions.

## Backend Infrastructure

The backend code follows a modular and organized structure, leveraging the power of Spring Boot for building a robust and scalable application.

1. **com.example.application**
   - **Main Application Class:** `Application.java` serves as the entry point for the Spring Boot application. It includes the main method to start the application.
2. **com.example.controller**
   - **Controller Classes:** The `controller` package contains classes responsible for handling incoming HTTP requests. Each controller class is dedicated to a specific feature or entity, exposing RESTful endpoints. These classes interact with the services to process requests and return appropriate responses.
3. **com.example.service**
   - **Service Classes:** The `service` package hosts classes that encapsulate business logic. These classes are used by controllers to perform operations on data and communicate with repositories. They provide a layer of abstraction between controllers and repositories.
4. **com.example.model**
   - **Entity Classes:** The `model` package includes classes representing data entities in the application. These classes are annotated with JPA annotations, defining the structure of the database tables. Each entity typically corresponds to a table in the MySQL database.
5. **com.example.repository**
   - **Repository Interfaces:** The `repository` package contains interfaces that extend Spring Data JPA repositories. These interfaces provide methods for basic CRUD operations and are used by services to interact with the database.

## Getting Started

Certainly! Here are step-by-step instructions to set up and run your project locally:

### Prerequisites

- **Git:** Make sure you have Git installed. If not, download and install it from [git-scm.com](https://git-scm.com/).
- **Docker:** Make sure you have Git installed.If not, download and install it from [git-scm.com](https://git-scm.com/).
- **Node Version Manager (NVM):** Install NVM from [github.com/nvm-sh/nvm](https://github.com/nvm-sh/nvm). Use NVM to install Node.js version 14.11.0: `nvm install 14.11.0`.

### Backend Setup

1. **Clone the Project:**
   ```bash
   git clone <repository_url>
   cd <project_folder>
