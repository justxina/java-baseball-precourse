package baseball.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Balls {
    private LinkedHashSet<Integer> balls;

    public Balls(String params) {
        this.validateParamsLength(params);
        this.convert(params);
        this.validate();
    }

    public List<Integer> getBalls() {
        return new ArrayList<>(this.balls);
    }

    private void convert(String params) {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>();
        for (String str: params.split("")) {
            balls.add(this.convertStringToInt(str));
        }
        this.balls = balls;
    }

    private Integer convertStringToInt(String ballStr) {
        try {
            return Integer.parseInt(ballStr);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateParamsLength(String params) {
        if (params.length() != Game.STRIKE_ZONE_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validate() {
        for (int ball: this.balls) {
            this.checkRange(ball);
        }
        if (this.balls.size() != Game.STRIKE_ZONE_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRange(int ball) {
        if (ball < Game.STRIKE_ZONE_MINIMUM || ball > Game.STRIKE_ZONE_MAXIMUM)
            throw new IllegalArgumentException();
    }
}
