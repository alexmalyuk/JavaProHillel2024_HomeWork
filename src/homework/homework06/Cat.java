package homework.homework06;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
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
