package baseball;

import baseball.controller.GameController;
import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game);

        while (true) {
            gameController.start();
            gameController.innings();

            System.out.println("게임이 끝났어요. 게임을 또 할래요? 하고 싶으면 'Y'를 입력해요.");
            boolean isEnd = !(Console.readLine().matches("[yY]"));

            if (isEnd) {
                System.out.println("굿바이! 다음에 또 만나요. :)");
                break;
            }
        }
    }
}
