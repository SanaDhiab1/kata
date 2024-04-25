package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.enums.RuleEnum;
import org.codingdojo.yatzy1.exceptions.BusinessException;

import java.util.List;

import static org.codingdojo.yatzy1.calculator.ScoreCalculator.*;
import static org.codingdojo.yatzy1.constants.DiceRulesConstants.*;
import static org.codingdojo.yatzy1.validator.RollValuesValidator.validateRollValues;

public class Yatzy1 {


    public static int calculateScoreForRule(List<Integer> rollValues, RuleEnum rule) throws BusinessException {

        validateRollValues(rollValues);

        return switch (rule) {
            case CHANCE -> calculateScoreForChanceRule(rollValues);
            case YATZY -> calculateScoreForYatzyRule(rollValues);
            case ONES -> calculateSumOfMatchedValues(rollValues, ONES_NUMBER);
            case TWOS -> calculateSumOfMatchedValues(rollValues, TWOS_NUMBER);
            case THREES -> calculateSumOfMatchedValues(rollValues, THREES_NUMBER);
            case FOURS -> calculateSumOfMatchedValues(rollValues, FOURS_NUMBER);
            case FIVES -> calculateSumOfMatchedValues(rollValues, FIVES_NUMBER);
            case SIXES -> calculateSumOfMatchedValues(rollValues, SIXES_NUMBER);
            case ONE_PAIR -> calculateScoreForNPairRule(rollValues, ONE_PAIR_NUMBER);
            case TWO_PAIRS -> calculateScoreForNPairRule(rollValues, SECOND_PAIR_NUMBER);
            case SMALL_STRAIGHT -> calculateScoreForSmallStraightRule(rollValues);
            case LARGE_STRAIGHT -> calculateScoreForLargeStraightRule(rollValues);
            case THREE_OF_A_KIND -> calculateScoreForNofKindRule(rollValues, THREE_OF_A_KIND_NUMBER);
            case FOUR_OF_A_KIND -> calculateScoreForNofKindRule(rollValues, FOUR_OF_A_KIND_NUMBER);
            case FULL_HOUSE -> calculateScoreForFullHouseRule(rollValues);
        };
    }
}
