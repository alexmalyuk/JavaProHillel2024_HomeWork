package homework.homework12;

public class Main {
    public static void main(String[] args) {

        FileNavigator fn = new FileNavigator();
        fn.addPath("d/proj/hw1/src");
        fn.addPath("d/proj/hw1/out");
        fn.addPath("d/proj/hw2/src");
        fn.addPath("d/proj/hw2/out");

        fn.add(new FileData("main.java", 60, "d/proj/hw1/src"));
        fn.add(new FileData("class.java", 14, "d/proj/hw1/src"));
        fn.add(new FileData("file.txt", 85, "d/proj/hw5/src"));
        fn.add(new FileData("file.txt", 85, "d/proj/hw1/src"));
        fn.add(new FileData("myClass.java", 28, "d/proj/hw2/src"));
        fn.add(new FileData("myClass.class", 35, "d/proj/hw2/out"));

        System.out.println(fn);

        System.out.println(fn.find("d/temp"));
        System.out.println(fn.find("d/proj/hw2/out"));

        System.out.println(fn.filterBySize(30));

        fn.remove("ddfdfdf");
        //fn.remove("d/proj/hw1/src");
        System.out.println(fn);

        fn.sortBySize().forEach(System.out::println);
    }
}
