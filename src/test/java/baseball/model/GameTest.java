package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    public void beforeEach() {
        game = new Game();
        game.start();
    }

    @Test
    void 게임_시작() {
        assertNotEquals(game.getStrikeZone().size(), 0);
    }

    @Test
    void 스트라이크존_생성() {
        assertEquals(game.getStrikeZone().size(), Game.STRIKE_ZONE_LENGTH);

        for (Integer integer : game.getStrikeZone()) {
            assertTrue(
                integer >= Game.STRIKE_ZONE_MINIMUM
                    && integer <= Game.STRIKE_ZONE_MAXIMUM
            );
        }
    }

}
