package petcare.command;

import petcare.models.CareTask;

import java.time.LocalDateTime;

public class RescheduleCommand implements TaskCommand {

    private final CareTask task;
    private final LocalDateTime newTime;
    private LocalDateTime oldTime;

    public RescheduleCommand(CareTask task, LocalDateTime newTime) {
        this.task = task;
        this.newTime = newTime;
    }

    @Override
    public void execute() {
        oldTime = task.getDueAt();
        task.setDueAt(newTime);
        System.out.println("[RescheduleCommand] Rescheduled task " +
                task.getId() + " to " + newTime);
    }

    @Override
    public void undo() {
        if (oldTime != null) {
            task.setDueAt(oldTime);
            System.out.println("[RescheduleCommand] Restored old time " +
                    oldTime + " for task " + task.getId());
        }
    }
}
