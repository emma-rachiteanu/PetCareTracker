package petcare.factory;

import petcare.models.*;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

public class TaskFactory {

    public CareTask createTask(String type,
                               String petId,
                               String title,
                               LocalDateTime dueAt) {

        String id = UUID.randomUUID().toString();
        String normalized = type.toLowerCase(Locale.ROOT);

        switch (normalized) {
            case "feeding":
                return new FeedingTask(id, petId, title, dueAt);
            case "vet":
            case "vetvisit":
            case "vet_visit":
                return new VetVisitTask(id, petId, title, dueAt);
            case "vaccination":
            case "vaccine":
                return new VaccinationTask(id, petId, title, dueAt);
            default:
                // fallback generic
                return new FeedingTask(id, petId, title, dueAt);
        }
    }
}
