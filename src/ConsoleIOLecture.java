import java.util.Scanner;

public class ConsoleIOLecture {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String name = "Eduardo";
        System.out.printf("Hello, %s%n", name);

        System.out.format("%d is %s's favorite number%nThis is a %b statement%n", 42, name, false);
        System.out.println("I'm on a new line.");

        System.out.println("Hello, " + name);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hey friend-o, how's it going?");
        String userInput = scanner.nextLine();

        System.out.printf("You're feeling: %s%n", userInput);

        System.out.println("Give me a number.");
        int num = scanner.nextInt();

        System.out.printf("Your number: %d%n", num);

    }
}
