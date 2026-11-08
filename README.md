
# Java Login System

## Project Description

The Java Login System is a desktop application developed using Java Swing and MySQL. It allows users with existing accounts in the database to log in securely.

The system validates user credentials against records stored in a MySQL database. If the credentials are correct, the user is redirected to a Dashboard displaying a successful login message. Users with invalid credentials or accounts that do not exist are denied access.

This project was developed as part of a Java programming assignment to demonstrate the use of graphical user interfaces, database connectivity, and authentication.

## Technologies Used

- **Programming Language:** Java (JDK 17)
- **GUI Framework:** Java Swing
- **Database:** MySQL 8.4
- **Database Connectivity:** JDBC
- **Database Driver:** MySQL Connector/J
- **Code Editor:** Visual Studio Code

## Project Features

- User-friendly graphical login interface.
- Username and password input fields.
- MySQL database connectivity using JDBC.
- Authentication of existing user accounts.
- Secure password hashing using PBKDF2WithHmacSHA256.
- Rejection of invalid login credentials.
- Dashboard displayed after successful authentication.
- Input validation for empty fields.

## Project Structure

```text
JavaLoginSystem/
│
├── lib/
│   └── mysql-connector-j.jar
│
├── src/
│   └── Swing/
│       ├── Login.java
│       ├── DBConnection.java
│       ├── Authentication.java
│       ├── PasswordUtil.java
│       ├── Dashboard.java
│       └── CreateTestUser.java
│
├── .vscode/
│   └── settings.json
│
└── README.md
```

## Database Configuration

The application uses a MySQL database named `java_login_db`.

### Database Table

The database contains a table called `users` with the following columns:

| Column | Data Type | Description |
|---|---|---|
| user_id | INT | Unique user identifier |
| username | VARCHAR(50) | User's login username |
| password_hash | VARCHAR(255) | Hashed user password |

### Creating the Database

Execute the following SQL commands in MySQL:

```sql
CREATE DATABASE java_login_db;

USE java_login_db;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL
);
```

### Database Connection

The `DBConnection.java` class establishes a connection between the Java application and MySQL using JDBC.

Connection details:

- Host: localhost
- Port: 3306
- Database: java_login_db
- Username: login_app

Configure the database password in `DBConnection.java` before running the application.

## How to Run the Project

1. Install JDK 17.
2. Install MySQL Server.
3. Download MySQL Connector/J.
4. Place the Connector/J JAR file inside the `lib` directory.
5. Configure the JDBC library in VS Code.
6. Create the `java_login_db` database and `users` table.
7. Configure the MySQL application account and connection credentials.
8. Run `CreateTestUser.java` to create a test account.
9. Run `Login.java` to launch the application.

## Application Workflow

1. The user launches the login application.
2. The user enters their username and password.
3. The application sends the username to MySQL to retrieve the corresponding password hash.
4. Java verifies the entered password against the stored hash.
5. If authentication succeeds, the Dashboard opens.
6. If authentication fails, an error message is displayed and access is denied.

## Testing

The application should be tested using the following scenarios:

| Test Case | Expected Result |
|---|---|
| Correct username and password | Login successful |
| Correct username and incorrect password | Access denied |
| Non-existent username | Access denied |
| Empty username and password | Validation message displayed |

## Security

- Passwords are stored as hashes rather than plain text.
- PreparedStatement is used to execute parameterized SQL queries.
- Database access is handled through JDBC.
- Database credentials should not be committed to public repositories.

## Author

Developed as part of a Java Programming course assignment.

## Conclusion

The Java Login System demonstrates how Java Swing can be integrated with a MySQL database to develop a desktop authentication application. It combines graphical user interface development, JDBC connectivity, SQL queries, and password verification.
