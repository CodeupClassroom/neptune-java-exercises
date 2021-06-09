import java.util.Scanner;

public class ExceptionsStudy {
    public String maybeAnInteger = "42";
    public String definitelyNotAnInteger = "Nope. I am not an integer. I am a string.";

    public void askForAnInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        String userInput = scanner.nextLine();
        try {
            int userInputInteger = Integer.parseInt(userInput);
            System.out.println("The integer in your string is: " + userInputInteger);
        } catch (NumberFormatException nfe){
            System.out.println("Uh oh, " + nfe.getMessage() + " there is no integer!");
        } finally {
            System.out.println("Thank you for using this complex and useful application.");
            System.out.println("Please come back and visit us.");
        }
    }

    public void aMoreComplexAskForInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        String userInput = scanner.nextLine();
        try {
//            userInput = null;
            int userInputInteger = Integer.parseInt(userInput, 10, 15, 10);
            System.out.println("Thank you for entering: " + userInputInteger);
        } catch (NumberFormatException nfe){
            System.out.println("No integer between characters 10 and 15");
            nfe.printStackTrace();
        } catch (IndexOutOfBoundsException iobe){
            System.out.println("Your string wasn't long enough");
        } catch (NullPointerException npe){
            System.out.println("You literally didn't enter anything.");
        } finally {
            System.out.println("Thank you for visiting our application.");
        }
    }


    // Make sure you put more specific exception catches
    // ABOVE more general exception catches in your code
    // or you will get the has already been caught exception
//    public void aMoreComplexAskForInteger(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter an integer");
//        String userInput = scanner.nextLine();
//        try {
//            int userInputInteger = Integer.parseInt(userInput, 10, 15, 10);
//        } catch (NumberFormatException nfe){
//            System.out.println("No integer");
//        }  catch (Exception e){
//            System.out.println("Bad input");
//        } finally {
//            System.out.println("Thank you for visiting our application.");
//        }
//    }

//    public void echoWord() throws IllegalArgumentException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("I am a parrot. Please say something and I will parrot you.");
//        String userInput = scanner.nextLine();
//        if (userInput.equals("curses")) {
//            throw new IllegalArgumentException();
//        }
//        System.out.println(userInput);
//    }

    public void echoWordCustomEx() throws CusswordException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("I am a parrot. Please say something and I will parrot you.");
        String userInput = scanner.nextLine();
        if (userInput.equals("curses")) {
            throw new CusswordException("How dare you? We don't allow that sort of language here?");
        }
        System.out.println(userInput);
    }
}
