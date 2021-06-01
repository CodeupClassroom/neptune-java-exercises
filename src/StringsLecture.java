import java.util.Locale;
import java.util.Scanner;

public class StringsLecture {
    public static void main(String[] args) {
        char character = 'd';
        System.out.println(character == 'd');

        Scanner scanner = new Scanner(System.in);
        String bob = "Uncle Bob";
        System.out.println("Hey David, who is your favorite surviving uncle?");
        String maybeBob = scanner.nextLine();
        System.out.println("User answered with correct answer AND capitalization: " + bob.equals(maybeBob));
        System.out.println("User answered with correct answer: " + bob.equalsIgnoreCase(maybeBob));

        // Compare the start and end of Strings
        String david = "David";
        String dad = "Dad";
        String firstLetterDavid = ("" + david.charAt(0)).toLowerCase();
        System.out.println("David and Dad start with the same character?: " + dad.startsWith(firstLetterDavid));

        String coolCats = "Cool Cats are cool, and we like it like that.";
        System.out.println(coolCats.toLowerCase(Locale.ROOT).startsWith("cool"));
        System.out.println(coolCats.endsWith("that."));

        // Manipulation
        int locationOfDaInDad = dad.indexOf("Da");
        System.out.println("The location of \"Da\" in the string of \"Dad\" is: " + locationOfDaInDad);

        int coolCatsLength = coolCats.length();
        System.out.println(coolCatsLength);

        String hiDad = "Hello, Father!";
        String father = hiDad.substring(7,13);
        System.out.println(father);
        System.out.println(hiDad.replace(father, dad));
        System.out.println(hiDad);
        hiDad = hiDad.replace(father, dad);
        System.out.println(hiDad);

        String hasWhitespace = "     Oh that's a lot of white space, huh?        ";
        System.out.println(hasWhitespace.trim());
        System.out.println(hasWhitespace);

        // Rabbit hole (Works!)
        String makeMeWork = "\"%s\" totally works in a souf";
        System.out.printf(makeMeWork, dad);
    }
}
