package petcare.app;

import petcare.factory.TaskFactory;
import petcare.models.Admin;
import petcare.models.PetProfile;
import petcare.models.User;
import petcare.observer.AppUI;
import petcare.observer.EmailNotifier;
import petcare.observer.MobileNotifier;
import petcare.observer.NotificationService;
import petcare.scheduler.TaskScheduler;
import petcare.singleton.PetProfileManager;

import java.time.LocalDateTime;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        PetProfileManager profileManager = PetProfileManager.getInstance();
        NotificationService notifications = new NotificationService();
        TaskScheduler scheduler = new TaskScheduler(notifications);
        TaskFactory factory = new TaskFactory();

        User user = new User("Rachi", "rachi@example.com");
        Admin admin = new Admin("Admin", "admin@example.com", profileManager);

        PetProfile luna = new PetProfile("pet-1", "Luna", "Cat", 24);
        profileManager.addProfile(luna);
        user.addPet(luna);

        AppUI appUI = new AppUI(factory, scheduler, profileManager);
        MobileNotifier mobileNotifier = new MobileNotifier();
        EmailNotifier emailNotifier = new EmailNotifier();

        notifications.attach(appUI);
        notifications.attach(mobileNotifier);
        notifications.attach(emailNotifier);

        System.out.println("=== Creating task via AppUI ===");

        appUI.requestAddTask(
                "feeding",
                luna.getId(),
                "Morning breakfast",
                LocalDateTime.now().plusSeconds(3)
        );

        admin.viewSystemStats();

        System.out.println("\n=== Waiting for task to be due... ===");
        Thread.sleep(4000);

        System.out.println("\n=== Scheduler tick (Observer notifications) ===");
        scheduler.tick(LocalDateTime.now());

        System.out.println("\n=== User views tasks ===");
        user.viewTasks();
    }
}