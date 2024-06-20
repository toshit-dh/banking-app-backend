# Banking App Backend

This is a Spring Boot application for a basic banking system backend. It allows creating accounts, retrieving account details, depositing funds, and withdrawing funds.

## Setup

### Prerequisites
- Java 11 or higher installed
- MySQL installed and running
- Git installed
- Maven or Gradle (depending on your build system preference)

### Steps to Initialize the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/toshit-dh/banking-app-backend.git
   cd banking-app-backend
   ```

2. Configure MySQL Database:
   - Create a MySQL database named `banking_app`.
   - Update the database connection settings in `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/banking_app
     spring.datasource.username=<your_username>
     spring.datasource.password=<your_password>
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build and Run the Application:
   - Using Maven:
     ```bash
     mvn spring-boot:run
     ```
   - Or using Gradle:
     ```bash
     gradle bootRun
     ```

4. The application should now be running on `http://localhost:8080`.

## API Endpoints

### Create an Account
- **Endpoint**: `POST /accounts`
- **Request Body**:
  ```json
  {
    "name": "John Doe",
    "balance": 1000.0
  }
  ```
- **Description**: Creates a new bank account with the provided name and initial balance.

### Get an Account
- **Endpoint**: `GET /accounts/{id}`
- **Description**: Retrieves the account details for the specified account ID.

### Deposit Funds
- **Endpoint**: `PUT /accounts/deposit/id`
- **Request Body**:
  ```json
  {
    "amount": 500.0
  }
  ```
- **Description**: Deposits the specified amount into the account identified by `{id}`.

### Withdraw Funds
- **Endpoint**: `PUT accounts/withdraw/id`
- **Request Body**:
  ```json
  {
    "amount": 200.0
  }
  ```
- **Description**: Withdraws the specified amount from the account identified by `{id}`.

## Dependencies Used
- Spring Web
- Lombok
- Spring Data JPA
- MySQL Driver

---

Adjust the details (like database credentials, endpoints, and specifics of account handling) according to your project's requirements. This README provides a foundational guide for users and contributors to understand and use your Spring Boot backend for the banking application.
