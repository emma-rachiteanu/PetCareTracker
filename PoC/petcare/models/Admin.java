package petcare.models;

import petcare.singleton.PetProfileManager;

public class Admin extends User {

    private final PetProfileManager profileManager;

    public Admin(String name, String email, PetProfileManager profileManager) {
        super(name, email);
        this.profileManager = profileManager;
    }

    public void manageUsers() {
        System.out.println("[Admin] Managing users... (placeholder)");
    }

    public void viewSystemStats() {
        System.out.println("[Admin] Total pet profiles: " +
                profileManager.getAllProfiles().size());
    }

    public void deletePetProfile(String petId) {
        System.out.println("[Admin] Deleting pet profile with id " + petId);
        profileManager.removeProfile(petId);
    }
}
