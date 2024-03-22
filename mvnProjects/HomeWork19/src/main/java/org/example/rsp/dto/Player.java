package org.example.rsp.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.rsp.Run.rb;

public class Player {
    private String name;

    private Map<GameResult, Integer> gameResults = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public void addGameResult(GameResult gameResult) {
        gameResults.merge(gameResult, 1, Integer::sum);
    }

    public Map<GameResult, Integer> getGameResults() {
        return gameResults;
    }

    public String getPlayerResult() {
        String scores = gameResults.entrySet()
                .stream()
                .map(Entry -> Entry.getKey() + " " + Entry.getValue())
                .collect(Collectors.joining("\n"));

        return String.format(rb.getString("game.result"), name) + "\n" + scores;
    }
}
