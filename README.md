# **Pet Care Tracker - Milestone 4 Documentation**
This milestone contains the microservices implementation for the Pet Care Tracker application.
The system is split into three independent services, each running on its own port and communicating over REST.

Everything is containerized with Docker and can be tested using the included Postman collection.

## Microservices Overview

The project includes the following services:

Service	Purpose	Port
Pet Profile Service	Manages pet profiles (create, read, update, delete)	8081
Task Service	Creates and manages care tasks for pets	8082
Notification Service	Stores notifications sent by other components	8083

Each service is its own Spring Boot project with its own H2 database.

## Architecture Summary

The Pet Profile Service stores information about pets (name, species, age, schedule, medical notes).

The Task Service validates pets by calling the Pet Profile Service before creating tasks.

The Notification Service receives and stores notifications.

All services are run and orchestrated with docker-compose.

## Running the System with Docker
1. Build the JAR files

This must be done for each service:

cd pet-profile-service
mvn clean package -DskipTests

cd task-service
mvn clean package -DskipTests

cd notification-service
mvn clean package -DskipTests

2. Build Docker images

Run this command from the project root (where docker-compose.yml is located):

docker-compose build

3. Start all three services
docker-compose up


Each service will start on its assigned port:

Pet Profile: 8081

Task Service: 8082

Notification Service: 8083

## API Endpoints
### Pet Profile Service (8081)
Method	Endpoint	Description
POST	/pets	Create a new pet
GET	/pets	List all pets
GET	/pets/{id}	Get a pet by ID
PUT	/pets/{id}	Update a pet's information
DELETE	/pets/{id}	Remove a pet
### Task Service (8082)
Method	Endpoint	Description
POST	/tasks	Create a task for a pet
GET	/tasks/pet/{petId}	List tasks for a specific pet
PUT	/tasks/{id}/complete	Mark a task as completed

Before creating a task, this service checks whether the pet exists in the Pet Profile Service.

### Notification Service (8083)
Method	Endpoint	Description
POST	/notifications	Store a new notification
GET	/notifications	List all notifications
## Postman Collection

The Postman collection containing all requests used to test the system is included in the root folder:

PetCareMicroservices.postman_collection.json


It contains example requests for:

- Creating pets

- Creating tasks

- Marking tasks as completed

- Creating notifications

- Listing data from all services

## Project Structure
PetCareMicroservices/  
│  
|── pet-profile-service/  
|── task-service/  
|── notification-service/  
│  
|── docker-compose.yml  
|── PetCareMicroservices.postman_collection.json  
└── README.md  

### Notes

The project uses H2 in-memory databases, so data resets whenever services restart.

All microservices communicate through REST over a shared Docker network.

Further improvements (message queues, persistence, CI/CD) will be handled in Milestone 5.

Advantages:
Promotes code reusability and cleaner task creation logic.
Makes it easier to extend the system with new types of tasks in the future.
Centralizes task instantiation and validation logic.
