# Pet Care Tracker – Milestone 3 Documentation
The Pet Care Tracker application is designed to support pet owners in managing recurring and non-recurring care activities for their pets. The system organizes pet profiles, scheduled tasks, due-date notifications, and administrative functions. This milestone investigates three distinct software architectures for the Pet Care Tracker system:  
1. Monolithic Architecture  
2. Microservices Architecture  
3. Event-Driven Architecture  

For each architecture, the overall structure, deployment approach, benefits, and drawbacks are examined.  
All required diagrams (component and deployment diagrams for all three architectures) are included in the project repository.

## 1. Monolithic Architecture
### 1.1 Description
The monolithic architecture organizes the entire system as a single application in which all features—such as pet profile management, task scheduling, and notifications—run within one codebase and one process. All components share a single database. Interactions between modules occur through in-process method calls, and deployment typically involves running the entire backend on a single server instance.

### 1.2 Reasoning & Architectural Characteristics
The monolithic model provides a simple structure suitable for early-stage development. It centralizes application logic, enabling rapid development and straightforward debugging. Because all modules reside together, there is no network communication overhead or distributed coordination.

This architecture is easy to deploy, as changes require rebuilding and redeploying only one artifact. It does, however, impose tight coupling between components and does not scale well as usage or feature count increases.

A component diagram and deployment diagram for the monolith are provided in the repository.

### 1.3 Advantages
- Simplified development, debugging, and testing.
- Straightforward deployment and minimal infrastructure requirements.
- No inter-service networking, resulting in lower runtime overhead.
- Appropriate for early prototyping and small-scale systems.

### 1.4 Disadvantages
- Limited scalability: the entire application must scale as a whole.
- Reduced maintainability as the codebase grows.
- Updating one feature requires redeploying the entire system.
- Tight coupling leads to slower long-term development.
- A single failure can bring down the whole system.

## 2. Microservices Architecture
### 2.1 Description
The microservices architecture decomposes the system into independently deployable services, each responsible for a specific domain. Services communicate using REST APIs, usually through an API Gateway that routes client requests. Each service owns its own data store, aligning with the Database-Per-Service pattern.

This distribution supports modular design, independent scaling, and isolated error handling. Services can be developed and deployed independently, improving maintainability and resilience.

### 2.2 Reasoning & Architectural Characteristics
In the Pet Care Tracker, microservices naturally align with the separation of concerns between core domains (e.g., profiles, tasks, notifications). Each service encapsulates its business logic, making the system more flexible as the application grows.

The independent deployment units increase agility: individual services can evolve without affecting others. The tradeoff is the added complexity of distributed communication, containerization, and coordination across services.

Associated component and deployment diagrams are provided in the repository.

### 2.3 Advantages
- Independent deployment and scaling of services.
- Increased resilience: failures are isolated to individual services.
- Clear separation of concerns and well-defined service boundaries.
- Improved maintainability for larger and evolving systems.
- Better match for modern DevOps practices.

### 2.4 Disadvantages
- Requires managing distributed systems concerns.
- More complex deployment and infrastructure (API Gateway, containers, etc.).
- Increased operational overhead for monitoring and logging.
- Harder to debug interactions across multiple services.
- Additional latency due to network communication.

## 3. Event-Driven Architecture
### 3.1 Description
The event-driven architecture builds on the microservices approach by introducing asynchronous communication through a message broker (Event Bus). Services publish events when their internal state changes and subscribe to events produced by other services. This model enables real-time, loosely-coupled behavior.

Interaction between services no longer depends on synchronous REST calls. Instead, events act as triggers for further processing, such as issuing reminders, updating dashboards, or performing background calculations.

### 3.2 Reasoning & Architectural Characteristics
For the Pet Care Tracker, task reminders, due-date monitoring, and user notifications are highly suitable for event-driven workflows. Asynchronous communication allows these operations to scale without blocking other services.

The event-driven architecture decouples domain logic and supports extension by adding new event consumers. However, the increased complexity of asynchronous processing, infrastructure management, and debugging must be considered.

Event-driven component and deployment diagrams are included in the repository.

### 3.3 Advantages
- Very high scalability and responsiveness under load.
- Asynchronous communication improves overall system performance.
- Strong decoupling between services enables more flexible evolution.
- Ideal for notification workflows and background task processing.
- New behaviors can be added by subscribing to existing events.

### 3.4 Disadvantages
- Highest complexity of all three architectures.
- Requires message queue infrastructure and observability tools.
- Event-based debugging is more challenging.
- Requires careful handling of eventual consistency.
- Potential for variable latency depending on processing load.

## Summary

| Architecture  | Scalability | Complexity | Coupling  | Suitability for Notifications | Deployment Difficulty |
|---------------|-------------|------------|-----------|-------------------------------|------------------------|
| Monolithic    | Low         | Low        | High      | Moderate                      | Low                    |
| Microservices | High        | Moderate   | Low       | High                          | Moderate               |
| Event-Driven  | Very High   | High       | Very Low  | Excellent                     | High                   |

### Final Decision: Microservices Architecture

The microservices architecture is selected as the most suitable solution for the Pet Care Tracker. It offers the optimal balance between maintainability, modularity, scalability, and implementation complexity.

This architecture supports independent evolution of system domains, aligns with upcoming milestones requiring containerization and REST-based service integration, and provides a strong basis for introducing event-driven features in later phases.

While the event-driven architecture excels at scalability and asynchronous processing, it introduces substantial infrastructure and debugging complexity that is unjustified at the current stage. The monolithic architecture, although simple, does not support the long-term scalability and maintainability required by the system’s growth.

Microservices therefore provide the best architectural foundation for subsequent development.

---

All diagrams referenced in this document (component and deployment diagrams for all three architectures) are included in the repository.
