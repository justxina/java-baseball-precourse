package baseball.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BallsTest {

    private Balls balls;

    @Test
    public void 볼리스트() {
        this.balls = new Balls("456");
        assertEquals(this.balls.getBalls().size(), 3);
        assertEquals(this.balls.getBalls().get(1), 5);
    }

    @Test
    public void 숫자변환() {
        this.balls = new Balls("456");
        List<Integer> balls = this.balls.getBalls();
        assertEquals(balls.get(0), 4);
        assertEquals(balls.get(1), 5);
        assertEquals(balls.get(2), 6);
    }

    @Test
    public void 중복제거_유효성검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.balls = new Balls("223");
        });
    }

    @Test
    public void 파라미터길이_유효성검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.balls = new Balls("12244");
        });
    }

    @Test
    public void 숫자가아닌파라미터_유효성검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.balls = new Balls("abc");
        });
    }

    @Test
    public void 범위_유효성검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.balls = new Balls("078");
        });
    }
}
