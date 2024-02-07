package org.example.rsp.services;

import org.example.rsp.dto.Choice;
import org.example.rsp.dto.GameResult;

import java.util.Map;

public class GameService {

    private Map<Choice, Map<Choice, GameResult>> resultMap = Map.of(

            Choice.ROCK,
            Map.of(Choice.ROCK, GameResult.TIE,
                    Choice.SCISSORS, GameResult.WIN,
                    Choice.PAPER, GameResult.LOSE),

            Choice.SCISSORS,
            Map.of(Choice.ROCK, GameResult.LOSE,
                    Choice.SCISSORS, GameResult.TIE,
                    Choice.PAPER, GameResult.WIN),

            Choice.PAPER,
            Map.of(Choice.ROCK, GameResult.WIN,
                    Choice.SCISSORS, GameResult.LOSE,
                    Choice.PAPER, GameResult.TIE)
    );

    public GameResult takeResult(Choice userChoice, Choice opponentChoice) {
        return resultMap.get(userChoice).get(opponentChoice);
    }

}
