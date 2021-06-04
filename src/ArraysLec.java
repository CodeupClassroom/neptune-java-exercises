import java.util.Arrays;

public class ArraysLec {
    // If we wrote the Arrays.toString() as a method ourselves (specifically for an array of ints)
    public static String arrToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                str += arr[i] + "]";
            } else {
                str += arr[i] + ", ";
            }
        }
        return str;
    }

    public static void main(String[] args) {
        int[] numbers = {14, 64, 34, 44};
        numbers[1] = 33;
        for (int number : numbers) {
            System.out.println(number);
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        String[] topFiveExampleNames = new String[5];

        topFiveExampleNames[0] = "Greg";
        topFiveExampleNames[1] = "Jim";
        topFiveExampleNames[2] = "Geoff";
        topFiveExampleNames[3] = "Naysa";
        topFiveExampleNames[4] = "Hideo";

        for (String name : topFiveExampleNames) {
            System.out.println(name);
        }

        boolean[] lookingAtDefaultVals = new boolean[3];

        for (boolean boo : lookingAtDefaultVals) {
            System.out.println(boo);
        }

        Arrays.fill(lookingAtDefaultVals, true);

        for (boolean boo : lookingAtDefaultVals) {
            System.out.println(boo);
        }

        Arrays.fill(topFiveExampleNames, "Jim");
        topFiveExampleNames[0] = "Naysa";

        for (String name : topFiveExampleNames) {
            System.out.println(name);
        }

        int[] alsoNums = {14, 33, 34, 44};

        for (int number : numbers) {
            System.out.println(number);
        }

        for (int number : alsoNums) {
            System.out.println(number);
        }

        System.out.println(Arrays.equals(numbers, alsoNums));

        int[] yetMoreNums = Arrays.copyOf(numbers, 5);

        for (int number : yetMoreNums) {
            System.out.println(number);
        }

        int[] numbersAgain = numbers;

        System.out.println(yetMoreNums == numbers);

        int[] unsortedNightmare = {99,-19,88,0,3,44,13};

        Arrays.sort(unsortedNightmare);

        System.out.println(unsortedNightmare.toString());
        System.out.println(Arrays.toString(unsortedNightmare));
        System.out.println(arrToString(unsortedNightmare));

        char[][] letters = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
                {'J', 'K', 'L'}
        };

        for (char[] row : letters) {
            System.out.println("+---+---+---+");

            System.out.print("| ");

            for (char n : row) {
                System.out.print(n + " | ");
            }

            System.out.println();
        }

        System.out.println("+---+---+---+");

    }
}
