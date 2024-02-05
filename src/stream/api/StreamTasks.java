package stream.api;


import java.sql.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTasks {
    public static void main(String[] args) {

//        1. Преобразование в коллекцию:
//        Создай поток из списка чисел.
//        Преобразуй его в коллекцию типа Set и верни результат.
        System.out.println(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1).stream().collect(Collectors.toSet()));

//        2. Фильтрация и сортировка строк:
//        Создай поток из списка строк.
//        Отфильтруй строки, содержащие букву "Java", и отсортируй их по длине.
        var stringList = List.of("Java SE", "Server", "Java Script", "Client");
        stringList.stream()
                .filter(e -> e.contains("Java"))
                .sorted(Comparator.comparing(String::length))
                .toList()
                .forEach(System.out::println);

//        3. Конвертация в массив строк:
//        Создай поток из списка строк.
//        Преобразуй его в массив строк.
        String[] arr = List.of("one", "two", "three")
                .stream()
                //.toArray(e-> new String[0]);
                .toArray(String[]::new);
        System.out.println(arr.toString());

//        4. Группировка по длине строки:
//        Создай поток из списка строк.
//                Сгруппируй строки по их длине и верни карту.
        String text = "Группировка по длине строки Создай поток из списка строк.Сгруппируй строки по их длине и верни карту";
        List<String> wordsList = Arrays.asList(text.split("\\s+"));
        wordsList.stream()
                .collect(Collectors.groupingBy(String::length))
                .forEach((length, words) -> System.out.println(length + " " + words));

//        5. Объединение и фильтрация чисел:
//        Создай два потока из двух разных списков чисел.
//        Объедини их и оставь только уникальные числа.
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);

        Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .forEach(System.out::println);

//        6. Фильтрация и преобразование объектов:
//        Создай поток из списка объектов Animal (с полями имя и возраст).
//        Отфильтруй только тех животных, возраст которых больше 3 лет, и преобразуй их в список имен.
        class Animal {
            public int age;
            public String name;

            public Animal(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        List<Animal> animals = List.of(
                new Animal("Cat", 5),
                new Animal("Dog", 3),
                new Animal("Fish", 15),
                new Animal("Fly", 5)
        );
        animals.stream()
                .filter(e -> e.age > 3)
                .map(e -> e.name)
                .toList()
                .forEach(System.out::println);

//        7. Объединение и фильтрация строк:
//        Создай два потока из двух разных списков строк.
//        Объедини их и оставь только те строки, которые содержат букву "A".
        String text1 = "Создай два потока из двух разных списков строк.";
        List<String> wordsList1 = Arrays.asList(text1.split("\\s+"));
        String text2 = "Объедини их и оставь только те строки, которые содержат букву A.";
        List<String> wordsList2 = Arrays.asList(text2.split("\\s+"));
        Stream.concat(wordsList1.stream(), wordsList2.stream())
                .filter(s -> s.toLowerCase().contains("а"))
                .forEach(System.out::println);

//        8. Сортировка чисел в обратном порядке:
//        Создай поток из списка чисел.
//                Отсортируй его в обратном порядке.
        List.of(3, 6, 5, 7, 8, 9, 0, 4, 3).stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

//        9. Преобразование в строку с разделителем:
//        Создай поток из списка объектов City (с полями название и страна).
//        Преобразуй их в одну строку, разделяя названия городов запятой.
        class City {
            public String name;
            public String country;

            public City(String name, String country) {
                this.name = name;
                this.country = country;
            }
        }
        String s = List.of(
                        new City("Kyiv", "Ukraine"),
                        new City("Washington", "USA"),
                        new City("Rome", "Italy"),
                        new City("Paris", "France")
                ).stream()
                .map(e -> e.name)
                .collect(Collectors.joining(", ", "<", "> "));
        System.out.println(s);

//        10. Фильтрация объектов и преобразование в Map:
//        Создай поток из списка объектов Product (с полями название, цена и категория).
//        Отфильтруй продукты с ценой больше 100 и преобразуй их в карту, где ключ - название, а значение - категория.
        class Product {
            public String name;
            public int price;
            public String category;

            public String getName() {
                return name;
            }

            public int getPrice() {
                return price;
            }

            public String getCategory() {
                return category;
            }

            @Override
            public String toString() {
                return "Product{" +
                        "name='" + name + '\'' +
                        ", price=" + price +
                        ", category='" + category + '\'' +
                        '}';
            }

            public Product(String name, int price, String categore) {
                this.name = name;
                this.price = price;
                this.category = categore;
            }
        }
        List.of(
                        new Product("Water", 101, "Food"),
                        new Product("Sweets", 10, "Food"),
                        new Product("Tshirt", 150, "Clothes"),
                        new Product("Pants", 200, "Clothes")
                ).stream()
                .filter(p -> p.price > 100)
                .collect(Collectors.toMap(p -> p.name, p -> p.category))
                .entrySet()
                .forEach(entry -> System.out.println(entry));

//        11.Пропуск и суммирование чисел:
//        Создай поток из списка чисел.
//        Пропусти первые 2 числа и сложи оставшиеся.
        int sum = List.of(1, 2, 3, 4, 5, 6).stream()
                .skip(2)
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);

//        12.Фильтрация и преобразование в строку:
//        Создай поток из списка объектов Person (с полями имя, возраст и пол).
//        Оставь только женщин старше 25 лет и преобразуй их в строку вида "Имя (возраст)"
        class Person {
            public enum Sex {
                MALE,
                FEMALE
            }

            public String name;
            public int age;
            public Sex sex;

            public Person(String name, int age, Sex sex) {
                this.name = name;
                this.age = age;
                this.sex = sex;
            }
        }
        String s1 = List.of(
                        new Person("Steve", 56, Person.Sex.MALE),
                        new Person("Donald", 86, Person.Sex.MALE),
                        new Person("Judit", 26, Person.Sex.FEMALE),
                        new Person("Iren", 30, Person.Sex.FEMALE)
                ).stream()
                .filter(p -> p.age > 25 && p.sex == Person.Sex.FEMALE)
                .map(p -> p.name + " (" + p.age + ")")
                .collect(Collectors.joining(", "));
        System.out.println(s1);

//        13.Группировка по первой букве:
//        Создай поток из списка слов.
//                Сгруппируй их по первой букве и верни карту.
        String text3 = "13.Группировка по первой букве: Создай поток из списка слов. Сгруппируй их по первой букве и верни карту.";
        Arrays.stream(text3.split("\\s+"))
                .collect(Collectors.groupingBy(word -> word.charAt(0)))
                .entrySet()
                .forEach(entr -> System.out.println(entr));

//        14.Фильтрация и подсчет элементов:
//        Создай поток из списка строк.
//                Оставь только строки, содержащие слово "Stream", и подсчитай их количество.
        String text4 = "Фильтрация и подсчет элементов Stream: Создай поток из списка строк. Оставь только строки, содержащие слово Stream, и подсчитай их количество.";
        var count = Arrays.stream(text4.split("\\."))
                .filter(sent -> sent.contains("Stream"))
                .count();
        System.out.println(count);

//        15.Преобразование в набор уникальных символов:
//        Создай поток из списка строк.
//                Преобразуй каждую строку в набор уникальных символов.
        System.out.println("------");
        String text15 = "15.Преобразование в набор уникальных символов.Создай поток из списка строк.Преобразуй каждую строку в набор уникальных символов.";
        Arrays.stream(text15.split("\\."))
                .map(string -> Arrays.stream(string.split(""))
                        .collect(Collectors.toSet())
                        .stream()
                        .collect(Collectors.joining("", "", "")))
                .forEach(System.out::println);

//        16.Фильтрация и ограничение чисел:
//        Создай поток из списка чисел.
//                Оставь только положительные числа и верни первые 4.
        System.out.println("------");
        List.of(3, -5, 6, -8, -3, 8, -90, 7, 8, -54, -9, 78, -99)
                .stream()
                .filter(i -> i > 0)
                .limit(4)
                .forEach(System.out::println);

//        17.Генерация случайных чисел:
//        Создай поток, который генерирует 5 случайных чисел от 1 до 100.
        System.out.println("------");
        var random = new Random();
        random.ints(1, 100)
                .limit(5)
                .forEach(System.out::println);

//        18.Фильтрация и преобразование объектов:
//        Создай поток из списка объектов Movie (с полями название и рейтинг).
//        Оставь только те фильмы, у которых рейтинг выше 8.

//
//        19.Преобразование в Map с подсчетом:
//        Создай поток из списка слов.
//        Преобразуй его в карту, где ключ - слово, а значение - количество раз, которое это слово встречается в списке.
        System.out.println("------");
        String text19 = "Создай поток из списка слов Создай поток из списка слов дважды";
        var collect = Arrays.stream(text19.split("\\s+"))
                .collect(Collectors.groupingBy(w -> w))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()
                        .stream()
                        .count()));
        System.out.println(collect);
//
//        20.Фильтрация и преобразование объектов:
//        Создай поток из списка объектов Product (с полями название и цена).
//        Оставь только те продукты, у которых цена меньше 50, и преобразуй их в список названий.
//
//        21.Объединение и фильтрация объектов:
//        Создай два потока из двух разных списков объектов Employee (с полями имя, возраст и должность).
//                Объедини их и оставь только тех сотрудников, у которых должность "Разработчик".
//
//        22.Преобразование в Map с фильтрацией:
//        Создай поток из списка объектов Customer (с полями имя, возраст и активен).
//        Преобразуй его в карту, где ключ - имя, а значение - возраст, только для активных клиентов.
//
//        23.Фильтрация и суммирование чисел:
//        Создай поток из списка чисел.
//                Оставь только четные числа и сложи их.
        System.out.println("------");
        Predicate<Integer> isOdd = num -> num % 2 == 0;
        var sum1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .filter(isOdd)
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum1);

//        24.Объединение и фильтрация строк:
//        Создай два потока из двух разных списков строк.
//        Объедини их и оставь только строки, длина которых не превышает 10 символов.
//
//        25.Преобразование в Set:
//        Создай поток из списка слов.
//                Преобразуй его в множество (Set).
//
//        26.Фильтрация и преобразование в верхний регистр:
//        Создай поток из списка строк.
//                Оставь только те строки, которые содержат букву "B", и преобразуй их в верхний регистр.
        System.out.println("------");
        String text26 = "26.Фильтрация и преобразование в верхний регистр: Создай поток из списка строк. Оставь только те строки, которые содержат букву B, и преобразуй их в верхний регистр.";
        Arrays.stream(text26.split("\\s+"))
                .filter(s2 -> s2.toLowerCase().contains("в"))
                .map(s3 -> s3.toUpperCase())
                .forEach(System.out::println);

//        27.Сортировка объектов по нескольким полям:
//        Создай поток из списка объектов Product (с полями название, цена и категория).
//        Отсортируй их сначала по категории, а затем по цене в порядке убывания.
        System.out.println("------");
        List.of(
                new Product("Water", 101, "Food"),
                new Product("Sweets", 10, "Food"),
                new Product("Tshirt", 150, "Clothes"),
                new Product("Pants", 200, "Clothes")
        ).stream()
                .sorted(Comparator.comparing(Product::getCategory).reversed()
                        .thenComparing(Comparator.comparing(Product::getPrice)))
                .forEach(System.out::println);
//
//        28.Фильтрация и проверка условия:
//        Создай поток из списка чисел.
//                Оставь только те числа, которые делятся и на 3, и на 5.
//
//        29.Преобразование в строку и фильтрация:
//        Создай поток из списка объектов City (с полями название и страна).
//        Преобразуй их в строку, содержащую только города из определенной страны.
//
//        30.Группировка и подсчет элементов:
//        Создай поток из списка объектов Product (с полями название и категория).
//        Сгруппируй их по категории и подсчитай количество продуктов в каждой категории.
        System.out.println("------");
        List.of(
                new Product("Water", 101, "Food"),
                new Product("Sweets", 10, "Food"),
                new Product("Tshirt", 150, "Clothes"),
                new Product("Pants", 200, "Clothes")
        ).stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()))
                .entrySet()
                .forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));

    }
}
