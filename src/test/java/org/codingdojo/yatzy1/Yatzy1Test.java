package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.enums.RuleEnum;
import org.codingdojo.yatzy1.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Yatzy1Test {

    @Test
    public void calculateScoreTestCaseInvalidInput(){
        List<Integer> rollValues = List.of(2,3,4,5,1,8);

        assertThrows(BusinessException.class, () -> Yatzy1.calculateScoreForRule(rollValues, RuleEnum.CHANCE));
    }

    @Test
    public void calculateScoreForChanceRule() throws Exception {
        List<Integer> rollValues = List.of(2,3,4,5,1);
        int expected = 15;

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.CHANCE);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreForYatziRule() throws Exception {
        List<Integer> rollValues = List.of(4,4,4,4,4);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.YATZY);

        int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void calculateScoreForOnesRule() throws Exception {
        List<Integer> rollValues = List.of(1,2,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.ONES);

        assertEquals(1, actual);
    }

    @Test
    public void calculateScoreForTwosRule() throws Exception {
        List<Integer> rollValues = List.of(2,2,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.TWOS);

        assertEquals(4, actual);
    }

    @Test
    public void calculateScoreForThreesRule() throws Exception {
        List<Integer> rollValues = List.of(2,3,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.THREES);

        assertEquals(6, actual);
    }

    @Test
    public void calculateScoreForFoursRule() throws Exception {
        List<Integer> rollValues = List.of(2,1,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.FOURS);

        assertEquals(4, actual);
    }

    @Test
    public void calculateScoreForFivesRule() throws Exception {
        List<Integer> rollValues = List.of(2,5,5,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.FIVES);

        assertEquals(15, actual);
    }

    @Test
    public void calculateScoreForSixesRule() throws Exception {
        List<Integer> rollValues = List.of(2,6,6,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.SIXES);

        assertEquals(12, actual);
    }

    @Test
    public void calculateScoreForOnePair() throws Exception {
        List<Integer> rollValues = List.of(3,4,3,5,6);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.ONE_PAIR);

        assertEquals(6, actual);
    }

    @Test
    public void calculateScoreForTwoPair() throws Exception {
        List<Integer> rollValues = List.of(3,3,5,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.TWO_PAIRS);

        assertEquals(16, actual);
    }

    @Test
    public void calculateScoreForThreeOfAkind() throws Exception {
        List<Integer> rollValues = List.of(3,3,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.THREE_OF_A_KIND);

        assertEquals(9, actual);
    }

    @Test
    public void calculateScoreForFourOfAkind() throws Exception {
        List<Integer> rollValues = List.of(3,3,3,3,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.FOUR_OF_A_KIND);

        assertEquals(12, actual);
    }

    @Test
    public void smallStraight() throws Exception {
        List<Integer> rollValues = List.of(1,2,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.SMALL_STRAIGHT);

        assertEquals(15, actual);
    }

    @Test
    public void largeStraight() throws Exception {
        List<Integer> rollValues = List.of(6,2,3,4,5);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.LARGE_STRAIGHT);

        assertEquals(20, actual);
    }

    @Test
    public void fullHouse() throws Exception {
        List<Integer> rollValues = List.of(6,2,2,2,6);

        int actual = Yatzy1.calculateScoreForRule(rollValues, RuleEnum.FULL_HOUSE);

        assertEquals(18, actual);
    }
}