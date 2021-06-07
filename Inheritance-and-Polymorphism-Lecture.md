# Inheritance

Inheritance is a way to relate classes to one another such that common code is in one class called the superclass, which contains code common to many classes, while code that is specific to only a few cases is in the more specific classes. This helps us avoid code repetition, it helps us maintain our code more easily, and it establishes common protocols for groups of related classes, which makes programming easier and helps ensure other programmers use your classes as intended.

Let's look at an example. Let's create a very simple Bird class.
```
public class Bird {
    // can it fly?
    private boolean canFly;

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isCanFly() {
        return canFly;
    }

    // what kind of bird is it?
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeNoise(){
        System.out.println("Tweet tweet");
    }

    public void move(){
        System.out.println("Flap flap");
    }
}
```
Now let's compile it and make a BirdTest class

```
public class BirdTest {
    public static void main(String[] args) {
        Bird cardinal = new Bird();
        cardinal.setName("Cardinal");
        cardinal.setCanFly(true);
        cardinal.makeNoise();
        cardinal.move();
    }
}
```

Now, we'll notice a number of issues with this code. First of all, not all birds go tweet tweet or flap flap. Some birds go quack quack and waddle waddle. Other birds go chirp chirp flap flap. Others go honk honk splish splash. How are we going to go about this? We could start a series of if elses in the noise and move categories. But this would result in code bloat. There would be a lot of code in the bird class that only applies to some birds, not all birds. 

What we want is smaller, more specific classes that contain the code specific to specific birds, while we keep the general code that applies to all birds in the bird class.

The other thing that is not ideal is that the programmer has to know that they have to set the canFly and name variables every time a Bird is instantiated. Otherwise we'll get nulls in the move and makeNoise methods. Ideally, we would make a constructor with arguments instead of using the default constructor the compiler makes for us.

One thing at a time. Let's make a Duck class. The key to this is going to be to use the phrase extends Bird. Using this language, we declare the Duck class as an extension of the Bird class. Now everything in the Bird class applies to the Duck class, but the Duck class can extend the Bird class by having its own specific behaviors.

We say that Bird is the superclass, Duck is the subclass. And we say that Duck inherits the instance variables and methods from the Bird class.

Let's try this on a basic level, first without adding anything to the Duck class.

```
public class Duck extends Bird {

}
```
```
Duck mallard = new Duck();
        mallard.setCanFly(true);
        mallard.setName("Mallard Duck");
        mallard.makeNoise();
```

Notice here there is absolutely nothing in the Duck class. But all the methods that worked on the Bird class still work on the Duck class. The Duck class has inherited state and behavior from the Bird class. 

Another way of saying it is that the Bird class establishes a protocol for all Birds, and subclasses of Bird have to follow that protocol.

Now let's say that Ducks have their own noise. Who's ever heard a duck tweet? Everyone knows ducks quack. But we're inheriting a method from the Bird class that has birds go tweet? What are we going to do? Are we going to delete the makeNoise class from the Bird class and write unique ones in each Bird subclass? That would be inefficient. We want there to be a makeNoise method in all Bird subclasses. So we leave it in there to establish that protocol and as a default. 

What we can do is override

## Override

```
public class Duck extends Bird {
    public void makeNoise() {
        System.out.println(this.getName() + " goes Quack Quack");
    }
}
```

Overriding: a subclass redefines one of its inherited methods when it needs to change or extend the behavior of that method.

Now if I run the exact same code in the BirdTest class I get quack quack
```
src % java BirdTest  
Mallard Duck goes Quack Quack
```

But if I create a tweety-bird class, it will still inherit the default makeNoise() method with tweet tweet

```
public class Finch extends Bird{
    
}
```
```
        Finch lesserGoldfinch = new Finch();
        lesserGoldfinch.setName("Lesser Goldfinch");
        lesserGoldfinch.makeNoise();
```
```
Mallard Duck goes Quack Quack
Lesser Goldfinch goes Tweet tweet
```

One more example, let's make a penguin. This one will override makeNoise and move.

```
public class Penguin extends Bird {
    public void makeNoise(){
        System.out.println(this.getName() + " goes honk honk");
    }

    public void move(){
        System.out.println(this.getName() + " goes waddle waddle");
    }
}
```

```
        Penguin penguin = new Penguin();
        penguin.setName("Emperor Penguin");
        penguin.makeNoise();
        penguin.move();
```

```
Emperor Penguin goes honk honk
Emperor Penguin goes waddle waddle
```

What if you don't want to completely replace the superclass method, just add more stuff to it? You can do this with the *super* keyword. 

We could do something like this:
Bird superclass:
```
   public void makeNoise(){
        System.out.print(this.getName() + " goes ");
    }
```
Duck subclass:
```
public class Duck extends Bird {
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Quack Quack");
    }
}
```
Run the exact same, unchanged BirdTest and the Mallard Duck still goes quack quack.

The super keyword says "go to the superclass version, run that code first, then come back here and run the code in this subclass to finish."

Some things to keep in mind about overriding. You have to fulfill the protocol. The arguments must be the same,a nd return types must be compatible. Otherwise you are overloading, not overriding. And the method cannot be less accessible. You can't override a public method and make it private, that will generate a runtime error.

When you overload, on the other hand, the return types can be different; and the argument list MUST be different. If you only change the return type and not the argument list, the compiler will think you are overriding and won't allow it. When you overload, you can change access levels from less to more or more to less restrictive.

## The is-a and has-a tests

Should one thing extend another? Use the is-a test.

Does it make sense to say that type X is-a type Y? 

A penguin is a bird. A duck is a bird. 

We could say, a Honda Civic is a car. A Ford F-150 is a truck. A programmer is a person. A planetoid is a stellar object. And so forth.

But let's say we want our birds to have nests. So we create a Nest class. It seems like nest might extend bird, right? Wrong. Can you say a nest is-a bird? No. 

Nest passes a different test for bird. A bird has-a nest. Therefore nest might be a separate class from bird. A bird might have a nest in it as an instance variable. So Bird would have a reference to Nest. But we would not make Nest extend Bird.

## Polymorphism

Notice the way we have been creating objects and declaring references to them.

```
Bird theBird = new Bird();
```

First we declare a reference variable. This is a variable named theBird of type Bird. We need this reference in order to access the object we are going to create. Reference variables, along with other local variables, live in a part of Java memory called the stack.

Note that we can do this part independently

```
Bird theBird;
```

This creates the reference variable but doesn't assign it yet. 

Then we create an object

```
new Bird();
```

This calls the default constructor for the Bird class, which is automatically created by the compiler if we haven't declared a custom constructor. It's the same as saying

```
public Bird(){
}
```

Finally, we link the object to the reference using an assignment operator.

```
=
```
```
Bird theBird = new Bird();
```

We have now declared a reference variable, created a new object, and assigned the new object to the reference variable, which allows us to access the new object through the reference variable.

So far, the reference type and the object type have always been the same. Bird and Bird, Penguin and Penguin, Duck and Duck. 

Polymorphism allows us to have different reference and object types.

```
Bird myPenguin = new Penguin();
```

Thanks to this, you can have a polymorphic array.

Fix up the Finch class
```
public class Finch extends Bird{
    public void makeNoise(){
        super.makeNoise();
        System.out.println("Tweet Tweet");
    }
}
```
Create a BirdShelter
```
public class BirdShelterTest {

    public static void main(String[] args) {
        Bird[] birds = new Bird[3];
        birds[0] = new Finch();
        birds[0].setName("Lesser Goldfinch");
        birds[1] = new Duck();
        birds[1].setName("Mallard");
        birds[2] = new Penguin();
        birds[2].setName("Emperor Penguin");

        for (int i = 0; i < birds.length; i++){
            birds[i].makeNoise();
        }
    }
}
```
Notice we've created a test before we've created a class. By the book, this is how you should do it. Also notice the cumbersome need to set the name manually every time we create a new object. We'll try to address this soon.

So you can see that with polymorphism, which means many forms, you can have many different types of object in one array, as long as the is-a relationship holds, that is, as long as whatever it is that is assigned to the reference variable extends it.

You can also have polymorphic arguments and return types. 

```
public class BirdShelter {

    public void shelterSounds(Bird[] birdsOfTheShelter){
        for (int i = 0; i < birdsOfTheShelter.length; i++){
            birdsOfTheShelter[i].makeNoise();
        }
    }
}
```

In BirdShelterTest, replace the for loop with

```
        BirdShelter healingWings = new BirdShelter();
        healingWings.shelterSounds(birds);
```

Create a BirdVet
```
public class BirdVet {
    public void careForBird(Bird birdPatient){
        birdPatient.makeNoise();
    }
}
```
Create a BirdLover
```
public class BirdLover {
    public void takeBirdToVet (Bird ouchyBird){
        BirdVet drAsamoah = new BirdVet();
        drAsamoah.careForBird(ouchyBird);
    }
}
```

The BirdLover takes a duck to the vet at the Bird Shelter and the duck goes quack quack
In BirdShelterTest:
```
        BirdLover audubonBob = new BirdLover();
        audubonBob.takeBirdToVet(birds[1]);
```

## Inheritance and Constructors

Now let's see what we can do about making our bird constructors a little more efficient and free from error. Right now we have to run the setName method manually every time we construct a Bird. If we forget, we'll get null goes Quack Quack. Not good. 

So, let's go into the Bird superclass, which is where our name instance variable is, and let's create a constructor with a name and flight-capacity constructor.

It should look something like this: 
```
public Bird(String nameOfThisBird, boolean itCanFly){
        this.name = nameOfThisBird;
        this.canFly = itCanFly;
    }
```

But notice immediately IntelliJ informs me that something is awry. I've created some kind of problem for my subclasses. Let's go to one and see what's up. IntelliJ informs me that "There is no default constructor in Bird." 

In fact, there was no constructor at all, which just means every time we called the Bird constructor, the Java compiler's automated default constructor kicked in. Now that we have written a custom constructor with arguments, we get an issue with our subclasses. Let's compile and run anyway and see what our actual error is.

No compilation error on Bird.java, that's not where the issue is.

```
 src % javac Finch.java 
Finch.java:1: error: constructor Bird in class Bird cannot be applied to given types;
public class Finch extends Bird{
       ^
  required: String,boolean
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error

```
The error now is when we compile the subclasses. We are told the constructor in Bird cannot be applied to given types. What does this mean?

So, when we have no custom constructor in a class, the compiler creates one for us. A default no-argument constructor. But the instant we add a custom constructor, that no longer happens. Instead of automatically creating a default no-arg constructor, it simply follows the programmer's instructions and uses your custom constructor. 

Now what happens in our subclasses. Our subclasses are primed to use their default constructors. 

Now, one thing is important to know and that is that whenever we call a subclass constructor, it also runs constructors for every class in its inheritance hierarchy.

Let's think about this. A superclass has private instance variables, encapsulated by public setter-getter methods, which the subclass has access to. That variable has to live somewhere. A good way of thinking about it is like an onion. When a subclass is created, it has to create an inner layer that represents its superclass. If that superclass has a superclass of its own, the inner layer creates an inner core representing it.

And all superclasses do have another superclass, the Object class itself, which is the superclass of all other classes. So whenever a Finch is created, a Bird layer is created too, and this means the Bird constructor has to run. And then an Object layer is created, and this means the Object constructor has to run. So when you run a subclass constructor, a chain reaction goes off and all constructors up its inheritance line go off as well. Look.

Let's comment out the custom Bird constructor we just created and instead put a simple no-arg constructor in.

```
//    public Bird(String nameOfThisBird, boolean itCanFly){
//        this.name = nameOfThisBird;
//        this.canFly = itCanFly;
//    }

    public Bird(){
        System.out.println("A Bird just got created");
    }
```

And we'll put a similar message in the Finch constructor.

```
public Finch(){
        System.out.println("A Finch got created");
    }
```
In BirdTest:
```
 Finch houseFinch = new Finch();
```
Output:
```
 src % java BirdTest 
A Bird just got created
A Finch got created
```
You can see that I only ran the Finch constructor, but both the Finch and Bird constructors ran. And the Bird  constructor runs first. Think of it as, a child cannot exist before its parents. The superclass parts have to be fully built before the subclass parts are constructed. Therefore at runtime, the instant a constructor runs, the JVM analyzes its inheritance hierarchy and runs its superclass constructor, which runs its own superclass constructor, and so on all the way up to the Object constructor. Once the highest level constructor runs fully, then the next lower level constructor finishes running, then the level after that, and so on back down to the original class that started the whole chain.

It's very important to understand one inescapable consequence of all this. The first thing that happens whenever a constructor runs is its own superclass constructor is invoked. Nothing, and I mean nothing can run inside the constructor until this happens. Let's explore this.

We now understand that every time we ran new Duck(), even before we had custom constructors, Duck() ran Bird(). But we also know that if there is no custom constructor, the compiler creates one for us. If we were to explicitly create one that looks like what the compiler creates, it would look like this.

```
public Duck(){
        super();
    }
```

Here we see the super keyword used in a different way from what we saw earlier. super() is the superclass invocation. It calls the superclass. And any time you create a custom subclass constructor it is the first statement. If you provide a constructor but you do not put the call in to super(), the compiler will supply it for you. If the superclass has overloaded constructors, the no-arg constructor is the one that is called. So, you might say, why do I need to be aware of this at all?

What you can never do is 
```
public Foo(int bar){
    measurement = bar;
    super();
}    
```
You have to do
```
public Foo(int bar){
    super();
    measurement = bar;
}   
```
Notice if we do 
```
public Duck(){
        super();
        System.out.println("A Duck just got created");
    }
```
And 
```
 Duck hoodedMerganser = new Duck();
```
We get 
```
src % java BirdTest
A Bird just got created
A Duck just got created
```

Armed with this knowledge, let's go back to the custom Bird constructor that was causing a chain of errors down the inheritance hierarchy. Let's uncomment the constructor with arguments. Notice something now, we do not get the chain of warnings. This is because now, we have a no-arg constructor. If we comment it out, the warnings come back.

Notice now in Duck() where we explicitly call super(), we have a more explicit error message now in IntelliJ when we hover over it. It says 
```
Bird(java.lang.String, boolean)' in 'Bird' cannot be applied to '()'
```
When we don't include an explicit call to a superclass constructor, the compiler creates a default superclass constructor for us. The compiler automatically puts it at the top of the subclass constructor. It is just super() without any arguments. But in the Bird class we have just created a constructor with arguments, which overrides the custom constructor and makes it so the compiler no longer creates it for us. In other words, there is no way to create Bird with no arguments. A Bird must be constructed with a name and flight capacity. But the subclass just uses the default no-arg super() call. It sees that the super() call will not work because Bird is requiring two arguments, a boolean and a String. So the subclasses won't compile.

We need to either create a no-argument default constructor in the superclass, or change the subclass constructor so that it uses super(arg, arg) with arguments, or both. Let's explore these two solutions. Probably better to use both.

Let's do the no-arg default constructor first. What are the benefits of this? First of all, a programmer has to know various details of your class in order to even create one. What if they don't know? It may be convenient to allow for the creation of a generic object with default values. A second benefit of this is that subclasses can be created without exactly matching the argument list of the superclass. Because with a no-arg default constructor in the superclass, when the subclasses get their default super() constructors, the compiler will not object.

```
  public Bird(){
        System.out.println("A Bird just got created");
        this.canFly = true;
        this.name = "Parrot";
    }
```

And notice as soon as we do this, the IntelliJ redlines go away from our Finch and Duck classes. Any time someone creates a new Bird() with no arguments, this flying parrot will get created.

In BirdTest
```
        Bird piratesFriend = new Bird();
        System.out.println(piratesFriend.getName());
```
Output:
```
A Bird just got created
Parrot
```

But we really want to have a subclass constructor with arguments. So, as well as solving this problem at the superclass level with a no-arg constructor, we can approach it at the subclass level by passing arguments to the super() call.

Change Bird constructor:
```
public Bird(String nameOfThisBird, boolean itCanFly){
        System.out.println("A Bird just got created");
        this.name = nameOfThisBird;
        this.canFly = itCanFly;
    }
```
BirdTest:
```
        Bird actuallyTheRealBossPirate = new Bird("Parrot", true);
        System.out.println(actuallyTheRealBossPirate.getName());
```
Output:
```
java BirdTest
A Bird just got created
Parrot
```
So, can we modify our subclass constructors to access this super() method?

OK, I can do this in Finch-- 

```
        public Finch(String name, boolean canItFly){
            this.setName(name);
            this.setCanFly(canItFly);
        }
```
And in BirdTest
```
        Finch cassinsFinch = new Finch("Cassin's Finch", true);
        System.out.println(cassinsFinch.getName());
```
Output
```
A Bird just got created
Cassin's Finch
```
Or we could do 
in Finch
```
public Finch(String name, boolean canItFly){
                super(name, canItFly);
            }
```
And we get the same output without having to recompile BirdTest
```
A Bird just got created
Cassin's Finch
```

These are the various approaches you can take when you are using constructors in a context of inheritance. 

## The super keyword, instance variables, and the protected access modifier

We have seen how we can use super to access superclass methods and to invoke superclass constructors. But what about instance variables? 

Notice one thing we have not attempted yet is to have overriding getters and setters in our subclasses. But that is perhaps something we will want to do at some point. 

Let's say I try to do this
Duck.java
```
public void setName(String duckName){
        this.setName(duckName);
    }
```
Seems reasonable? It's actually an infinite loop. setName calls setName, which calls setName, which calls setName. You get a stackoverflow! Yes, a real one.
BirdTest:
```
        Duck rubberDucky = new Duck();
        rubberDucky.setName("Cody");
        System.out.println(rubberDucky.getName());
```
```
Exception in thread "main" java.lang.StackOverflowError
```
This is a runtime error, it compiles fine.
Instead, I could do
```
public void setName(String duckName){
        super.setName(duckName);
    }
```
And now my BirdTest runs
```
public void setName(String duckName){
        super.setName(duckName);
    }
```
However, it's a little redundant. Here's another way to approach it:
```
 public void setName(String duckName){
        super.name = duckName;
    }
```
Notice IntelliJ tells us that name has private access, so we can't get to it. If I try to compile, I get
```
 error: name has private access in Bird
```
We may think this is somehow perverse. After all, Duck is an extension of Bird. A duck is a bird. Why shouldn't a Duck access an instance variable in Bird? On the other hand, if we mark the name variable public, any class anywhere can have access to it. We have a mess on our hands. For these situations, we have the protected access modifier.
In Bird.java:
```
protected String name;
```
Now we can compile, we can run the same code in BirdTest, and we get the same output.

So, what the protected access modifier means is, it's like private, but not just for the class the instance variable is in, but also all its subclasses. Of course, there are other solutions to this problem. You can get around it by using the superclass setters and getters, using super.get or super.set.  In a lot of cases you can use this.get or this.set, you just can't use it recursively. But if I had a bird's weight and wingspan in the Bird class, and I wanted a getDimensions method in one of the subclasses, I could just use this.getWeight and this.getWingspan because those methods are inherited and I am not doing a recursion.

In Bird:
```
rivate int wingspan;

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
```
In Duck:
```
public void getDimensions(){
        int length = this.getLength();
        int wingspan = this.getWingspan();
        String name = this.getName();
        System.out.println("This " + name + " has a weight of " + length + " inches and a wingspan of " + wingspan + " inches");
    }
```
In BirdTest:
```
        Duck americanWigeon = new Duck();
        americanWigeon.setName("American Wigeon");
        americanWigeon.setLength(20);
        americanWigeon.setWingspan(32);
        americanWigeon.getDimensions();
```

## The final keyword

Ok, we have one final topic to cover and that is the final keyword. We have already seen the use of the final keyword to create constants in Java. In the lecture on syntax, types, and variables, we were introduced to this. 
Penguin:
```
final String ORDER = "Sphenisciformes";

public void argumentativeScientist(){
        System.out.println("I do not believe that penguins are " + this.ORDER );
        System.out.println("Actually penguins are parrots");
        this.ORDER = "Psittaciformes";
    }
```
Compilation error:
```
error: cannot assign a value to final variable ORDER
```
Add to argumentativeScientist:
```
System.out.println("This society will regret the day they refused to accept my insights!");
```
There are other uses for the final keyword, though.
You can make a class final. This means the class can never be extended.

```
public final class GalapagosPenguin extends Penguin {
    final String SPECIES_NAME = "Spheniscus mendiculus";
    // no, you will not extend this inheritance chain any further, that's it
}
```
```
public class FernandinaIslandGalapagosPenguin extends GalapagosPenguin{
}
```
```
 javac FernandinaIslandGalapagosPenguin.java 
FernandinaIslandGalapagosPenguin.java:1: error: cannot inherit from final GalapagosPenguin
```

And you can make individual methods final. This makes it so those methods cannot be overridden. Note, if a class is final, you don't have to mark the methods final, because since nothing can extend the class, the methods can never be overridden. However, if you do what to all the class to be extended, but you only want to allow some methods to be overridden, you can just mark individual methods final.

BirdShelter:
```
  boolean camerasOn;
    boolean guardsAlert;
    boolean alarmsArmed;
    public final void securityProcedures(){
        camerasOn = true;
        guardsAlert = true;
        alarmsArmed = true;
    }
```
```
public class SneakyBirdThievesMasqueradingAsABirdShelter extends BirdShelter {
    public void securityProcedures(){
        camerasOn = false;
        guardsAlert = false;
        alarmsArmed = false;
    }
}
```
```
error: securityProcedures() in SneakyBirdThievesMasqueradingAsABirdShelter cannot override securityProcedures() in BirdShelter
```

