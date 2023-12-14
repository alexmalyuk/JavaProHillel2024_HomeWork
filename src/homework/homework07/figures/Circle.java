package homework.homework07.figures;

public class Circle implements Figure {

    private long radius;

    public Circle(long radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
