package org.example.rsp.services;

import org.example.rsp.dto.Choice;

import java.util.Random;

public class ChoiceService {
    public Choice getRandomChoice(){
        return Choice.values()[new Random().nextInt(Choice.values().length)];
    }

}
