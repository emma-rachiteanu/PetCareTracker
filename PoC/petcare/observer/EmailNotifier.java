package petcare.observer;

import petcare.models.CareTask;

public class EmailNotifier implements Observer {
    @Override
    public void update(CareTask task) {
        System.out.println("[EmailNotifier] Email sent about task: " +
                task.getTitle());
    }
}
