package baseball.model;

import java.util.List;

public class Ball {

    private final Integer position;
    private final Integer number;

    public Ball(Integer position, Integer number) {
        this.position = position;
        this.number = number;
    }

    public BallSign getSign(List<Integer> strikeZone) {
        if (strikeZone.get(this.position).equals(this.number))
            return BallSign.STRIKE;
        if (strikeZone.contains(this.number))
            return BallSign.BALL;
        return BallSign.FOUL;
    }
}
