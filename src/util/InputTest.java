package util;

public class InputTest {
    public static void main(String[] args) {
        Input in = new Input();
//        System.out.println(in.getString());
//        System.out.println(in.getInt());
//        System.out.println(in.getInt(0, 100));
//        System.out.println(in.yesNo());
//        System.out.println(in.getDouble());
//        System.out.println(in.getDouble(1, 2));
        int userInput = in.getInt("Enter an integer: ");
        System.out.println("User input: " + userInput);

    }
}
