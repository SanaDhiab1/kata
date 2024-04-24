package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.enums.RuleEnum;
import org.codingdojo.yatzy1.model.Roll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Yatzy1Test {

    @Test
    public void calculateScoreForChanceRule() throws Exception {
        Roll rollValues = new Roll(2,3,4,5,1);
        int expected = 15;

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.CHANCE);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreForYatziRule() throws Exception {
        Roll rollValues = new Roll(4,4,4,4,4);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.YATZY);

        int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreForOnesRule() throws Exception {
        Roll rollValues = new Roll(1,2,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.ONES);

        assertEquals(1, actual);
    }

    @Test
    public void calculateScoreForTwosRule() throws Exception {
        Roll rollValues = new Roll(2,2,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.TWOS);

        assertEquals(4, actual);
    }

    @Test
    public void calculateScoreForThreesRule() throws Exception {
        Roll rollValues = new Roll(2,3,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.THREES);

        assertEquals(6, actual);
    }

    @Test
    public void calculateScoreForFoursRule() throws Exception {
        Roll rollValues = new Roll(2,1,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.FOURS);

        assertEquals(4, actual);
    }

    @Test
    public void calculateScoreForFivesRule() throws Exception {
        Roll rollValues = new Roll(2,5,5,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.FIVES);

        assertEquals(15, actual);
    }

    @Test
    public void calculateScoreForSixesRule() throws Exception {
        Roll rollValues = new Roll(2,6,6,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.SIXES);

        assertEquals(12, actual);
    }

    @Test
    public void calculateScoreForOnePair() throws Exception {
        Roll rollValues = new Roll(3,4,3,5,6);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.ONE_PAIR);

        assertEquals(6, actual);
    }

    @Test
    public void calculateScoreForTwoPair() throws Exception {
        Roll rollValues = new Roll(3,3,5,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.TWO_PAIRS);

        assertEquals(16, actual);
    }

    @Test
    public void calculateScoreForThreeOfAkind() throws Exception {
        Roll rollValues = new Roll(3,3,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.THREE_OF_A_KIND);

        assertEquals(9, actual);
    }

    @Test
    public void calculateScoreForFourOfAkind() throws Exception {
        Roll rollValues = new Roll(3,3,3,3,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.FOUR_OF_A_KIND);

        assertEquals(12, actual);
    }

    @Test
    public void smallStraight() throws Exception {
        Roll rollValues = new Roll(1,2,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.SMALL_STRAIGHT);

        assertEquals(15, actual);
    }

    @Test
    public void largeStraight() throws Exception {
        Roll rollValues = new Roll(6,2,3,4,5);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.LARGE_STRAIGHT);

        assertEquals(20, actual);
    }

    @Test
    public void fullHouse() throws Exception {
        Roll rollValues = new Roll(6,2,2,2,6);

        int actual = Yatzy1.calculatScoreForRule(rollValues, RuleEnum.FULL_HOUSE);

        assertEquals(18, actual);
    }
}