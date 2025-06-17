# PostsApplication

A full-stack web application built with Spring Boot (Jakarta EE, Spring Data JPA) and React.

## Features

- RESTful backend using Spring Boot and JPA
- Modern frontend with React 18
- Pagination and search for posts and comments
- Modular code structure

## Prerequisites

- **Java 23** (ensure `JAVA_HOME` is set accordingly)
- **Node.js** (v16 or higher recommended) and **npm**
- An SQL-compatible database (e.g., PostgreSQL, MySQL, or H2)
- [Optional] Docker (if using containerization)

## Backend Setup (Spring Boot)

1. **Clone the Repository**
    ```sh
    git clone https://github.com/your-username/your-repo.git
    cd your-repo
    ```

2. **Update Database Configuration**
    - Edit your `application.properties` or `application.yml` under `src/main/resources` with the appropriate JDBC URL, username, and password for your database.

3. **Build the Project**
    ```sh
    ./mvnw clean install
    ```

4. **Run the Application**
    ```sh
    ./mvnw spring-boot:run
    ```
   The backend should now be running, usually at `http://localhost:8080`.

## Frontend Setup (React)

1. **Navigate to the Frontend Directory**
    ```sh
    cd frontend
    ```

2. **Install Dependencies**
    ```sh
    npm install
    ```

3. **Run the React App**
    ```sh
    npm start
    ```
   The frontend should be available at `http://localhost:3000`.

## Common Tasks

- **Building both frontend and backend for production:**  
  Refer to individual `README` files in `frontend/` or the project root for specifics.

- **Running tests:**
    - **Backend:**
      ```sh
      ./mvnw test
      ```
    - **Frontend:**
      ```sh
      npm test
      ```

## Project Structure

- `src/main/java` – Backend (Spring Boot, JPA, Jakarta EE)
- `src/main/resources` – Backend configs and resources
- `frontend/` – React app

## Troubleshooting

- **Port conflicts**: Ensure that ports 8080 (backend) and 3000 (frontend) are available.
- **Database connection errors**: Double-check your DB settings in `application.properties`.
- **Build errors**: Ensure you are using correct versions of Java and Node.

## License

This project is open source and available under the MIT license.

---

For further information, please see in-code documentation or open an issue.
