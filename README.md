# Arithmetic Bubbles - Backend System

This project contains the backend code of the [Arithmetic Bubbles](https://globalgamejam.org/games/2025/arithmetic-bubbles-5) game that was implemented in the context of the [Global Game Jam 2025 in Athens](https://globalgamejam.org/jam-sites/2025/global-game-jam-athens).

The game is designed for children in the first grades of primary school to practice arithmetic operations. Each exercise is a quiz, where avatars present possible answers in bubbles. The game interacts with a backend server that verifies the accuracy of the answers and generates new exercises. Currently, the exercises are generated randomly. However, we plan to introduce algorithms in the future to assess each student's knowledge level and provide personalized exercises.

It is implemented in Spring Boot and requires Java 17 and MySQL or MariaDB. The database is located in the file various/arithmetic_bubbles.sql. One can set the access details of the database in the application.properties file.

The frontend is implemented in Godot 4 and the source code is located at https://github.com/spyros-papadimitriou/arithmetic-bubbles-front.