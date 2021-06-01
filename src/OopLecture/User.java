package OopLecture;

public class User {
    public int id;
    public String username;
    private String password;
    public String email;
    private boolean isLoggedIn = false;

    public String getPassword(){
        return password;
    }

    public User(int id, String username, String password, String email, boolean isLoggedIn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isLoggedIn = isLoggedIn;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.isLoggedIn = loggedIn;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {};

    public static void main(String[] args) {
        User testUser = new User();
        testUser.id = 1;
        testUser.username = "jayman";
        testUser.password = "password";
        testUser.email = "jayman@email.com";

        System.out.println("Username: " + testUser.username);
        System.out.println("Password: " + testUser.password);
        System.out.println("Email: " + testUser.email);
        System.out.println("Logged in? " + testUser.isLoggedIn);

        User user2 = new User("codeup-dude", "gocodeup", "codeup@email.com");

        System.out.println("Username: " + user2.username);
        System.out.println("Password: " + user2.password);
        System.out.println("Email: " + user2.email);
    }
}
