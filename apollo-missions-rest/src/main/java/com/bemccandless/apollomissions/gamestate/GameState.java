package com.bemccandless.apollomissions.gamestate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private String sessionCode = RandomStringUtils.randomAlphanumeric(8);

}
