package homework.homework07.figures;

public class Main {
    public static void main(String[] args) {

        Figure[] figures = new Figure[3];

        figures[0]=new Circle(5);
        figures[1]=new Triangle(5);
        figures[2]=new Square(5);

        System.out.println(getSumArea(figures));
    }

    public static double getSumArea(Figure[] figures){
        double sum=0;
        for (Figure figure:figures) {
            sum+= figure.getArea();
        }
        return sum;
    }
}
