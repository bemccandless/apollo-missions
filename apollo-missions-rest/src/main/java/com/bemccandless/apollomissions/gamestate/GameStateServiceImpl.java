package com.bemccandless.apollomissions.gamestate;

import com.bemccandless.apollomissions.sequence.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameStateServiceImpl implements GameStateService {
    private static final String SEQUENCE_NAME = "game_state_sequence";

    private final GameStateRepository gameStateRepository;
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public GameState save(final GameState gameState) {
        if (gameState.getId() == null) {
            gameState.setId(sequenceGenerator.getSequenceNumber(SEQUENCE_NAME));
        }

        return gameStateRepository.save(gameState);
    }
}
