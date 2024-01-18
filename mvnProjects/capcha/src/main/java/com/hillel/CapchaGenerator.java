package com.hillel;

import lombok.*;

@AllArgsConstructor
public class CapchaGenerator {
    @NonNull
    private final String number;
    @NonNull
    private final Style style;

    public void validate() {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Specified data is not a number");
        }
    }

    public String build() {

        StringBuilder[] lines = new StringBuilder[style.getHeight()];
        for (String letter : number.split("")) {
            String[] letterDrawing = style.getDrawing(letter);
            for (int i = 0; i < style.getHeight(); i++) {
                if (lines[i] == null)
                    lines[i] = new StringBuilder();
                lines[i].append(letterDrawing[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < style.getHeight(); i++)
            sb.append(lines[i]).append("\n");

        return sb.toString();
    }
}
