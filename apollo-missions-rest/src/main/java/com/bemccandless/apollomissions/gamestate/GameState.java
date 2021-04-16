package com.bemccandless.apollomissions.gamestate;

import com.bemccandless.apollomissions.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "game_state")
public class GameState {

    @Id
    private Long id;

    @Builder.Default
    @Field("session_code")
    private String sessionCode = RandomStringUtils.randomAlphanumeric(8).toUpperCase();

    @Field("player_limit")
    private Integer playerLimit;

    @Builder.Default
    private List<Player> players = new ArrayList<>();

    private boolean started;

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
