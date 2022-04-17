package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;

public class Game {

    static public Integer STRIKE_ZONE_LENGTH = 3;
    static public Integer STRIKE_ZONE_MINIMUM = 1;
    static public Integer STRIKE_ZONE_MAXIMUM = 9;

    private HashSet<Integer> strikeZone;


    public Game() {
        this.start();
    }


    public void start() {
        this.generateStrikeZone();
    }

    public HashSet<Integer> getStrikeZone() {
        return this.strikeZone;
    }

    private void generateStrikeZone() {
        this.strikeZone = new HashSet<>();
        while (this.strikeZone.size() < STRIKE_ZONE_LENGTH) {
            this.strikeZone.add(pickNumberInRange(STRIKE_ZONE_MINIMUM, STRIKE_ZONE_MAXIMUM));
        }
    }

}
