package baseball.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball ball;
    private final List<Integer> strikeZone = Arrays.asList(1, 3, 2);


    @Test
    @DisplayName("위치와 숫자가 모두 일치할 때, 스트라이크를 반환하는가")
    void 콜사인_스트라이크() {
        ball = new Ball(0, 1);
        assertThat(ball.getSign(this.strikeZone)).isEqualTo(BallSign.STRIKE);
    }

    @Test
    @DisplayName("위치는 다르지만 일치하는 숫자가 있을 때, 볼을 반환하는가")
    void 콜사인_볼() {
        ball = new Ball(1, 2);
        assertThat(ball.getSign(this.strikeZone)).isEqualTo(BallSign.BALL);
    }

    @Test
    @DisplayName("일치하는 숫자가 하나도 없을 때, 파울을 반환하는가")
    void 콜사인_파울() {
        ball = new Ball(1, 7);
        assertThat(ball.getSign(this.strikeZone)).isEqualTo(BallSign.FOUL);
    }
}
