package com.bemccandless.apollomissions.gamestate;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "game_state")
public class GameState {

    @Id
    private Long id;
    private String sessionCode = RandomStringUtils.randomAlphanumeric(8);

}
