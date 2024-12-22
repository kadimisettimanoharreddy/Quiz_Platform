Quiz Application
This is a Java-based quiz application that uses JDBC to interact with a MySQL database. It allows administrators to manage quiz questions and users to participate in interactive quizzes.
Features
Admin Panel:
Create a table for storing quiz questions.
Add, update, and delete quiz questions.
User Mode:
Attempt quizzes with multiple-choice questions.
View your score instantly after completing the quiz.
How to Use
Run the application and choose:
Admin mode to manage quiz questions.
User mode to take a quiz.
Follow the on-screen instructions to perform your desired actions.

Project Structure
ConductQuiz.java: Handles quiz execution and scoring logic.
DataBaseManager.java: Performs database operations like adding, updating, and deleting quiz questions.
Exam.java: Entry point for the application.
Jdbc.java: Manages database connectivity.
Note
Ensure the database and required table are set up before running the application.
