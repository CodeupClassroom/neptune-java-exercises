# Exceptions and Error Handling

We have seen exceptions thrown at various points during our Java apprenticeship. We ran into this just recently when we tried to shove a value into an array that has insufficient space. We got ArrayOutOfBoundsException.

Handling these exceptions is part of Java programming.

A lot of Java methods have some kind of built-in risk that something bad will happen if they are applied. Often, the designers of these methods will predict this bad thing can happen and build in the possibility that the method will throw an exception when it fails.

Let's see an example, Integer.valueOf.
```
public class ExceptionsStudy {
    public String maybeAnInteger = "42";
    public String definitelyNotAnInteger = "Nope. I am not an integer";
}
```
```
        System.out.println(Integer.parseInt(study.definitelyNotAnInteger));

```
IntelliJ run output:
```
42
Exception in thread "main" java.lang.NumberFormatException: For input string: "Nope. I am not an integer"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:660)
	at java.base/java.lang.Integer.parseInt(Integer.java:778)
	at ExceptionsStudyTest.main(ExceptionsStudyTest.java:5)
```
The parseInt method threw an exception. We didn't build in any elegant way of handling it, so we get a failure at runtime. 

How do we know parseInt might throw a NumberFormatException? We can look at the method definition in the API.

Search: Java 16 API Integer

[Java 16 Integer API](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/Integer.html)

You can see that the prseInt method by definition throws a NumberFormatException if the string does not contain a parsable int.

So, in many cases you can predict what exceptions will be thrown and under what circumstances by consulting the Java API. Other times you have to experiment with various Bad Things to see what exceptions get thrown back to you.

Once you know the kinds of exceptions that will be thrown by the methods you are running, you can catch them when they are thrown.

```
public class ExceptionsStudyTest {
    public static void main(String[] args) {
        try {
            ExceptionsStudy study = new ExceptionsStudy();
            System.out.println(Integer.parseInt(study.maybeAnInteger));
            System.out.println(Integer.parseInt(study.definitelyNotAnInteger));
        } catch (NumberFormatException nfx) {
            System.out.println("Got an exception: " + nfx);
        }
    }
}
```
Output:
```
42
Got an exception: java.lang.NumberFormatException: For input string: "Nope. I am not an integer"
```
This at least allows you to see the input string in your output, and your program runs. You predict the possible exception and catch it. You write your own code to deal with it.

You can, if you want, run some useful methods on the error object itself once you have it:

```
            System.out.println("Here's the full details of the exception:");
            nfx.printStackTrace();
            System.out.println(nfx.getMessage());
```

Exceptions are objects of type Exception
[Arithmetic Exception](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/ArithmeticException.html)

>Class ArithmeticException
java.lang.Object  
        java.lang.Throwable  
            java.lang.Exception  
                java.lang.RuntimeException  
                    java.lang.ArithmeticException  

getMessage() and printStackTrace() are actually inherited from Throwable. Exception inherits from Throwable and all exceptions inherit from Exception.

You can see a summary of major Exceptions under the java.lang package summary, and a full list of Exceptions if you click into the Exception class

[java.lang](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/package-summary.html)

[The Exception Class](https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/lang/Exception.html)

There are two main categories of exceptions, checked and unchecked. The compiler checks for checked exceptions and prevents your code from compiling if you don't catch them. A main subcategory of these are IOExceptions, such as FileNotFoundException; these will make more sense when we do File IO. If you run a method that throws these exceptions, you must have a try-catch to handle them.

However, there is a large category of RuntimeException, and these are not caught by the compiler. That's in situations where you as programmer can guarantee through good programming practices that the error never happens. To give an example, an ArrayOutOfBoundsException is predictable and can be handled by your code using the .length attribute. These sorts of exceptions should be encountered in dev and testing and handled with normal programming practices, not with try-catch. On the other hand, you can't guarantee that a server will be up or that a file will be right where it's supposed to be when your program tries to access it, hence those are checked exceptions that the compiler will force you to try-catch.

We can add a third clause to our try-catch control flow, called finally. This is for code you want to happen no matter what. In other words, you have code you want to run whether there is an error or not. 
In ExceptionStudy (make sure to import java.util.Scanner):
```
    public void askForAnInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        String userInput = scanner.nextLine();
        try {
            int userInputInteger = Integer.parseInt(userInput);
            System.out.println("The integer in your string is " + userInputInteger);
        } catch (NumberFormatException nfx){
            System.out.println("Uh oh, " + nfx.getMessage() + " there is no integer!");
        } finally {
            System.out.println("Thank you for using this complex and useful application.");
            System.out.println("Please come back and visit.");
        }
    }
```
In ExceptionStudyTest:
```
 ExceptionsStudy study = new ExceptionsStudy();
        study.askForAnInteger();
```

Keep in mind, many methods can throw more than one type of exception. You can catch multiple exceptions with sequences of catch clauses.

```
public void aMoreComplexAskForInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer");
        String userInput = scanner.nextLine();
        try {
            //userInput = null;
            int userInputAsInteger = Integer.parseInt(userInput, 10, 15, 10);
        } catch (NullPointerException npx){
            System.out.println("Oops you didn't enter anything");
            npx.printStackTrace();
        } catch (IndexOutOfBoundsException iobx) {
            System.out.println("Oops your string wasn't long enough");
            iobx.printStackTrace();
        } catch (NumberFormatException nfx){
            System.out.println("No integer between chars 10 and 15");
            nfx.printStackTrace();
        } finally {
            System.out.println("That was useful wasn't it?");
        }
    }
```

Exceptions are polymorphic, so I could catch all of them with a single catch(Exception e) clause. A sort of catch-all. That doesn't mean it's a good idea, but sometimes you don't need to handle all of them separately. In fact, in this application, the user needs different feedback for IndexOutOfBounds vs NumberFormatException, so separate ones might be useful. Also keep in mind that if you do have a specific catch and a general catch, the general catch needs to be below the specific catch, otherwise the general catch will catch all of them, and the specific catch will catch none of them. So I wouldn't want to do

```
 try {
           
            int userInputAsInteger = Integer.parseInt(userInput, 10, 15, 10);
        } catch (Exception e){
            System.out.println("Get your act together, give me the right input");
            e.printStackTrace();
        }  catch (NumberFormatException nfx){
            System.out.println("No integer between chars 10 and 15");
            nfx.printStackTrace();
        } finally {
            System.out.println("That was useful wasn't it?");
        }
```
In this code, NumberFormatException will never get caught because the Exception clause will capture all the exceptions before the code ever gets to the NumberFormatException catch. 

If I know my a method I am writing has some kind of risk, I can program it to throw an exception, using the ```throw``` keyword.

```
 public void echoWord() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("I am a parrot. Please say something so I can parrot you.");
        String userInput = scanner.nextLine();
        if (userInput.equals("curses")){
            throw new IllegalArgumentException();
        }
        System.out.println(userInput);
    }
```
```
ExceptionsStudy study = new ExceptionsStudy();
        study.echoWord();
```
```
  try {
            study.echoWord();
        } catch (IllegalArgumentException iax){
            System.out.println("How rude!");
        }
```
The syllabus points out that you can throw the same exception in the main method. This is called ducking the exception. If you have a method that could catch an exception, instead of catching it you could throw it. Then, if that method calls another method, it's that other method's responsibility to catch it. But the last method in the line of methods is main. If you throw an exception from main, nothing catches it and you just get the raw exception. So this is inadvisable.

To demonstrate:
Change definition of main method to:
```public static void main(String[] args) throws IllegalArgumentException```
run
```
ExceptionsStudy study = new ExceptionsStudy();
        study.echoWord();
```
Enter "curses", and an exception will be thrown but not caught.

Last but not least, you can write a custom exception
```
public class CusswordException extends Exception {
    CusswordException(String word){
        super(word);
    }
}
```

```
study.echoWordCustomEx()
```
Notice if I try to compile this I get an error
```
 error: unreported exception CusswordException; must be caught or declared to be thrown
```
A custom exception is a checked exception, and unless you handle it wherever you use it, your code won't compile
```
        try {
            study.echoWordCustomEx();
        } catch (CusswordException cx){
            System.out.println(cx.getMessage());
        }
```
Enter "curses"
Output:
```
I am a parrot. Please say something so I can parrot you.
curses
How dare you? We don't allow that sort of language here.
```
You probably won't do this much if at all, but you can do this if you need a specific error message to go with an exception. Usually it is better to use an existing exception.

