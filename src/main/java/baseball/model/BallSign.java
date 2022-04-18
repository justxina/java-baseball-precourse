package baseball.model;

public enum BallSign {
    STRIKE ("스트라이크"),
    BALL ("볼"),
    FOUL ("파울");

    final private String name;

    public String getName() {
        return this.name;
    }

    private BallSign(String name){
        this.name = name;
    }
}
