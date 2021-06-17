package grocery;

import util.Input;

import java.util.ArrayList;
import java.util.HashMap;

public class GroceryApp {

    public static void addToShoppingList(HashMap<String, ArrayList<Item>> list, Input in) {
        System.out.println("Please select a department:");
        int num = 1;
        for (String department : list.keySet()) {
            System.out.printf("%d: %s%n", num, department);
            num++;
        }
        String selectedDepartment = "";
        while (!list.containsKey(selectedDepartment)) {
            selectedDepartment = in.getString("Please enter the name of the item's department:");
            if (!list.containsKey(selectedDepartment)) {
                System.out.println("Input invalid.\nPlease try again.");
            }
        }
        String itemName = in.getString("Please enter the name of the item:");
        int itemQuantity = in.getInt("Please enter item quantity:");
        float itemPrice = (float) in.getDouble("Please enter individual item price:");
        in.getString();
        System.out.printf("Please review the following item:%nItem Name: %s%nItem Department: %s%nItem Quantity: %d%nItem Price: $%.2f%nWould you like to add this item to your grocery list?%n", itemName, selectedDepartment, itemQuantity, itemPrice);
        if (in.yesNo()) {
            System.out.println("Item has been saved to list.");
            list.get(selectedDepartment).add(new Item(itemName, itemQuantity, itemPrice));
        } else {
            System.out.println("Item discarded.\nWould you like to add a different item?");
            if (in.yesNo()) {
                addToShoppingList(list, in);
            }
        }
    }

    public static void printList(HashMap<String, ArrayList<Item>> list) {
        System.out.println("Here is your current list of items:");
        int categoriesGathered = 0;
        for (HashMap.Entry<String, ArrayList<Item>> pair : list.entrySet()) {
            if (!pair.getValue().isEmpty()) {
                categoriesGathered++;
                System.out.printf("%s:\n" , pair.getKey());
                for (Item item : pair.getValue()) {
                    if (item.getQuantity() > 1) {
                        System.out.printf("    %s, %d, $%.2f each, $%.2f total%n", item.getName(), item.getQuantity(), item.getPrice(), (item.getQuantity() * item.getPrice()));
                    } else {
                        System.out.printf("    %s, $%.2f%n", item.getName(), item.getPrice());
                    }
                }
                System.out.println();
            }
        }
        if (categoriesGathered == 0) {
            System.out.println("\nList is currently empty.\nPlease add items to your grocery list.\n");
        }
    }

    public static void runApp(HashMap<String, ArrayList<Item>> list, Input in) {
        System.out.println("Welcome to Happy Market Grocery List Builder!\n-----\n");
        boolean run = true;
        while (run) {
            System.out.println("Please make your selection:");
            System.out.println("1. Add New Item To List");
            System.out.println("2. View List");
            System.out.println("3. Quit");
            int userResp = in.getInt("Please enter either 1, 2, or 3 into your terminal.",1,3);
            in.getString();
            switch(userResp) {
                case 1:
                    addToShoppingList(list, in);
                    System.out.println("Returning to menu...\n");
                    break;
                case 2:
                    printList(list);
                    System.out.println("Returning to menu...\n");
                    break;
                default:
                    System.out.println("Are you sure you want to quit?");
                    if (in.yesNo()) {
                        System.out.println("Thank you for choosing Happy Market.\nWe'll see you soon!");
                        run = false;
                    } else {
                        System.out.println("Returning to menu...\n");
                    }
            }
        }
    }

    public static void main(String[] args) {
        // Building the grocery list and menu of categories
        HashMap<String, ArrayList<Item>> list = new HashMap<>();
        list.put("Produce", new ArrayList<>());
        list.put("Bakery", new ArrayList<>());
        list.put("Butcher's Shop", new ArrayList<>());
        list.put("Seafood", new ArrayList<>());
        list.put("Beer & Wine", new ArrayList<>());
        list.put("Pantry Goods", new ArrayList<>());
        list.put("Frozen Goods", new ArrayList<>());
        list.put("Dairy", new ArrayList<>());
        list.put("Drug Store & Pharmacy", new ArrayList<>());
        list.put("Pet Food", new ArrayList<>());

        // calling runApp
        runApp(list, new Input());
    }
}