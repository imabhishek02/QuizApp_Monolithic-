# 🧠 Quiz App Backend (Monolithic)

A fully functional backend for a Quiz Application built using **Java**, **Spring Boot**, and **PostgreSQL**. This monolithic system handles everything from question creation to quiz generation and result evaluation based on user responses.

## 🔧 Tech Stack

- **Language:** Java  
- **Framework:** Spring Boot  
- **Database:** PostgreSQL / H2 (switchable)  
- **Build Tool:** Maven  
- **Architecture:** Layered (Controller → Service → Repository)

## ✅ Features

### 📋 Question Management
- Create questions under specific categories
- Retrieve questions by category
- Store multiple-choice questions with options and correct answer

### 🧪 Quiz Management
- Generate quizzes dynamically from selected category and question count
- Fetch quiz questions by quiz ID
- Evaluate user responses and calculate results

### 📊 Result Processing
- Accept user answers via quiz submission
- Calculate and return score based on correct answers

## 📂 Project Structure

- `controller/` → REST endpoints  
- `service/` → Business logic  
- `repository/` → Data access layer (Spring Data JPA)  
- `entity/` → JPA Entities (Question, Quiz, Response)  
- `dto/` → Data Transfer Objects  
- `exception/` → Centralized exception handling  

## 📌 Future Enhancements

- Add Spring Security (JWT, role-based access)  
- API documentation using Swagger/OpenAPI  
- Dockerize the application  
- Frontend with Angular/React  
- Convert into Microservices architecture:
  - Question Service  
  - Quiz Service  
  - Result Service  
  - API Gateway + Eureka  

## 🚀 How to Run
 - Clone the repo  
 - Set up PostgreSQL and update application.properties  
 - Run the project using your IDE or mvn spring-boot:run  
 - Test APIs with Postman or Swagger
