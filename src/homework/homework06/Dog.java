package homework.homework06;

public class Dog extends Animal {
    private static int totalDogs = 0;
    public static  int getTotalDogs() {
        return totalDogs;
    }

    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    @Override
    public void run(int length) {
        if (length <= 500) {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            super.swim(length);
        }
    }
}
