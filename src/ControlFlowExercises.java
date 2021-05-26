import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {
        // 1. Loop Basics a. While
//        int i = 5;
//        while (i <= 15){
//            if (i < 15) {
//                System.out.print(i + " ");
//            } else {
//                System.out.println(i);
//            }
//            i++;
//        }

        // b. Do While
//        int i = 0;
//        do {
//            System.out.println(i);
//            i += 2;
//        } while (i <= 100);

//        int i = 100;
//        do {
//            System.out.println(i);
//            i -= 5;
//        } while (i >= -10);

//        long i = 2L;
//        do {
//            System.out.println(i);
//            i *= i;
//        } while (i < 1000000);

        // c. For

//        for (int i = 100; i >= -10; i -=5 ){
//            System.out.println(i);
//        }

//        for (long i = 2L; i < 1000000; i *= i){
//            System.out.println(i);
//        }

        // 2. The PIN Problem

//        Scanner scanner1 = new Scanner(System.in);
//        final int PIN = 12345;
//        int userInput = 0;
//        int attempts = 1;
//        while (attempts <=3){
//            System.out.println("Please enter pin: ");
//            userInput = scanner1.nextInt();
//            if (userInput != PIN){
//                if (attempts < 3){
//                    System.out.println("Incorrect, try again");
//                } else {
//                    System.out.println("Sorry but you have been locked out.");
//                }
//            } else {
//                System.out.println("Correct, welcome back");
//                break;
//            }
//            attempts++;
//        }

        // 3. Display a table of powers

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What number would you like to go up to?");
//        boolean userWantsToContinue = false;
//        do {
//            int userInput = scanner.nextInt();
//            System.out.println("Here is your table!");
//            System.out.println("");
//            System.out.println("number | squared | cubed");
//            System.out.println("------ | ------- | -----");
//            for (int i = 1; i <= userInput; i++) {
//                System.out.printf("%-7d| %-8d| %-5d%n", i, i * i, i * i * i);
//            }
//            System.out.println("Enter another number? y/n");
//            String userAnswer = scanner.next();
//            if (userAnswer.equals("y")){
//                userWantsToContinue = true;
//            } else {
//                break;
//            }
//        } while (userWantsToContinue);


        // 4. Convert given number grades into letter grades

        Scanner scanner1 = new Scanner(System.in);
        String userChoice = "y";
        while (!userChoice.equals("n")) {
            System.out.println("Enter the student's numerical grade: ");
            byte grade = scanner1.nextByte();
            char letterGrade;
            if (grade>0 && grade <=59){
                letterGrade = 'F';
            } else if (grade > 59 && grade <= 66){
                letterGrade = 'D';
            } else if (grade > 66 && grade <= 79 ){
                letterGrade = 'C';
            } else if (grade > 79 && grade <= 87) {
                letterGrade = 'B';
            } else {
                letterGrade = 'A';
            }
            System.out.println("The letter grade is: " + letterGrade);
            System.out.println("Would you like to enter another grade?(y/n)");
            userChoice = scanner1.next();
        }

    }
}
