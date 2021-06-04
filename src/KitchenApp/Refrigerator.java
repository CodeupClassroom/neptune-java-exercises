package KitchenApp;


import java.util.Scanner;

public class Refrigerator extends Appliance implements StoreFood {
    private boolean hasShelves;

    public boolean isHasShelves() {
        return hasShelves;
    }

    public void setHasIce(boolean hasShelves) {
        this.hasShelves = hasShelves;
    }

    // Method that must be implemented
    // Will not work by trying to generate setters in IntelliJ because there is no "type" field defined in the Refrigerator class.
    public void setType(String type) {
        this.type = type;
    }
    // Method that must be implemented
    // Will not work by trying to generate setters in IntelliJ because there is no "brandName" field defined in the Refrigerator class.
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Refrigerator(String type, String brandName, boolean hasShelves) {
        super(type, brandName);
        this.hasShelves = hasShelves;
    }

    // overloaded constructor to reference for the MiniFridge class.
    public Refrigerator(String type, String brandName) {
        super(type, brandName);
    }
    // Must Override our keepFresh method that is defined in our StoreFood interface
    // because each object that implements StoreFood may implement different ways to keep things fresh.
    public void keepFresh(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to put something in the fridge? (Y/N)");
        String userChoice = sc.nextLine();
        while(userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes")) {
            System.out.println("What would you like to put in the fridge?");
            String item = sc.nextLine();
            System.out.printf("Sounds good! I'll keep your %s cold for you!\n", item);
            System.out.println("Would you like to put anything else in the fridge? (Y/N)");
            userChoice = sc.nextLine();
        }
        System.out.println("Okay, stay cool!");
    }

}
