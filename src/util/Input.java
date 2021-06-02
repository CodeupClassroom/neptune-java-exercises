package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;
//            = new Scanner(System.in);

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }

    public boolean yesNo() {
        String userInput = this.scanner.nextLine();
        return userInput.trim().equalsIgnoreCase("y") || userInput.trim().equalsIgnoreCase("yes");
    }

    public int getInt() {
        return this.scanner.nextInt();
    }

    public int getInt(int min, int max) {
        System.out.printf("Give me a whole number between %d and %d", min, max);
        int userNumber = this.scanner.nextInt();

        if(userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.println("That number is invalid.");
            return getInt(min, max);
        }
    }

    public double getDouble() {
        return this.scanner.nextDouble();
    }

    public double getDouble(double min, double max) {
        System.out.printf("Give me a decimal number between %f and %f", min, max);
        double userNumber = this.scanner.nextDouble();

        if(userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.println("That number is invalid.");
            return getDouble(min, max);
        }
    }





}
