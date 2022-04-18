package baseball.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class Referee {

    public Referee() {}

    public String callSign(
        LinkedHashSet<Integer> strikeZone,
        Balls balls
    ) {
        HashMap<BallSign, Integer> calls = this.call(
            new ArrayList<>(strikeZone),
            balls.getBalls()
        );

        return this.getCallSignByCalls(
            calls.get(BallSign.STRIKE),
            calls.get(BallSign.BALL),
            calls.get(BallSign.FOUL)
        );
    }

    private String getCallSignByCalls(Integer strikeCount, Integer ballCount,
        Integer foulCount) {
        if (Objects.equals(foulCount, Game.STRIKE_ZONE_LENGTH)) {
            return "낫싱";
        }
        if (strikeCount == 0) {
            return ballCount + BallSign.BALL.getName();
        }
        if (ballCount == 0) {
            return strikeCount + BallSign.STRIKE.getName();
        }
        return ballCount + BallSign.BALL.getName() + " " + strikeCount + BallSign.STRIKE.getName();
    }

    private HashMap<BallSign, Integer> call(List<Integer> strikeZone, List<Integer> balls) {
        HashMap<BallSign, Integer> call = new HashMap<BallSign, Integer>();

        for (BallSign sign : BallSign.values()) {
            call.put(sign, 0);
        }

        for (int i = 0; i < balls.size(); i++) {
            Ball ball = new Ball(i, balls.get(i));
            BallSign sign = ball.getSign(strikeZone);
            call.put(sign, call.get(sign) + 1);
        }

        return call;
    }

}
