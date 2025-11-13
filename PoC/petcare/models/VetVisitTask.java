package petcare.models;

import java.time.LocalDateTime;

public class VetVisitTask extends CareTask {
    public VetVisitTask(String id, String petId, String title, LocalDateTime dueAt) {
        super(id, petId, title, dueAt);
    }
}
