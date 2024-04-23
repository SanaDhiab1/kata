package org.codingdojo.yatzy1.enums;

public enum RuleEnum {

    CHANCE(null),
    YATZI(null),
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    ONE_PAIR(1),
    TWO_PAIRS(2),
    TWO_OF_A_KIND(2),
    THREE_OF_A_KIND(3),
    FOUR_OF_A_KIND(4),
    SMALL_STRAIGHT(null),
    LARGE_STRAIGHT(null),
    FULL_HOUSE(null);

    private final Integer number;

    RuleEnum(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
