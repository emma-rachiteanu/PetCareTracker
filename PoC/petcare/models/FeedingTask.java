package petcare.models;

import java.time.LocalDateTime;

public class FeedingTask extends CareTask {
    public FeedingTask(String id, String petId, String title, LocalDateTime dueAt) {
        super(id, petId, title, dueAt);
    }
}
