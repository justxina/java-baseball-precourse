package baseball;

import baseball.controller.GameController;
import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game = new Game();
        GameController gameController = new GameController(game);

        gameController.start();

        while (true) {
            gameController.startInning();
            String balls = Console.readLine();
            gameController.endInning(balls);
            break;
        }
    }
}
