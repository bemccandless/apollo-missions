package com.bemccandless.apollomissions.gamestate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class GameStateRepositoryTest {

    @Autowired
    private GameStateRepository instance;

    @Test
    void save() {
        GameState gameState = new GameState();
        gameState.setId(-1L);

        GameState result = instance.save(gameState);

        assertNotNull(result);
        assertNotNull(result.getId());
    }
}
