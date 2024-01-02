package homework.homework10;

public class Main {
    public static void main(String[] args) {

/*
        DynamicArray myArray = new DynamicArray();
        for (int i = 0; i < 25; i++)
            myArray.add(Integer.toString(i));
        System.out.println(myArray);

        while (myArray.size() > 0)
            myArray.delete(myArray.get(0));
        //myArray.clear();

        System.out.println(myArray);
*/

        DynamicArray myArray = new DynamicArray();
        System.out.println(myArray.add("1111"));
        System.out.println(myArray.add("2222"));
        System.out.println(myArray.add("3333"));
        System.out.println(myArray.add(null));
        System.out.println(myArray.add("4444"));
        System.out.println(myArray.add(""));
        System.out.println(myArray.add("5555"));
        System.out.println(myArray);

        System.out.println(myArray.delete("3333"));
        System.out.println(myArray);

        System.out.println(myArray.add(0, "****"));
        System.out.println(myArray.add("****"));
        System.out.println(myArray);

        System.out.println(myArray.delete("****"));
        System.out.println(myArray.delete("*-*-*"));
        System.out.println(myArray);

        System.out.println(myArray.get(3));
        System.out.println(myArray.contains("2"));
        System.out.println(myArray.contains(null));
        System.out.println(myArray.contains("2222"));

        DynamicArray myDynamicArray2 = new DynamicArray();
        System.out.println(myDynamicArray2.add("0000"));
        System.out.println(myDynamicArray2.add("1111"));
        System.out.println(myDynamicArray2.add("2222"));
        System.out.println(myDynamicArray2.add("****"));
        System.out.println(myDynamicArray2);

        System.out.println(myArray.equals(myDynamicArray2));

        System.out.println(myDynamicArray2.clear());
        System.out.println(myDynamicArray2);
    }
}
