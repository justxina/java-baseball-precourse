package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Game {

    static public Integer STRIKE_ZONE_LENGTH = 3;
    static public Integer STRIKE_ZONE_MINIMUM = 1;
    static public Integer STRIKE_ZONE_MAXIMUM = 9;

    private LinkedHashSet<Integer> strikeZone;
    private final Referee referee;


    public Game() {
        this.referee = new Referee();
    }


    public void start() {
        this.generateStrikeZone();
    }

    public List<Integer> getStrikeZone() {
        return new ArrayList<>(this.strikeZone);
    }

    public String inning(Balls balls) {
        return this.referee.callSign(this.strikeZone, balls);
    }

    private void generateStrikeZone() {
        this.strikeZone = new LinkedHashSet<>();
        while (this.strikeZone.size() < STRIKE_ZONE_LENGTH) {
            this.strikeZone.add(pickNumberInRange(STRIKE_ZONE_MINIMUM, STRIKE_ZONE_MAXIMUM));
        }
    }

}
