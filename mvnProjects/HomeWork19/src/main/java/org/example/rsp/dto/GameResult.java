package org.example.rsp.dto;

import static org.example.rsp.Run.rb;

public enum GameResult {
    WIN,
    LOSE,
    TIE;

    @Override
    public String toString() {
        return rb.getString("game.result."+this.name().toLowerCase());
    }
}
