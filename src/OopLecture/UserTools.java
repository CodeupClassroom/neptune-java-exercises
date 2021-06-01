package OopLecture;

import java.util.Scanner;

public class UserTools {
    public static Scanner scanner = new Scanner(System.in);

    public static void logIn(User u){
        System.out.println("Please enter your password: ");

        String userPassword = scanner.nextLine();

        if(userPassword.equals(u.getPassword())) {
            u.setLoggedIn(true);
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("That password is incorrect.");
        }
    }

    public static void logOut(User u){
        System.out.println("Are you sure you want to log out? (Y/N)");

        String userChoice = scanner.nextLine();

        if(userChoice.equalsIgnoreCase("Y")) {
            System.out.println("You have successfully logged out!");
        } else {
            System.out.println("We will keep you logged in.");
        }
    }

    public static void changePassword(User u) {
        if(!u.isLoggedIn()) {
            System.out.println("Sorry, you are currently logged out. Please log in.");
            logIn(u);
        } else {
            System.out.println("Please enter your current password: ");
            String currentPassword = scanner.nextLine();
            if(u.getPassword().equals(currentPassword)) {
                System.out.println("Please enter a new password: ");
                String newPassword = scanner.nextLine();
                u.setPassword(newPassword);
                System.out.println("Congratulations, your password is now " + newPassword);
            } else {
                System.out.println("Sorry, that password is incorrect.");
            }
        }
    }

    public static void main(String[] args) {
        User testUser = new User();
        testUser.id = 1;
        testUser.username = "jayman";
        // if password was public
//        testUser.password = "password";
        // if password is private
        testUser.setPassword("password");
        testUser.email = "jayman@email.com";
        logIn(testUser);

//        User user2 = new User("codeup-dude", "gocodeup", "codeup@email.com");
//
//        System.out.println("Username: " + user2.username);
//        System.out.println("Password: " + user2.getPassword());
//        System.out.println("Email: " + user2.email);
//
////        user2.setPassword("testtesttest");
//
//        System.out.println(user2.getPassword());

        changePassword(testUser);

    }
}
