package petcare.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private final List<PetProfile> pets = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addPet(PetProfile profile) {
        pets.add(profile);
    }

    public List<PetProfile> getPets() {
        return pets;
    }

    public void viewTasks() {
        System.out.println("Tasks for user " + name + ":");
        for (PetProfile pet : pets) {
            System.out.println("- Pet: " + pet.getName());
            for (CareTask task : pet.getTasks()) {
                System.out.println("   • " + task);
            }
        }
    }
}
