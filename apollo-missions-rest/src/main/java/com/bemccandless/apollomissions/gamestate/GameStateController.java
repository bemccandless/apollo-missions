package com.bemccandless.apollomissions.gamestate;

import com.bemccandless.apollomissions.player.Player;
import com.bemccandless.apollomissions.player.PlayerService;
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
    private final PlayerService playerService;

    @PostMapping
    public GameState hostGame(@RequestBody HostGameRequest hostGameRequest) {
        Player player = playerService.save(Player.builder()
                .name(hostGameRequest.getPlayerName())
                .type(hostGameRequest.getPlayerType())
                .build());

        GameState newGame = new GameState();
        newGame.addPlayer(player);
        newGame.setPlayerLimit(hostGameRequest.getPlayerLimit());

        return gameStateService.save(newGame);
    }
}
