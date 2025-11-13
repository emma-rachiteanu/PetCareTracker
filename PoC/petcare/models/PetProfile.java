package petcare.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetProfile {
    private final String id;
    private String name;
    private String breed;
    private int ageMonths;
    private final List<CareTask> tasks = new ArrayList<>();

    public PetProfile(String id, String name, String breed, int ageMonths) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.ageMonths = ageMonths;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTask(CareTask task) {
        tasks.add(task);
    }

    public List<CareTask> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    @Override
    public String toString() {
        return "PetProfile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", ageMonths=" + ageMonths +
                ", tasks=" + tasks.size() +
                '}';
    }
}
