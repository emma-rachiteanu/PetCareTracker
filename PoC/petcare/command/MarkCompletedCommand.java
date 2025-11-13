package petcare.command;

import petcare.models.CareTask;

public class MarkCompletedCommand implements TaskCommand {

    private final CareTask task;
    private boolean previousState;

    public MarkCompletedCommand(CareTask task) {
        this.task = task;
    }

    @Override
    public void execute() {
        previousState = task.isCompleted();
        task.markCompleted();
        System.out.println("[MarkCompletedCommand] Marked completed: " + task);
    }

    @Override
    public void undo() {
        task.setCompleted(previousState);
        System.out.println("[MarkCompletedCommand] Restored completion=" +
                previousState + " for task " + task.getId());
    }
}
