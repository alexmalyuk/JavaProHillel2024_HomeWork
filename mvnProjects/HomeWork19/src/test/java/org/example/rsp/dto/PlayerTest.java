package org.example.rsp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void addGameResult() {
        Player player = new Player("***");
        player.addGameResult(GameResult.WIN);
        player.addGameResult(GameResult.WIN);
        player.addGameResult(GameResult.LOSE);
        assertEquals(2, player.getGameResults().get(GameResult.WIN));
        assertEquals(1, player.getGameResults().get(GameResult.LOSE));
    }
}