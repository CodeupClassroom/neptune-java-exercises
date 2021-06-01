import java.util.Scanner;

/**
 * Bob is a lackadaisical teenager. In conversation, his responses are very limited.
 *
 *     Bob answers 'Sure.' if you ask him a question. (the input ends with a question mark)
 *     He answers 'Whoa, chill out!' if you yell at him. (the input ends with an exclamation mark)
 *     He says 'Fine. Be that way!' if you address him without actually saying anything. (empty input)
 *     He answers 'Whatever.' to anything else.
 */

public class Bob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey, my name's Bob... My mom said you wanted to talk to me, or something... Whatever...");
        String response = "";
        while(!response.equalsIgnoreCase("QUIT")) {
            System.out.println("What do you want?");
            response = sc.nextLine();
            if (response.isEmpty()) {
                System.out.println("Fine. Be that way!");
            } else if (response.endsWith("?")) {
                System.out.println("Sure.");
            } else if (response.endsWith("!")) {
                System.out.println("Whoa, chill out!");
            } else if (response.equalsIgnoreCase("quit")){
                System.out.println("Finally...");
            } else {
                System.out.println("Whatever.");
            }
        }
        System.out.println("I'm out of here...");
    }
}
