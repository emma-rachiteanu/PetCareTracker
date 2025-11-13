package petcare.singleton;

import petcare.models.PetProfile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetProfileManager {

    private static final PetProfileManager instance = new PetProfileManager();

    private final Map<String, PetProfile> profiles = new HashMap<>();

    private PetProfileManager() { }

    public static PetProfileManager getInstance() {
        return instance;
    }

    public void addProfile(PetProfile profile) {
        profiles.put(profile.getId(), profile);
    }

    public PetProfile getProfile(String id) {
        return profiles.get(id);
    }

    public void removeProfile(String id) {
        profiles.remove(id);
    }

    public Collection<PetProfile> getAllProfiles() {
        return profiles.values();
    }
}
