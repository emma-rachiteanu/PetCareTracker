package petcare.models;

import java.time.LocalDateTime;

public abstract class CareTask {
    private final String id;
    private final String petId;
    private String title;
    private LocalDateTime dueAt;
    private boolean completed;

    public CareTask(String id, String petId, String title, LocalDateTime dueAt) {
        this.id = id;
        this.petId = petId;
        this.title = title;
        this.dueAt = dueAt;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public String getPetId() {
        return petId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueAt() {
        return dueAt;
    }

    public void setDueAt(LocalDateTime dueAt) {
        this.dueAt = dueAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isDue(LocalDateTime now) {
        return !completed && !dueAt.isAfter(now);
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "CareTask{" +
                "id='" + id + '\'' +
                ", petId='" + petId + '\'' +
                ", title='" + title + '\'' +
                ", dueAt=" + dueAt +
                ", completed=" + completed +
                '}';
    }
}
