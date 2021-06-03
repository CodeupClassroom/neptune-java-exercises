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
    private String name;

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


    public Bird(String nameOfThisBird, boolean itCanFly){
        this.name = nameOfThisBird;
        this.canFly = itCanFly;
    }

    public Bird(){
        System.out.println("A Bird Just Got Created");
        this.canFly = true;
        this.name = "Parrot";
    }
}
