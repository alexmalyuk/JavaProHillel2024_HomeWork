package homework.homework06;

public class Cat extends Animal {
    private static int totalCats=0;
    public static int getTotalCats() {
        return totalCats;
    }

    public Cat(String name) {
        super(name);
        totalCats++;
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кіт не вміє плавати");
    }
}
