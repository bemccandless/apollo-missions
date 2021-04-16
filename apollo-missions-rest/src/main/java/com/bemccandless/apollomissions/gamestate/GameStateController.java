package com.bemccandless.apollomissions.gamestate;

import com.bemccandless.apollomissions.player.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game-setup")
@RequiredArgsConstructor
public class GameStateController {

    private final GameStateService gameStateService;

    @PostMapping
    public GameState hostGame(@RequestBody HostGameRequest hostGameRequest) {
        GameState newGame = new GameState();
        newGame.addPlayer(Player.builder()
                .name(hostGameRequest.getPlayerName())
                .type(hostGameRequest.getPlayerType())
                .build());
        newGame.setPlayerLimit(hostGameRequest.getPlayerLimit());

        return gameStateService.save(newGame);
    }
}
