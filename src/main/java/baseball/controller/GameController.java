package baseball.controller;

import baseball.model.BallSign;
import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashSet;

public class GameController {

    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void start() {
        this.game.start();
        System.out.println("숫자 야구 게임을 시작해요.");

    }

    public void inning() {
        while (true) {
            System.out.println("1~9 사이의 서로 다른 3자리의 임의의 수를 입력하여, 공을 던져요.");
            String params = Console.readLine();
            LinkedHashSet<Integer> balls = this.convert(params);
            this.validate(balls);

            String callSign = this.game.inning(balls);
            System.out.println(callSign);

            if (callSign.equals(Game.STRIKE_ZONE_LENGTH.toString() + BallSign.STRIKE.getName())) {
                break;
            }
        }
    }

    private LinkedHashSet<Integer> convert(String params) {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>();
        for (String str: params.split("")) {
            balls.add(this.convertStringToInt(str));
        }
        return balls;
    }

    private Integer convertStringToInt(String ballStr) {
        try {
            return Integer.parseInt(ballStr);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(LinkedHashSet<Integer> balls) {
        for (int ball: balls) {
            this.checkRange(ball);
        }
    }

    private void checkRange(int ball) {
        if (ball < Game.STRIKE_ZONE_MINIMUM || ball > Game.STRIKE_ZONE_MAXIMUM)
            throw new IllegalArgumentException();
    }

}
