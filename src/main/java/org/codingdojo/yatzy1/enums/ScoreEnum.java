package org.codingdojo.yatzy1.enums;

public enum ScoreEnum {

    ZERO(0),
    FULL_YATZI(50),
    FULL_SMALL_STRAIGHT(15),
    FULL_LARGE_STRAIGHT(20);

    private final int score;

    ScoreEnum(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
