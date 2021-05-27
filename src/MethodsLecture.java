import java.util.Scanner;

public class MethodsLecture {

    public static void sayHello() {
        System.out.println("Sorry, I'm in a bit of a rush. Have a great day!");
    }

    public static void sayHello(String name) {
        System.out.printf("Hi there! My name is %s! Have a great day!%n", name);
    }

    public static void sayHello(String salutation, String name) {
        System.out.printf("%s there! My name is %s! Have a great day!%n", salutation, name);
    }

    public static void sayHello(int times) {
        for(int i = 1; i <= times; i++) {
            System.out.println("Hello, darling!");
        }
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static void willYouTakeUsToMtSplashmore(Scanner sc) {
        System.out.println("Will you take us to Mt. Splashmore?");
        if (!sc.nextLine().equalsIgnoreCase("yes")) {
            willYouTakeUsToMtSplashmore(sc);
        } else {
            System.out.println("Thanks Dad, you're the best!");
        }
    }

    public static void bottlesOfBlank(String beverage, int numBottles) {
        if(numBottles == 0) {
            System.out.printf("No more bottles of %s on the wall%nNo more bottles of %s%nStand up now, stumble around%nAll of the bottle of %s on the wall%n", beverage, beverage, beverage);
        } else if (numBottles == 1) {
            System.out.printf("1 bottle of %s on the wall%n1 bottle of %s%nTake it down, pass it around%nNo more bottles of %s on the wall%n", beverage, beverage, beverage);
            bottlesOfBlank(beverage, numBottles - 1);
        } else if (numBottles == 2) {
            System.out.printf("2 bottles of %s on the wall%n2 bottles of %s%nTake 1 down, pass it around%n1 bottle of %s on the wall%n", beverage, beverage, beverage);
            bottlesOfBlank(beverage, numBottles - 1);
        } else {
            System.out.printf("%d bottles of %s on the wall%n%d bottles of %s%nTake 1 down, pass it around%n%d bottles of %s on the wall%n", numBottles, beverage, numBottles, beverage, numBottles - 1, beverage);
            bottlesOfBlank(beverage, numBottles - 1);
        }
    }

    public static void main(String[] args) {
        sayHello();
        sayHello("David");
        sayHello("Howdy", "David");
        sayHello(4);
        System.out.println(multiply(5, 2));
        int product = multiply(7,3);
        System.out.printf("Did you know that %d X %d ='s %d%n", product, product, product * product);
        Scanner sc = new Scanner(System.in);
        willYouTakeUsToMtSplashmore(sc);
        bottlesOfBlank("Surge", 15);
    }
}
