// Bird is the superclass
public class Bird {
    // can it fly?
    private boolean canFly;

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    // what kind of bird?
    // the protected access modifier is like private, but not just for the class this instance variable is in, also for all its subclasses. Only the class it's in or subclasses of the class it's in can access this variable.
//    private String name;
      protected  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // make sure this is not an Integer ...
        // make sure user is logged in
        this.name = name;
    }

    public void makeNoise(){
        System.out.print(this.getName() + " goes ");
    }

    public void move(){
        System.out.println("Flap flap");
    }

//    public void move(String Location, double velocity){
//        //code here
//    }
    // in our subclass, if we do super.move(), it will access move()
    // if we do super.move("forest", 12);

    public Bird(){
        System.out.println("A Bird Just Got Created");
        this.canFly = true;
        this.name = "Parrot";
    }

    public Bird(String nameOfThisBird, boolean itCanFly){
        this.name = nameOfThisBird;
        this.canFly = itCanFly;
    }
}
