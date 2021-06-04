package shapes;

public class Rectangle {
    protected double length;

    protected double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double length, double width){
        this.setLength(length);
        this.setWidth(width);
    }

    public double getArea(){
//        double area = this.getLength() * this.getWidth();
//        return area;
        return this.getLength() * this.getWidth();
    }

    public double getPerimeter(){
//        double perimeter = (2 * this.getLength() * (2 * this.getWidth()));
//        return perimeter;
        return (2 * this.getLength() + (2 * this.getWidth()));
    }
}
