# Pet Care Tracker – Milestone 2 Documentation

The Pet Care Tracker application is designed to support pet owners in managing recurring and non-recurring care activities for their pets. The system organizes pet profiles, scheduled tasks, due-date notifications, and administrative functions. This milestone focuses on producing a modular and extensible object-oriented design supported by multiple design patterns. The included UML diagrams and proof-of-concept (POC) implementation demonstrate how these patterns integrate into a coherent architecture.

## High-Level Architecture

The system employs four primary design patterns:

* **Singleton** for centralized profile management
* **Factory** for dynamic task creation
* **Command** for encapsulating user actions
* **Observer** for multi-channel notifications

These patterns are combined to create a structure that is maintainable, extensible, and consistent with best practices for event-driven systems. The architecture separates responsibilities clearly: user interfaces request actions, commands encapsulate them, the scheduler executes them, and observers react to system events.

## Class Diagram Overview

The Class Diagram models the static structure of the Pet Care Tracker system. It includes the domain entities (pets, users, tasks), the design pattern components (commands, factory, singleton), and the observer system. The diagram shows inheritance, composition, and dependencies between classes.

### Short Summary of the Class Diagram

* **Domain model:** `PetProfile`, `CareTask` and its three concrete subclasses represent the primary data structures.
* **Users:** `User` and `Admin` classes model two roles in the system.
* **Singleton:** `PetProfileManager` ensures one centralized store for pet data.
* **Factory:** `TaskFactory` creates the correct task type based on input.
* **Command system:** Task-related actions are expressed as command objects executed by `TaskScheduler`.
* **Observer system:** `NotificationService` manages observers, and concrete notifiers react to due tasks.
* **Relationships:** Multiplicity and associations reflect the logical ownership between users, pets, and tasks.

This diagram establishes the structural foundation for the sequence diagrams and the POC.

## Sequence Diagrams

### Sequence Diagram: Adding a Task

This diagram models how the system responds when a user adds a new care task via the user interface. The AppUI constructs the task using the TaskFactory, wraps it inside an `AddTaskCommand`, and passes it to the `TaskScheduler`. The scheduler executes the command, adding the task to the appropriate `PetProfile` through `PetProfileManager`. The UI then displays a confirmation.

* **Short Summary:** Demonstrates interaction of Factory, Command, and Singleton patterns during task creation.

### Sequence Diagram: Task Notification

This diagram shows how the system detects and notifies users when a scheduled task becomes due. The scheduler periodically checks for due tasks using `tick()`. For each due task, it triggers `NotificationService.notifyObservers()`, which notifies all registered observers: the UI, mobile notifier, and email notifier.

* **Short Summary:** Demonstrates the Observer pattern, showing how due tasks propagate to multiple notification channels.

## Design Pattern Details

### 1. Singleton Pattern: PetProfileManager

* Maintains a single instance for storing and retrieving all pet profiles.
* Ensures consistency across UI components, commands, and scheduler tasks.
* Centralizes data access to prevent duplication.

### 2. Factory Pattern: TaskFactory

* Centralizes creation of `CareTask` subclasses.
* Avoids scattered conditional logic.
* Supports easy addition of new task types.

### 3. Command Pattern: TaskCommand and Concrete Commands

* Represents user actions (add, reschedule, complete tasks) as command objects.
* Each command contains all data needed to execute/undo the operation.
* `TaskScheduler` acts as the invoker.

### 4. Observer Pattern: NotificationService and Observers

* Maintains a collection of observers.
* Notifies observers via `update()` when tasks become due.
* Includes UI, mobile, and email notification implementations.

## Proof of Concept (POC) Implementation

The provided Java POC demonstrates the interaction between components:

* Users and admin accounts are created.
* A pet profile is added to the system.
* A new task is added via the UI, triggering Factory and Command patterns.
* The scheduler registers and later executes due-task notifications.
* The Observer system alerts all channels.
* The user can view their tasks in the console.
