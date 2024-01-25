package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void averageOfIntList() {
        assertEquals(3.5D, new Main().AverageOfInt(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void averageOfIntEmpty() {
        assertEquals(0D, new Main().AverageOfInt(Collections.emptyList()));
    }

    @Test
    void createUpperList() {
        List<String> source = List.of(
                "one",
                "two",
                "mouse");
        List<Pair> expectedList = List.of(
                new Pair("one", "ONE"),
                new Pair("two", "TWO"),
                new Pair("mouse", "MOUSE"));
        assertEquals(expectedList, new Main().createUpperList(source));
    }

    @Test
    void createUpperListEmpty() {
        assertEquals(Collections.emptyList(), new Main().createUpperList(Collections.emptyList()));
    }

    @Test
    void filter() {
        List<String> source = List.of("one", "two", "mouse", "five", "NINE");
        List<String> expectedList = List.of("five");
        assertEquals(expectedList, new Main().filter(source));
    }

    @Test
    void filterEmpty() {
        assertEquals(Collections.emptyList(), new Main().filter(Collections.emptyList()));
    }
}