package task_4;

public class User {
    private String username;
    private String password;
    private int failedAttempts;
    private boolean blocked;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.failedAttempts = 0;
        this.blocked = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void login(String inputPassword)
            throws WrongPasswordException, UserBlockedException {

        if (blocked) {
            throw new UserBlockedException("User is blocked");
        }

        if (!password.equals(inputPassword)) {
            failedAttempts++;
            if (failedAttempts >= 3) {
                blocked = true;
                throw new UserBlockedException("User was blocked after 3 attempts!");
            } else {
                throw new WrongPasswordException("Wrong password, failed attempts:" + failedAttempts);
            }
        }

        failedAttempts = 0;
        System.out.println("Welcome " + username + "!");
    }
}
