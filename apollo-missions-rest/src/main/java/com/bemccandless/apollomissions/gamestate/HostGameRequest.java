package com.bemccandless.apollomissions.gamestate;

import com.bemccandless.apollomissions.player.PlayerType;
import lombok.Data;

@Data
public class HostGameRequest {

    private Integer playerLimit;
    private String playerName;
    private PlayerType playerType;

}
