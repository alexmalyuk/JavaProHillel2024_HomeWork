package homework.homework09;

public class Main {
    public static void main(String[] args) {
        DynamicArray myArray = new DynamicArray();

        myArray.add("0000");
        myArray.add("1111");
        myArray.add("4444");
        myArray.add("4444");
        myArray.add("2222");
        myArray.add("3333");
        myArray.add("4444");
        myArray.add("6666");
        System.out.println(myArray);

//        myArray.add(5, "5555");
//        System.out.println(myArray);
//
//        myArray.add(2, "****");
//        System.out.println(myArray);
//
//        myArray.delete(0);
//        System.out.println(myArray);
//
//        myArray.delete("1234");
        myArray.delete("4444");
        System.out.println(myArray);
//
//        System.out.println(myArray.get(3));
//        System.out.println(myArray.Length());
//
//        for (int i = 0; i < 100; i++)
//            myArray.add(String.valueOf(i));
//        System.out.println(myArray);
    }
}
