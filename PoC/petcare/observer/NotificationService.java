package petcare.observer;

import petcare.models.CareTask;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(CareTask task) {
        for (Observer o : observers) {
            o.update(task);
        }
    }
}
