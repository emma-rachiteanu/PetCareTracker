# **Pet Care Tracker - Milestone 5 Message Queue & CI/CD**
This milestone contains the message queue (RabbitMQ) and CI/CD implementation for the Pet Care Tracker application.


## Architecture Overview

The system consists of three microservices:

- Pet Profile Service – manages pet data  
- Task Service – manages tasks and publishes task events  
- Notification Service – creates notifications based on events  

All services are containerized with Docker and orchestrated using Docker Compose.

## Message Queue Integration (RabbitMQ)

### Where RabbitMQ is used
RabbitMQ is used between the Task Service and the Notification Service.

- The Task Service publishes events when a task is created or completed.
- The Notification Service consumes these events and automatically creates notifications.
- There is no direct REST communication between these services for notifications.

### How it is integrated
- RabbitMQ runs as a single-node service defined in `docker-compose.yml`.
- A direct exchange (`petcare.exchange`) routes messages to a queue (`petcare.notification.queue`).
- Task Service acts as the producer.
- Notification Service acts as the consumer.
- Messages are sent as JSON using Jackson serialization and deserialization.

### Role in the architecture
RabbitMQ:
- Decouples services
- Enables asynchronous communication
- Prevents failures when a consumer is temporarily unavailable
- Improves scalability and fault tolerance

## CI/CD Pipeline (GitHub Actions)

### What the pipeline does
The CI pipeline automatically runs on every push to the Milestone 5 branch.

It performs the following steps:
- Sets up Java 17
- Builds each microservice using Maven
- Builds Docker images using Docker Compose

This ensures the project remains buildable and consistent across environments.

### CI/CD configuration
The pipeline is defined in the file .github/workflows/ci.yml


### How to trigger the pipeline
The pipeline runs automatically when:
- Code is pushed to the Milestone 5 branch
- A pull request is opened targeting that branch

No manual trigger is required.

### How to observe the pipeline
1. Open the GitHub repository  
2. Navigate to the Actions tab  
3. Select the CI Pipeline workflow  
4. Open a run to inspect logs for each step  

A successful run is indicated by a green checkmark.

## Testing Strategy

- Integration testing is performed manually using Postman by creating tasks and verifying that notifications are created automatically.
- Build verification testing is performed in CI:
  - Maven builds verify compilation and dependencies
  - Docker builds verify container configuration

No unit or load testing is included in this milestone.

## Project Structure

PetCareTracker/  
├── pet-profile-service/  
├── task-service/  
├── notification-service/  
├── docker-compose.yml  
├── .github/workflows/ci.yml  
└── README.md



