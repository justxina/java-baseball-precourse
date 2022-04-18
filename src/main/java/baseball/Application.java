package baseball;

import baseball.model.Game;
import java.util.LinkedHashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.start();

        LinkedHashSet<Integer> balls = new LinkedHashSet<Integer>();
        balls.add(1);
        balls.add(3);
        balls.add(5);

        game.inning(balls);
    }
}
