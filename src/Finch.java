public class Finch extends Bird {
    // inherits makeNoise() from Bird
    public void makeNoise(){
        super.makeNoise();
        System.out.println("Tweet Tweet!");
    }

    public Finch(){
        System.out.println("A Finch just got created");
    }
}
