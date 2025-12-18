# **Pet Care Tracker - Milestone 5 Message Queue & CI/CD**
This milestone contains the message queue (RabbitMQ) and CI/CD implementation for the Pet Care Tracker application.

### RabbitMQ Integration
The Task Service publishes task-related events (creation and completion) to a RabbitMQ exchange.
The Notification Service consumes these events asynchronously and automatically creates notification records.
This design decouples the services and improves scalability and fault tolerance.

### CI/CD Pipeline
The project includes a GitHub Actions CI pipeline that automatically builds all microservices
and Docker images on every push. This ensures that the system remains buildable and consistent
across environments.
