package homework.homework07.figures;

public class Triangle implements Figure {
    private float size;

    public Triangle(float size) {
        this.size = size;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) / 4 * size * size;
    }
}
