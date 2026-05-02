# Patient Management System
## A microservices-based demo application for managing patient data, billing, and analytics, built with Java Spring Boot 3.

### Architecture
This project follows a microservices pattern, utilizing gRPC and REST for communication.

  api-gateway: The entry point for all client requests.
  auth-service: Handles user authentication and authorization.
  patient-service: Manages core patient records and profiles.
  billing-service: Handles invoicing and financial transactions.
  analytics-service: Processes data for reporting and insights.
  infrastructure: Contains configuration for shared resources (e.g., databases, message brokers).

### Tech Stack

  Backend: Java 21, Spring Boot 3.x
  Communication: REST API, gRPC
  Containerization: Docker, Docker Compose
  Testing: Integration tests included in integration-tests module

### Getting Started
Prerequisites

  JDK 21 or higher
  Maven 3.9+
  Docker & Docker Compose

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com
   cd patient-management
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run with Docker:
   ```bash
   docker-compose up -d
   ```
   
Testing
  Run the full suite of integration tests:
    ```bash
    mvn test -pl integration-tests
    ```
