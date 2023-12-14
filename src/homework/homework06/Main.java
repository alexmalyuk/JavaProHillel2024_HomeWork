package homework.homework06;

public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Барсік");
        Animal cat2 = new Cat("Васька");
        Animal dog1 = new Dog("Шарік");
        Animal dog2 = new Dog("Рекс");

        cat1.run(5);
        cat2.run(500);
        cat1.swim(15);
        dog1.run(150);
        dog2.run(501);
        dog1.swim(15);
        dog2.swim(5);

        System.out.println(Animal.getCount());
    }
}
