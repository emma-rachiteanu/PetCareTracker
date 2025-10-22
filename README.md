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
- **Observer:** Handles notifications when tasks are created, modified, or completed. Enables automatic reminders without tightly coupling modules.
- **Command:** Manages user actions such as scheduling, updating, or cancelling reminders, allowing undo and consistent execution.
- **Singleton:** Maintains a single shared instance of the pet profile manager, ensuring data consistency across all components.
- **Factory:** Generates different types of care tasks (feeding, vaccination, vet visit) dynamically, simplifying object creation and system extensibility.
