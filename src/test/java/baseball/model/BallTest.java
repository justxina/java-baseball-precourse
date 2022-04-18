package baseball.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BallTest {

    private Ball ball;
    private final List<Integer> strikeZone = Arrays.asList(1, 3, 2);


    @Test
    void 콜사인_스트라이크() {
        ball = new Ball(0, 1);
        assertEquals(ball.getSign(this.strikeZone), BallSign.STRIKE);
    }

    @Test
    void 콜사인_볼() {
        ball = new Ball(1, 2);
        assertEquals(ball.getSign(this.strikeZone), BallSign.BALL);
    }

    @Test
    void 콜사인_파울() {
        ball = new Ball(1, 7);
        assertEquals(ball.getSign(this.strikeZone), BallSign.FOUL);
    }
}
