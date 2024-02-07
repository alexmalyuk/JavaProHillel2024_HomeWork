package org.example.rsp.services;

import org.example.rsp.dto.Choice;
import org.example.rsp.exceptions.QuitGameException;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ChoiceService {
    public Choice getRandomChoice() {
        return Choice.values()[new Random().nextInt(Choice.values().length)];
    }

    public Choice getUserChoice(Scanner scanner) {
        Map<String, Choice> choiceMap = Map.of("R", Choice.ROCK, "S", Choice.SCISSORS, "P", Choice.PAPER);
        System.out.print("Your turn [R/S/P or Q-quit game]: ");
        while (true) {
            String letterChoice = scanner.nextLine();
            if ("Q".equalsIgnoreCase(letterChoice))
                throw new QuitGameException();
            Choice choice = choiceMap.get(letterChoice.toUpperCase());
            if (choice != null)
                return choice;
        }
    }
}
