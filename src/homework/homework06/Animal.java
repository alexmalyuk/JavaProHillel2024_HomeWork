package homework.homework06;

public abstract class Animal {
    private String name;

    private static int totalAnimals = 0;
    public static int getTotalAnimals(){
        return totalAnimals;
    }

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int length) {
        System.out.println(name + " пробіг " + length + " м");
    }

    public void swim(int length) {
        System.out.println(name + " проплив " + length + " м");
    }
}
