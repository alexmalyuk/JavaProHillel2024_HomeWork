package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    record Pair (String s, String sUpper){
    }

    public Double AverageOfInt(List<Integer> source) {
        return source.stream()
                .collect(Collectors.averagingDouble(Integer::intValue));
    }

    public List<Pair> createUpperList(List<String> source) {
        return source.stream()
                .map(str -> new Pair(str, str.toUpperCase()))
                .toList();
    }

    public List<String> filter(List<String> source) {
        return source.stream()
                .filter(str -> str.equals(str.toLowerCase()) && str.length() == 4)
                .toList();
    }

}

