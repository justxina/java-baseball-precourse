package baseball;

import baseball.controller.GameController;
import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game);

        gameController.start();

        while (true) {
            gameController.inning();
            System.out.println("게임을 또 할래요? 하고싶으면 'Y'를 입력해요.");
            boolean isRestart = Console.readLine().matches("[yY]");
            if (!isRestart) {
                System.out.println("굿바이");
                break;
            }
        }
    }
}
