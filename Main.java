import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creating users
        new User("user1", "password1", "User One Profile");
        new User("user2", "password2", "User Two Profile");
        // Login
        System.out.println("Login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        User user = User.login(username, password);
        if (user == null) {
            System.out.println("Invalid login");
            return;
        }
        SessionManager sessionManager = new SessionManager();
        sessionManager.login(user);
        System.out.println("Login successful");
        System.out.println("Profile: " + user.getProfileInfo());
        // Update profile
        System.out.print("Update Profile Info: ");
        String profileInfo = scanner.nextLine();
        user.updateProfile(profileInfo);
        System.out.println("Profile updated: " + user.getProfileInfo());
        // Update password
        System.out.print("Update Password: ");
        String newPassword = scanner.nextLine();
        user.updatePassword(newPassword);
        System.out.println("Password updated");
        // Creating MCQs
        MCQ mcq1 = new MCQ("What is 2 + 2?", new String[]{"3", "4", "5"}, 1);
        MCQ mcq2 = new MCQ("What is the capital of France?", new String[]{"Berlin", "Paris", "Rome"}, 1);
        // Creating exam
        Exam exam = new Exam(Arrays.asList(mcq1, mcq2));
        // Timer
        Timer timer = new Timer(60000); // 1 minute
        timer.start();
        // Exam process
        MCQ question;
        while ((question = exam.getNextQuestion()) != null && !timer.isTimeUp()) {
            System.out.println(question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.print("Select answer: ");
            int answer = scanner.nextInt() - 1;
            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
        }
        if (timer.isTimeUp()) {
            System.out.println("Time is up!");
        }
        // Logout
        sessionManager.logout();
        System.out.println("Session ended. Logging out.");
        scanner.close();
    }
}
