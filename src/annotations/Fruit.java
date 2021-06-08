package annotations;
@SuppressWarnings("all")
public class Fruit implements Food{
    private String flavor;

    @Deprecated
    private boolean hasFlesh;

    private boolean eatableSeeds;

    public String taste() {
        return this.flavor;
    }

    public static void main(String[] args) {
        Fruit lime = new Fruit();
        lime.hasFlesh = true;
        lime.flavor = "sour";
        System.out.println(lime.taste());
    }
}
