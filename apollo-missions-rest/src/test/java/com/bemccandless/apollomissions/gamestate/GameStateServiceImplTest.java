package com.bemccandless.apollomissions.gamestate;

import com.bemccandless.apollomissions.sequence.SequenceGeneratorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameStateServiceImplTest {

    @InjectMocks
    private GameStateServiceImpl instance;

    @Mock
    private SequenceGeneratorService sequenceGeneratorService;
    @Mock
    private GameStateRepository gameStateRepository;

    @Nested
    class Save {

        @Test
        @DisplayName("Should generate a new Id when Id is null")
        void save_Id_Null() {
            doReturn(1L).when(sequenceGeneratorService).getSequenceNumber("game_state_sequence");
            doAnswer(returnsFirstArg()).when(gameStateRepository).save(any());

            GameState result = instance.save(new GameState());
            verify(sequenceGeneratorService).getSequenceNumber("game_state_sequence");
            verify(gameStateRepository).save(any());

            assertNotNull(result);
            assertAll(
                    () -> assertEquals(1L, result.getId()),
                    () -> assertNotNull(result.getSessionCode())
            );
        }

        @Test
        @DisplayName("Should save record without modifying the passed in parameter")
        void save_Id_Not_Null() {
            GameState gameState = GameState.builder()
                    .id(1L)
                    .sessionCode("test")
                    .build();

            doAnswer(returnsFirstArg()).when(gameStateRepository).save(any());

            GameState result = instance.save(gameState);
            verify(sequenceGeneratorService, never()).getSequenceNumber(any());
            verify(gameStateRepository).save(gameState);

            assertNotNull(result);
            assertAll(
                    () -> assertEquals(1L, result.getId()),
                    () -> assertEquals("test", result.getSessionCode())
            );
        }
    }
}
