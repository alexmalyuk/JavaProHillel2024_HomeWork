package homework.homework06;

public abstract class Animal {
    private String name;

    private static int count = 0;
    public static int getCount(){
        return count;
    }

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int length) {
        System.out.println(name + " пробіг " + length + " м");
    }

    public void swim(int length) {
        System.out.println(name + " проплив " + length + " м");
    }
}
