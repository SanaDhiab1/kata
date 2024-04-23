package org.codingdojo.yatzy1;

import org.codingdojo.yatzy1.enums.RuleEnum;
import org.codingdojo.yatzy1.model.RollValues;

import static org.codingdojo.yatzy1.calculator.ScoreCalculator.*;
import static org.codingdojo.yatzy1.enums.RuleEnum.*;

public class Yatzy1 {


    public static int calculatScoreForRule(RollValues rollValues, RuleEnum rule) throws Exception {

        return switch (rule) {
            case CHANCE -> calculateScoreForChanceRule(rollValues.getDiceValueList());
            case YATZI -> calculateScoreForYatzyRule(rollValues.getDiceValueList());
            case ONES -> calculateSumOfMatchedValues(rollValues.getDiceValueList(), ONES.getNumber());
            case TWOS -> calculateSumOfMatchedValues(rollValues.getDiceValueList(), TWOS.getNumber());
            case THREES -> calculateSumOfMatchedValues(rollValues.getDiceValueList(), THREES.getNumber());
            case FOURS -> calculateSumOfMatchedValues(rollValues.getDiceValueList(), FOURS.getNumber());
            case FIVES -> calculateSumOfMatchedValues(rollValues.getDiceValueList(), FIVES.getNumber());
            case SIXES -> calculateSumOfMatchedValues(rollValues.getDiceValueList(), SIXES.getNumber());
            case ONE_PAIR -> calculateScoreForNPairRule(rollValues.getDiceValueList(), ONE_PAIR.getNumber());
            case TWO_PAIRS -> calculateScoreForNPairRule(rollValues.getDiceValueList(), TWO_PAIRS.getNumber());
            case SMALL_STRAIGHT -> calculateScoreForSmallStraightRule(rollValues.getDiceValueList());
            case LARGE_STRAIGHT -> calculateScoreForLargeStraightRule(rollValues.getDiceValueList());
            case THREE_OF_A_KIND -> calculateScoreFor_N_OfKindRule(rollValues.getDiceValueList(), THREE_OF_A_KIND.getNumber());
            case FOUR_OF_A_KIND -> calculateScoreFor_N_OfKindRule(rollValues.getDiceValueList(), FOUR_OF_A_KIND.getNumber());
            case FULL_HOUSE -> calculateScoreForFullHouseRule(rollValues.getDiceValueList());
            default -> throw new Exception("Invalid rule");
        };
    }
}
