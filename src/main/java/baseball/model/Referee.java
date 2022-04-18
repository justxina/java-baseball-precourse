package baseball.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

public class Referee {

    public Referee() {
    }

    public String callSign(
        LinkedHashSet<Integer> strikeZone,
        LinkedHashSet<Integer> balls
    ) {
        List<Integer> strikeZoneList = new ArrayList<>(strikeZone);
        List<Integer> ballList = new ArrayList<>(balls);

        HashMap<BallSign, Integer> judgement = this.judge(strikeZoneList, ballList);

        return this.getCallSignByJudgement(
            judgement.get(BallSign.STRIKE),
            judgement.get(BallSign.BALL),
            judgement.get(BallSign.FOUL)
        );
    }

    private String getCallSignByJudgement(Integer strikeCount, Integer ballCount,
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

    private HashMap<BallSign, Integer> judge(List<Integer> strikeZone, List<Integer> balls) {
        HashMap<BallSign, Integer> judgement = new HashMap<BallSign, Integer>();

        for (BallSign sign : BallSign.values()) {
            judgement.put(sign, 0);
        }

        for (int i = 0; i < balls.size(); i++) {
            Ball ball = new Ball(i, balls.get(i));
            BallSign sign = ball.getSign(strikeZone);
            judgement.put(sign, judgement.get(sign) + 1);
        }

        return judgement;
    }

}
