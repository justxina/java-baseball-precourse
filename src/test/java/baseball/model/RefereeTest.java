package baseball.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private Referee referee;
    private final LinkedHashSet<Integer> strikeZone = new LinkedHashSet<>(Arrays.asList(1, 3, 5));

    @BeforeEach
    public void beforeEach() {
        this.referee = new Referee();
    }

    @Test
    @DisplayName("볼과 스트라이크가 섞인 콜사인을 알맞게 주는가")
    void 콜사인_볼앤스트라이크() {
        Balls balls = new Balls("159");
        assertThat(this.referee.callSign(this.strikeZone, balls)).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("스트라이크만 있는 콜사인을 알맞게 주는가")
    void 콜사인_스트라이크() {
        Balls balls = new Balls("139");
        assertThat(this.referee.callSign(this.strikeZone, balls)).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("볼만 있는 콜사인을 알맞게 주는가")
    void 콜사인_볼() {
        Balls balls = new Balls("351");
        assertThat(this.referee.callSign(this.strikeZone, balls)).isEqualTo("3볼");
    }

    @Test
    @DisplayName("스트라이크와 볼 모두 없는 콜사인을 알맞게 주는가")
    void 콜사인_낫싱() {
        Balls balls = new Balls("248");
        assertThat(this.referee.callSign(this.strikeZone, balls)).isEqualTo("낫싱");
    }

}
