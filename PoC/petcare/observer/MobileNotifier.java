package petcare.observer;

import petcare.models.CareTask;

public class MobileNotifier implements Observer {
    @Override
    public void update(CareTask task) {
        System.out.println("[MobileNotifier] Push notification: " +
                task.getTitle());
    }
}
