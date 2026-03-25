# 🧑‍💻 Online Examination System (Java + JDBC + MySQL)

## 📌 Project Overview

This is a console-based **Online Examination System** developed using **Core Java, JDBC, and MySQL**.
The system allows an **Admin** to manage questions and **Students** to take exams dynamically.

---

## 🚀 Features

### 👨‍💼 Admin

* Add new questions dynamically
* Delete existing questions
* View question list

### 🎓 Student

* Enter personal details (Name, Phone, Age)
* Take exam (MCQ-based)
* Get instant score
* Result stored in database

---

## 🛠 Technologies Used

* Java (Core Java)
* JDBC (Java Database Connectivity)
* MySQL Database
* Eclipse IDE

---

## 🗂 Project Structure

src/
├── com.exam.main
├── com.exam.dao
├── com.exam.model
├── com.exam.util

---

## ⚙️ Database Setup

```sql
CREATE DATABASE online_exam;

USE online_exam;

CREATE TABLE questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255),
    optionA VARCHAR(100),
    optionB VARCHAR(100),
    optionC VARCHAR(100),
    optionD VARCHAR(100),
    correct_answer CHAR(1)
);

CREATE TABLE results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(15),
    age INT,
    score INT
);
```

---

## ▶️ How to Run

1. Clone the repository
2. Open in Eclipse
3. Add MySQL Connector JAR
4. Configure DB username & password
5. Run `Main.java`

---

## 🎯 Key Concepts Covered

* JDBC Connectivity
* DAO Design Pattern
* CRUD Operations
* Dynamic Data Handling
* Role-based System (Admin/Student)

---

## 📌 Future Enhancements

* Admin Login System
* GUI (Java Swing/JavaFX)
* Web Version (Spring Boot)

---

## 🙌 Author

Developed by *Ananya* ✨
