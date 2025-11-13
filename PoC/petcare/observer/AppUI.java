package petcare.observer;

import petcare.command.AddTaskCommand;
import petcare.factory.TaskFactory;
import petcare.models.CareTask;
import petcare.scheduler.TaskScheduler;
import petcare.singleton.PetProfileManager;

import java.time.LocalDateTime;

public class AppUI implements Observer {

    private final TaskFactory taskFactory;
    private final TaskScheduler scheduler;
    private final PetProfileManager profileManager;

    public AppUI(TaskFactory taskFactory,
                 TaskScheduler scheduler,
                 PetProfileManager profileManager) {
        this.taskFactory = taskFactory;
        this.scheduler = scheduler;
        this.profileManager = profileManager;
    }

    @Override
    public void update(CareTask task) {
        System.out.println("[AppUI] Reminder for task: " + task.getTitle());
    }

    public void requestAddTask(String type,
                               String petId,
                               String title,
                               LocalDateTime dueAt) {
        CareTask task = taskFactory.createTask(type, petId, title, dueAt);
        AddTaskCommand command = new AddTaskCommand(task, profileManager);
        scheduler.schedule(command);
        showConfirmation();
    }

    public void showConfirmation() {
        System.out.println("[AppUI] Task created successfully.");
    }
}
