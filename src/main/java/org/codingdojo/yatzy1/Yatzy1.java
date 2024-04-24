package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.enums.RuleEnum;
import org.codingdojo.yatzy1.model.Roll;

import static org.codingdojo.yatzy1.calculator.ScoreCalculator.*;
import static org.codingdojo.yatzy1.constants.DiceRulesConstants.*;

public class Yatzy1 {


    public static int calculatScoreForRule(Roll roll, RuleEnum rule) {

        return switch (rule) {
            case CHANCE -> calculateScoreForChanceRule(roll.getDiceValueList());
            case YATZY -> calculateScoreForYatzyRule(roll.getDiceValueList());
            case ONES -> calculateSumOfMatchedValues(roll.getDiceValueList(), ONES_NUMBER);
            case TWOS -> calculateSumOfMatchedValues(roll.getDiceValueList(), TWOS_NUMBER);
            case THREES -> calculateSumOfMatchedValues(roll.getDiceValueList(), THREES_NUMBER);
            case FOURS -> calculateSumOfMatchedValues(roll.getDiceValueList(), FOURS_NUMBER);
            case FIVES -> calculateSumOfMatchedValues(roll.getDiceValueList(), FIVES_NUMBER);
            case SIXES -> calculateSumOfMatchedValues(roll.getDiceValueList(), SIXES_NUMBER);
            case ONE_PAIR -> calculateScoreForNPairRule(roll.getDiceValueList(), ONE_PAIR_NUMBER);
            case TWO_PAIRS -> calculateScoreForNPairRule(roll.getDiceValueList(), SECOND_PAIR_NUMBER);
            case SMALL_STRAIGHT -> calculateScoreForSmallStraightRule(roll.getDiceValueList());
            case LARGE_STRAIGHT -> calculateScoreForLargeStraightRule(roll.getDiceValueList());
            case THREE_OF_A_KIND -> calculateScoreForNofKindRule(roll.getDiceValueList(), THREE_OF_A_KIND_NUMBER);
            case FOUR_OF_A_KIND -> calculateScoreForNofKindRule(roll.getDiceValueList(), FOUR_OF_A_KIND_NUMBER);
            case FULL_HOUSE -> calculateScoreForFullHouseRule(roll.getDiceValueList());
        };
    }
}
