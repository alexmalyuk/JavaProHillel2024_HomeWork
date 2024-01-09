package homework.homework11;

import java.util.*;

public class Main {

    public record Ocurence(String name, int count) {
    }

    public static void main(String[] args) {
        Main main = new Main();

        List<String> wordsList = List.of(
                "Фільм",
                "Режисер",
                "Сценарій",
                "Актор",
                "Сюжет",
                "Кінематографія",
                "Кадр",
                "Прем'єра",
                "Спецефекти",
                "Костюми",
                "Музика",
                "Сюжет",
                "Оскар",
                "Кінотеатр",
                "Глядач",
                "Комедія",
                "Драма",
                "Екран",
                "Сюжет",
                "Фільм");
        System.out.println(main.countOccurance(wordsList, "Фільм"));

        //
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 5, 4, 3, 0};
        String[] strArray = {"qw", "er", "ty"};
        System.out.println(main.toList(intArray));
        System.out.println(main.toList(strArray));

        //
        List<Integer> integers = List.of(123, 456, 789, 980, 456, 123, 987, 789, 456);
        System.out.println(integers);
        List<Integer> unique = main.findUnique(integers);
        System.out.println(unique);

        //
        main.calcOccurance(wordsList);

        //
        var duplicateList = main.findOccurance(wordsList);
        for (Ocurence d : duplicateList)
            System.out.println(d);
    }

    public int countOccurance(List<String> list, String str) {
        int count = 0;
        for (String s : list)
            if (Objects.equals(s, str))
                count++;
        return count;
    }

    public List<Object> toList(Object[] array) {
        List<Object> list = new ArrayList<>();
        for (Object element : array)
            list.add(element);
        return list;
    }

    public List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniq = new ArrayList<>();
        for (Integer element : list)
            if (!uniq.contains(element))
                uniq.add(element);
        return uniq;
    }

    public void calcOccurance(List<String> wordsList) {
        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word : wordsList) {
            Integer count = wordsCount.getOrDefault(word, 0);
            wordsCount.put(word, ++count);
        }
        wordsCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    public List<Ocurence> findOccurance(List<String> wordsList) {
        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word : wordsList)
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);

        List<Ocurence> ocurences = new ArrayList<>();
        wordsCount.forEach((word, count) -> ocurences.add(new Ocurence(word, count)));
        return ocurences;
    }
}
