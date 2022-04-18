package baseball.controller;

import baseball.model.Game;
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

    public void startInning() {
        System.out.println("1~9 사이의 서로 다른 3자리의 임의의 수를 입력하여, 공을 던져요.");
    }

    public String endInning(String params) {
        LinkedHashSet<Integer> balls = new LinkedHashSet<>();
        for (String str: params.split("")) {
            balls.add(this.convertStringToInt(str));
        }
        this.validate(balls);

        return this.game.inning(balls);
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
