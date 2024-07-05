public class SessionManager {
    private User loggedInUser;
    public void login(User user) {
        loggedInUser = user;
    }
    public void logout() {
        loggedInUser = null;
    }
    public User getLoggedInUser() {
        return loggedInUser;
    }
}
