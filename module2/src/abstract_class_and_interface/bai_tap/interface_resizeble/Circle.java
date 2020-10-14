package abstract_class_and_interface.bai_tap.interface_resizeble;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;
    private String color ="greed";
    private boolean filled= false;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.color=color;
        this.filled= filled;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                +", the Area=" + getArea()
                +", the Perimeter=" + getPerimeter()
                + ", which is a subclass of "

                + super.toString();
    }
    @Override
    public void resize(double percent) {
        this.radius += (percent / 100);
    }

}
