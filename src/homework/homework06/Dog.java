package homework.homework06;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
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
