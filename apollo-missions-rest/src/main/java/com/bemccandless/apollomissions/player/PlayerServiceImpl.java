package com.bemccandless.apollomissions.player;

import com.bemccandless.apollomissions.sequence.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private static final String SEQUENCE_NAME = "player_sequence";

    private final PlayerRepository playerRepository;
    private final SequenceGeneratorService sequenceGenerator;

    @Override
    public Player save(Player player) {
        if (player.getId() == null) {
            player.setId(sequenceGenerator.getSequenceNumber(SEQUENCE_NAME));
        }

        return playerRepository.save(player);
    }
}
