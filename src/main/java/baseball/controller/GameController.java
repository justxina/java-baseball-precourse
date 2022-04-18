package baseball.controller;

import baseball.model.BallSign;
import baseball.model.Balls;
import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;

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
            System.out.println("1~9 사이의 서로 다른 수로 이루어진 3자리의 수를 입력하여, 공을 던져요.");
            String params = Console.readLine();
            Balls balls = new Balls(params);

            String callSign = this.game.inning(balls);
            System.out.println(callSign);

            if (callSign.equals(Game.STRIKE_ZONE_LENGTH.toString() + BallSign.STRIKE.getName())) {
                break;
            }
        }
    }



}
