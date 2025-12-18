# **Pet Care Tracker - Milestone 5 Message Queue & CI/CD**
This milestone contains the message queue (RabbitMQ) and CI/CD implementation for the Pet Care Tracker application.

### RabbitMQ Integration
The Task Service publishes task-related events (creation and completion) to a RabbitMQ exchange.
The Notification Service consumes these events asynchronously and automatically creates notification records.
This design decouples the services and improves scalability and fault tolerance.

### CI/CD Pipeline
The project uses GitHub Actions for continuous integration and deployment.
On each push to the milestone branch, the pipeline:
- Builds all microservices using Maven
- Builds Docker images for all services
- Starts the services using Docker Compose in a local Docker environment

The pipeline execution can be observed in the GitHub Actions tab of the repository.
