package baseball.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    private Balls balls;

    @Test
    @DisplayName("입력한 텍스트의 길이와 동일한 길이를 가진 리스트로 변환이 이루어졌는가")
    public void 볼리스트() {
        this.balls = new Balls("456");
        assertThat(this.balls.getBalls().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 텍스트의 값이 숫자로 변환이 이루어졌는가")
    public void 숫자변환() {
        this.balls = new Balls("456");
        List<Integer> balls = this.balls.getBalls();
        assertThat(balls).contains(4);
        assertThat(balls).containsExactly(4, 5, 6);
    }

    @Test
    @DisplayName("중복 값을 가진 텍스트를 입력했을 때 오류를 반환하는가")
    public void 중복제거_유효성검사() {
        assertThatThrownBy(() -> { this.balls = new Balls("223"); })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("적절하지 않은 길이의 텍스트를 입력했을 때 오류를 반환하는가")
    public void 파라미터길이_유효성검사() {
        assertThatThrownBy(() -> { this.balls = new Balls("12244"); })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 텍스트를 입력했을 때 오류를 반환하는가")
    public void 숫자가아닌파라미터_유효성검사() {
        assertThatThrownBy(() -> { this.balls = new Balls("abc"); })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지정된 범위를 벗어나는 값을 가진 텍스트를 입력했을 때 오류를 반환하는가")
    public void 범위_유효성검사() {
        assertThatThrownBy(() -> { this.balls = new Balls("078"); })
            .isInstanceOf(IllegalArgumentException.class);
    }
}
