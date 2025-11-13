package petcare.observer;

import petcare.models.CareTask;

public interface Observer {
    void update(CareTask task);
}
