# **Pet Care Tracker**
This repository contains the submission for the Software Design and Technology (SDT) project. Each milestone will be marked as a different branch.
## *Team Members*
Bilciurescu Gabriel - Cosmin<br>
Iubitu Mara - Alexandra<br>
Răchițeanu Emma


## *Project Overview*
The Pet Care Tracker is a smart and user-friendly application that helps pet owners manage their pets’ health and daily care routines. It provides automated reminders for feeding times, vet visits, vaccinations, and medications, ensuring that each pet receives consistent attention and proper care.

Many owners, including us, have multiple pets with different needs, which can make it hard to keep track of every task. This project aims to centralize all pet-related information into one accessible platform, offering real-time notifications, scheduling tools, and historical records.

## *Project Goals*
The main objectives of the Pet Care Tracker are to:
- Help pet owners stay organized and never miss important care tasks.
- Maintain complete and accessible records for each pet (feeding, vaccination, vet visits).
- Automate recurring tasks through scheduling and smart reminders.
- Build a scalable and modular architecture that can be extended easily in later milestones.
  

## *Core Functionalities*
- Pet Profile Management  
Create, edit, and store detailed profiles for each pet, including name, breed, age, feeding schedule, and medical information.
- Feeding & Medication Reminders  
Schedule feeding times, medication doses, or supplements. Receive timely alerts and track completed actions.
- Vet Visit Tracking  
Keep a log of past appointments and schedule future visits, complete with notes and reminders.
- Vaccination Log  
Record vaccinations, track due dates, and receive automatic notifications for upcoming vaccines.
- Task Overview Dashboard  
View upcoming and completed care tasks in a clean, organized dashboard for easy monitoring.

## *Design Patterns Used*

1. Observer Pattern — Notifications and Updates

Problem solved: The application must notify users whenever a scheduled task (feeding, vet visit, vaccination) is due, or when a pet profile is updated.
Justification:
The Observer pattern allows the app to automatically notify multiple components (e.g., reminder service, UI alerts, mobile notifications) whenever a pet’s schedule changes—without tightly coupling these components.
Advantages:
Enables real-time updates.
Improves extensibility: new types of notifications (email, SMS) can be added easily.
Decouples task scheduling from notification delivery.

2. Command Pattern — Scheduling and Task Management

Problem solved: The system needs to execute and manage actions such as “Add feeding reminder” or “Reschedule vaccination” consistently, with options to undo or modify them.
Justification:
The Command pattern encapsulates each operation (e.g., “add reminder,” “mark task completed”) as an object. This makes it easier to queue, log, or undo user actions and ensures a consistent interface for executing scheduled operations.

Advantages:
Allows task undo/redo support.
Simplifies scheduling logic by decoupling UI from task execution.
Facilitates command history and batch execution.

3. Singleton Pattern — Pet Profile Manager

Problem solved: Pet data must be accessed consistently across multiple components (notification system, calendar, statistics).
Justification:
The Singleton pattern ensures that there is only one instance of the PetProfileManager, providing a central source of truth for all pet-related data.

Advantages:
Guarantees consistent access to shared data.
Reduces redundant object creation.
Simplifies synchronization between modules.

4. Factory Pattern — Care Task Creation

Problem solved: Different care activities (feeding, vet visits, vaccinations) share common structure but differ in behavior.
Justification:
The Factory pattern enables dynamic creation of care task objects based on type (e.g., FeedingTask, VetVisitTask, VaccinationTask) without changing the client code.

Advantages:
Promotes code reusability and cleaner task creation logic.
Makes it easier to extend the system with new types of tasks in the future.
Centralizes task instantiation and validation logic.
