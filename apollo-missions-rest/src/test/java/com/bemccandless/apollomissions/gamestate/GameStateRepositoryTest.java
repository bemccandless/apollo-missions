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

        GameState result = instance.save(gameState);

        System.out.println("id=" + result.getId());
        System.out.println("sessionCode=" + result.getSessionCode());

        assertNotNull(result);
        assertNotNull(result.getId());
    }
}
