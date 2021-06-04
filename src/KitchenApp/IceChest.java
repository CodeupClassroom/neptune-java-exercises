package KitchenApp;

import java.util.Scanner;

public class IceChest implements StoreFood {

    private boolean hasIce;

    public boolean isHasIce() {
        return hasIce;
    }

    public void setHasIce(boolean hasIce) {
        this.hasIce = hasIce;
    }

    // Must Override our keepFresh method that is defined in our StoreFood interface
    // because each object that implements StoreFood may implement different ways to keep things fresh.

    public void keepFresh() {
        // if the user wants to add something to the ice chest, does the item need ice?
        // if the item needs ice, we can set hasIce to true, then add more items.
        // if not, we can set hasIce to false, and continue to add items.

        Scanner sc = new Scanner(System.in);
        System.out.println("Does the item you want to keep in the ice chest need to be kept cold? (Y/N)");
        String userChoice = sc.nextLine();
        if (userChoice.equalsIgnoreCase("yes") || userChoice.equalsIgnoreCase("y")) {
            this.hasIce = true;
            System.out.println("Ice has been added.");
            do {
                System.out.println("What would you like to keep cool?");
                String item = sc.nextLine();
                System.out.printf("%s has been added to the ice chest.\n", item);
                System.out.println("Would you like to add another item?");
                userChoice = sc.nextLine();
            } while(userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes"));
            // Exiting the program.
            System.out.println("Thank you! Closing the lid.");

        } else {
            this.hasIce = false;
            do {
                System.out.println("What would you like to put into the ice chest?");
                String item = sc.nextLine();
                System.out.printf("%s has been added to the ice chest.\n", item);
                System.out.println("Would you like to add another item?");
                userChoice = sc.nextLine();
            } while(userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes"));
            System.out.println("Thank you! Closing the lid.");
        }
    }
}
