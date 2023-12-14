package homework.homework07.figures;

public class Square implements Figure {
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public double getArea() {
        return size * size;
    }
}
