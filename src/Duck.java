public class Duck extends Bird {
    // Duck inherits from Bird
    // Duck is the subclass of the Bird superclass
    // Duck inherits all public methods

    // let's override
    // overrides makeNoise() from Bird()

    // When overriding you have to fulfill the protocol
    // The arguments must be the same, and return types compatible
    // if you change arguments or return types, you are overloading not overriding
    public void makeNoise(){
        super.makeNoise();
        System.out.println("Quack Quack!");
    }
}
