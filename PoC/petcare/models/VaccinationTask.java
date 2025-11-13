package petcare.models;

import java.time.LocalDateTime;

public class VaccinationTask extends CareTask {
    public VaccinationTask(String id, String petId, String title, LocalDateTime dueAt) {
        super(id, petId, title, dueAt);
    }
}
