package com.bemccandless.apollomissions.gamestate;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameStateRepository extends MongoRepository<GameState, Long> {
}
