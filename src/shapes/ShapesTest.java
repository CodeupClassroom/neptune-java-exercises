package shapes;

public class ShapesTest {
    public static void main(String[] args) {
//        Rectangle box1 = new Rectangle(5, 4);
//        System.out.println("Length: " + box1.getLength() + ". Width: " + box1.getWidth());
//        System.out.println("Perimeter: " + box1.getPerimeter() + ". Area: " + box1.getArea());

//        Rectangle box2 = new Square(5);
//        System.out.println("Length: " + box2.getLength() + ". Width: " + box2.getWidth());
//        System.out.println("Perimeter: " + box2.getPerimeter() + ". Area: " + box2.getArea());

        Measurable myShape = new Rectangle(4, 5);
//        Measurable myShape = new Square(5);


        Quadrilateral theirShape = new Rectangle(3,4);

//        System.out.println(myShape.getArea()); // should expect 20 for rectangle
//        System.out.println(myShape.getPerimeter()); // should expect 18 for rectangle

        System.out.println(myShape.getArea()); // should expect 25 for square
        System.out.println(myShape.getPerimeter()); // should expect 20 for square

        System.out.println(theirShape.getLength());
        System.out.println(theirShape.getWidth());
    }

    // TODO: Why does the code fail to complile if you leave off the getPerimeter method in Rectangle?

    // Because it's defined in the Measurable interface and is an abstract method, its required in
    // Rectangle to show it's implementation.

    //TODO: What happens if you try to call the getLength or getWidth methods of the myShape variable? Why?

    // The getters should only be accessible in Quadrilateral because that is where they are defined. Therefore,
    // if we wanted to use these methods we would need to reference the Quadrilateral type.

}
