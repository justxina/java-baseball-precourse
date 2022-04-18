package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;

    @BeforeEach
    public void beforeEach() {
        game = new Game();
        game.start();
    }

    @Test
    @DisplayName("스트라이크 존이 게임의 룰에 알맞게 생성되었는가")
    void 스트라이크존_생성() {
        assertThat(game.getStrikeZone().size()).isEqualTo(Game.STRIKE_ZONE_LENGTH);

        for (Integer integer : game.getStrikeZone()) {
            assertThat(integer).isGreaterThanOrEqualTo(Game.STRIKE_ZONE_MINIMUM);
            assertThat(integer).isLessThanOrEqualTo(Game.STRIKE_ZONE_MAXIMUM);
        }
    }

}
