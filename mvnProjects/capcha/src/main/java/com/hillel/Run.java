package com.hillel;

public class Run {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Specify the number as first parameter");
        }
        CapchaGenerator capchaGenerator = new CapchaGenerator(args[0], new Style());
        capchaGenerator.validate();
        System.out.println(capchaGenerator.build());
    }
}