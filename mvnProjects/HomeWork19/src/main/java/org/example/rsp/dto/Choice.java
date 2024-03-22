package org.example.rsp.dto;

import static org.example.rsp.Run.rb;

public enum Choice {
    ROCK,
    SCISSORS,
    PAPER;

    @Override
    public String toString() {
        return rb.getString("choice."+this.name().toLowerCase());
    }
}
