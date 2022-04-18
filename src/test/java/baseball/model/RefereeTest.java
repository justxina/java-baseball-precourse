package baseball.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RefereeTest {

    private Referee referee;
    private final LinkedHashSet<Integer> strikeZone = new LinkedHashSet<>(Arrays.asList(1, 3, 5));

    @BeforeEach
    public void beforeEach() {
        this.referee = new Referee();
    }

    @Test
    void 콜사인_볼앤스트라이크() {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>(Arrays.asList(1, 5, 9));

        assertEquals(this.referee.callSign(this.strikeZone, balls), "1볼 1스트라이크");
    }

    @Test
    void 콜사인_스트라이크() {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>(Arrays.asList(1, 3, 9));
        assertEquals(this.referee.callSign(this.strikeZone, balls), "2스트라이크");
    }

    @Test
    void 콜사인_볼() {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>(Arrays.asList(3, 5, 1));
        assertEquals(this.referee.callSign(this.strikeZone, balls), "3볼");
    }

    @Test
    void 콜사인_낫싱() {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>(Arrays.asList(2, 4, 8));
        assertEquals(this.referee.callSign(this.strikeZone, balls), "낫싱");
    }

}
