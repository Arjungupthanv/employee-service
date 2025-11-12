# Employee Service

A Spring Boot REST API for managing employees.

## Technologies
- Java 17  
- Spring Boot 3.3.3  
- MySQL 8  
- Maven  
- Postman (for testing)

## Run locally
1. Clone repo: `git clone https://github.com/<your-username>/employee-service.git`
2. Configure MySQL in `src/main/resources/application.properties`
3. Run: `mvn spring-boot:run`
4. Test: `http://localhost:8080/api/v1/employees`

## Example Endpoints
- `POST /api/v1/employees` → Add new employee  
- `GET /api/v1/employees/{id}` → Get employee by ID  
- `PUT /api/v1/employees/{id}` → Update employee  
- `DELETE /api/v1/employees/{id}` → Delete employee
