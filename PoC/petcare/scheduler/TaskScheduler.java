package petcare.scheduler;

import petcare.command.AddTaskCommand;
import petcare.command.TaskCommand;
import petcare.models.CareTask;
import petcare.observer.NotificationService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskScheduler {

    private final List<CareTask> pending = new ArrayList<>();
    private final NotificationService notificationService;

    public TaskScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void schedule(TaskCommand command) {
        command.execute();
        if (command instanceof AddTaskCommand) {
            AddTaskCommand add = (AddTaskCommand) command;
            registerTask(add.getTask());
        }
    }

    public void registerTask(CareTask task) {
        pending.add(task);
        System.out.println("[TaskScheduler] Registered task " + task.getId());
    }

    public void tick(LocalDateTime now) {
        for (CareTask task : pending) {
            if (task.isDue(now)) {
                System.out.println("[TaskScheduler] Task due: " + task);
                notificationService.notifyObservers(task);
            }
        }
    }
}
