package com.bemccandless.apollomissions.player;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PlayerType {
    FLIGHT_INSTRUCTOR("Flight Controller"), ASTRONAUT("Astronaut");

    private final String displayName;

    PlayerType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.displayName;
    }
}
