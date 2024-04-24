package org.codingdojo.yatzy1.calculator;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.codingdojo.yatzy1.enums.RuleEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {

    @Test
    void chance_score_test() {
        int actual = ScoreCalculator.calculateScoreForChanceRule(List.of(1, 1, 3, 3, 6));

        assertEquals(14, actual);
    }


    @Test
    void yatzi_score_test_first_case() {
        int actual = ScoreCalculator.calculateScoreForYatzyRule(List.of(1, 1, 1, 1, 1));

        assertEquals(50, actual);
    }

    @Test
    void yatzi_score_test_second_case() {
        int actual = ScoreCalculator.calculateScoreForYatzyRule(List.of(1, 1, 1, 2, 1));

        assertEquals(0, actual);
    }

    @Test
    void fours_score_test_first_case() {
        int actual = ScoreCalculator.calculateSumOfMatchedValues(List.of(1, 1, 2, 4, 4), FOURS.getNumber());

        assertEquals(8, actual);
    }

    @Test
    void fours_score_test_second_case() {
        int actual = ScoreCalculator.calculateSumOfMatchedValues(List.of(1, 1, 2, 4, 4), FOURS.getNumber());

        assertEquals(8, actual);
    }

    @Test
    void twos_score_test() {
        int actual = ScoreCalculator.calculateSumOfMatchedValues(List.of(2, 3, 2, 5, 1), TWOS.getNumber());

        assertEquals(4, actual);
    }

    @Test
    void ones_score_test() {
        int actual = ScoreCalculator.calculateSumOfMatchedValues(List.of(3, 3, 3, 4, 5), ONES.getNumber());

        assertEquals(0, actual);
    }

    @Test
    void one_pair_score_test_first_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(1, 2, 3, 4, 5), ONE_PAIR.getNumber());

        assertEquals(0, actual);
    }

    @Test
    void one_pair_score_test_second_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(3, 3, 3, 4, 4), ONE_PAIR.getNumber());

        assertEquals(8, actual);
    }

    @Test
    void one_pair_score_test_third_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(1, 1, 6, 2, 6), ONE_PAIR.getNumber());

        assertEquals(12, actual);
    }

    @Test
    void one_pair_score_test_fourth_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(3, 3, 3, 4, 1), ONE_PAIR.getNumber());

        assertEquals(6, actual);
    }

    @Test
    void one_pair_score_test_fifth_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(3, 3, 3, 3, 1), ONE_PAIR.getNumber());

        assertEquals(6, actual);
    }

    @Test
    void two_pair_score_test_first_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(1, 1, 2, 3, 3), TWO_PAIRS.getNumber());

        assertEquals(8, actual);
    }

    @Test
    void two_pair_score_test_second_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(1, 1, 2, 3, 4), TWO_PAIRS.getNumber());

        assertEquals(0, actual);
    }

    @Test
    void two_pair_score_test_third_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(1, 1, 2, 2, 2), TWO_PAIRS.getNumber());

        assertEquals(6, actual);
    }

    @Test
    void two_pair_score_test_fourth_case() {
        int actual = ScoreCalculator.calculateScoreForNPairRule(List.of(3, 3, 3, 3, 1), TWO_PAIRS.getNumber());

        assertEquals(0, actual);
    }

    @Test
    void three_of_a_kind_score_test_first_case() {
        int actual = ScoreCalculator.calculateScoreForNofKindRule(List.of(3, 3, 3, 4, 5), THREE_OF_A_KIND.getNumber());

        assertEquals(9, actual);
    }

    @Test
    void three_of_a_kind_score_test_second_case() {
        int actual = ScoreCalculator.calculateScoreForNofKindRule(List.of(3, 3, 4, 5, 6), THREE_OF_A_KIND.getNumber());

        assertEquals(0, actual);
    }

    @Test
    void three_of_a_kind_score_test_third_case() {
        int actual = ScoreCalculator.calculateScoreForNofKindRule(List.of(3, 3, 3, 3, 1), THREE_OF_A_KIND.getNumber());

        assertEquals(9, actual);
    }

    @Test
    void small_Straight_score_test() {
        int actual = ScoreCalculator.calculateScoreForSmallStraightRule(List.of(1, 2, 3, 4, 5));

        assertEquals(15, actual);
    }

    @Test
    void large_Straight_score_test() {
        int actual = ScoreCalculator.calculateScoreForLargeStraightRule(List.of(2, 3, 4, 5, 6));

        assertEquals(20, actual);
    }

    @Test
    void full_house_score_test_first_case() {
        int actual = ScoreCalculator.calculateScoreForFullHouseRule(List.of(1, 1, 2, 2, 2));

        assertEquals(8, actual);
    }

    @Test
    void full_house_score_test_second_case() {
        int actual = ScoreCalculator.calculateScoreForFullHouseRule(List.of(2, 2, 3, 3, 4));

        assertEquals(0, actual);
    }

    @Test
    void full_house_score_test_third_case() {
        int actual = ScoreCalculator.calculateScoreForFullHouseRule(List.of(4, 4, 4, 4, 4));

        assertEquals(0, actual);
    }
}