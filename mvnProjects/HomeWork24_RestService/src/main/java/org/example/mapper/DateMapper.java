package org.example.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateMapper {
    public static LocalDate convertDateFromString(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, formatter);
    }

    public static String convertDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}
