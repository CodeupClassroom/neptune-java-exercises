public class Penguin extends Bird {

    final String ORDER = "Sphenisciformes";
    // cannot be reassigned

    // override MakeNoise()
    public void makeNoise(){
        System.out.println(this.getName() + " goes honk honk!");
    }

    // override move()
    public void move(){
        System.out.println(this.getName() + " goes waddle waddle");
    }
}
