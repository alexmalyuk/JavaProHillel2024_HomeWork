package org.example.rsp.services;

import org.example.rsp.dto.Choice;
import org.example.rsp.dto.GameResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private static Stream<Arguments> paramsGenerator() {
        return Stream.of(
                Arguments.of(Choice.ROCK, Choice.ROCK, GameResult.TIE),
                Arguments.of(Choice.ROCK, Choice.SCISSORS, GameResult.WIN),
                Arguments.of(Choice.ROCK, Choice.PAPER, GameResult.LOSE),
                Arguments.of(Choice.SCISSORS, Choice.ROCK, GameResult.LOSE),
                Arguments.of(Choice.SCISSORS, Choice.SCISSORS, GameResult.TIE),
                Arguments.of(Choice.SCISSORS, Choice.PAPER, GameResult.WIN),
                Arguments.of(Choice.PAPER, Choice.ROCK, GameResult.WIN),
                Arguments.of(Choice.PAPER, Choice.SCISSORS, GameResult.LOSE),
                Arguments.of(Choice.PAPER, Choice.PAPER, GameResult.TIE)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsGenerator")
    void takeResult(Choice userChoice, Choice compChoice, GameResult gameResult) {
        GameService service = new GameService();
        assertEquals(gameResult, service.takeResult(userChoice, compChoice));
    }
}