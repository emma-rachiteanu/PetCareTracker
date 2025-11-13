package petcare.command;

import petcare.models.CareTask;
import petcare.models.PetProfile;
import petcare.singleton.PetProfileManager;

public class AddTaskCommand implements TaskCommand {

    private final CareTask task;
    private final PetProfileManager profileManager;
    private boolean executed = false;

    public AddTaskCommand(CareTask task, PetProfileManager profileManager) {
        this.task = task;
        this.profileManager = profileManager;
    }

    public CareTask getTask() {
        return task;
    }

    @Override
    public void execute() {
        if (!executed) {
            PetProfile profile = profileManager.getProfile(task.getPetId());
            if (profile != null) {
                profile.addTask(task);
                executed = true;
                System.out.println("[AddTaskCommand] Task added: " + task);
            }
        }
    }

    @Override
    public void undo() {
        if (executed) {
            PetProfile profile = profileManager.getProfile(task.getPetId());
            if (profile != null) {
                profile.getTasks().remove(task);
                System.out.println("[AddTaskCommand] Task removed (undo): " + task);
            }
            executed = false;
        }
    }
}
