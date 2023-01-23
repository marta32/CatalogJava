# School Catalog - Java Project

This project is a Java Console Application for managing a school catalog. It allows creating, reading, updating, and deleting four types of entities - students, teachers, subjects, and grades.

Three types of repositories have been implemented for this project. More precisely, we have repositories in memory, in file, and database for each entity, and these implementations can be interchanged with each other. 

Additionally, the application handles the edge cases such as invalid date, invalid grade, etc. The data integrity and consistency are ensured by custom exceptions and validator classes.

## Tech stack
- Java 11
- Maven 
- PostgreSQL for the relational database

## Other tools
- Postman 
- DBeaver 
- Git

## User interaction

Users can interact with the application through the menu displayed in the console. Besides the CRUD operations, they can also search for the top three students (based on their grades) and for the students born in the summer.


![Screenshot](https://github.com/marta32/CatalogJava/blob/main/images/Menu.png)
