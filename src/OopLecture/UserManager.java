package OopLecture;
import java.util.Scanner;

public class UserManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void startMenu(User u) {
        System.out.println("Welcome, would you like to do?");
        System.out.println("1. Log in.\n2.Exit Program.");

        int userChoice = scanner.nextInt();

        if (userChoice == 1) {
            UserTools.logIn(u);
            editPreferences(u);
        } else {
            System.out.println("Thank you for your time. Bye!");
        }
    }

    public static void editPreferences(User u) {
        if(!u.isLoggedIn()) {
            System.out.println("Sorry, you are currently logged out, please log in.");
            UserTools.logIn(u);
        } else {
            System.out.println("Welcome to your preferences. Would you like to:\n1.Change your password.\n2.Log out");
            int userChoice = scanner.nextInt();
            System.out.println("You chose to choice " + userChoice);
            switch (userChoice) {
                case 1:
                    UserTools.changePassword(u);
                    editPreferences(u);
                    break;
                case 2:
                    UserTools.logOut(u);
            }
        }
    }

    public static void main(String[] args) {
        User user2 = new User("codeup-dude", "gocodeup", "codeup@email.com");

        startMenu(user2);
    }
}
