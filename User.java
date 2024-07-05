import java.util.HashMap;
import java.util.Map;
public class User {
    private String username;
    private String password;
    private String profileInfo;
    private static Map<String, User> users = new HashMap<>();
    public User(String username, String password, String profileInfo) {
        this.username = username;
        this.password = password;
        this.profileInfo = profileInfo;
        users.put(username, this);
    }
    public static User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return user;
        }
        return null;
    }

    public void updateProfile(String profileInfo) {
        this.profileInfo = profileInfo;
    }
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
    public String getProfileInfo() {
        return profileInfo;
    }
}
