package org.codingdojo.yatzy1.calculator;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.codingdojo.yatzy1.constants.DiceRulesConstants.*;
import static org.codingdojo.yatzy1.constants.ScoreConstants.*;

public class ScoreCalculator {

    private static final Set<Integer> SMALL_STRAIGHT_VALUES = Set.of(1, 2, 3, 4, 5);
    private static final Set<Integer> LARGE_STRAIGHT_VALUES = Set.of(2, 3, 4, 5, 6);
    public static final int PAIR = 2;

    public static int calculateScoreForChanceRule(List<Integer> rollValues) {
        return rollValues.stream().mapToInt(Integer::intValue).sum();
    }

    public static int calculateScoreForYatzyRule(List<Integer> values) {
        if (values.stream().distinct().count() > 1) {
            return ZERO;
        }
        return FULL_YATZY;
    }

    public static int calculateSumOfMatchedValues(List<Integer> rollValues, Integer matchedValue) {
        return rollValues.stream().mapToInt(Integer::intValue).filter(value -> value == matchedValue).sum();
    }

    public static int calculateScoreForNPairRule(List<Integer> rollValues, int pairNumber) {
        Map<Integer, List<Integer>> groupedByDiceValue = groupByDiceValues(rollValues);
        Stream<Map.Entry<Integer, List<Integer>>> sorted = sortGroupedValuesByKey(groupedByDiceValue);

        List<Map.Entry<Integer, List<Integer>>> entryList = sorted.
                filter(entry -> entry.getValue().size() >= PAIR).
                limit(pairNumber).toList();

        if (entryList.size() < pairNumber) {
            return ZERO;
        }
        return entryList.stream().
                map(pairEntry -> pairEntry.getKey() * PAIR).
                reduce(Integer::sum).
                orElse(ZERO);
    }


    public static int calculateScoreForNofKindRule(List<Integer> rollValues, Integer ruleNumber) {
        Map<Integer, List<Integer>> groupedByDiceValue = groupByDiceValues(rollValues);

        Stream<Map.Entry<Integer, List<Integer>>> sorted = sortGroupedValuesByKey(groupedByDiceValue);

        Optional<Map.Entry<Integer, List<Integer>>> filtredEntry = sorted.
                filter(entry -> entry.getValue().size() >= ruleNumber).
                findFirst();

        return filtredEntry.map(diceValuesEntry -> diceValuesEntry.getKey() * ruleNumber).
                orElse(ZERO);
    }

    public static int calculateScoreForFullHouseRule(List<Integer> rollValues) {
        int scoreForThreeOfkind = calculateScoreForNofKindRule(rollValues, THREE_OF_A_KIND_NUMBER);
        if (scoreForThreeOfkind == ZERO) {
            return ZERO;
        }
        List<Integer> remainingRollValues = rollValues.stream().
                filter(value -> value != (scoreForThreeOfkind / THREE_OF_A_KIND_NUMBER)).
                toList();
        int scoreForTwoOfkind = calculateScoreForNofKindRule(remainingRollValues, TWO_OF_A_KIND_NUMBER);
        if (scoreForTwoOfkind == ZERO) {
            return ZERO;
        }
        return scoreForThreeOfkind + scoreForTwoOfkind;
    }

    public static int calculateScoreForSmallStraightRule(List<Integer> rollValues) {
        return calculateScoreForStraightRule(rollValues, SMALL_STRAIGHT_VALUES, FULL_SMALL_STRAIGHT);
    }

    public static int calculateScoreForLargeStraightRule(List<Integer> rollValues) {
        return calculateScoreForStraightRule(rollValues, LARGE_STRAIGHT_VALUES, FULL_LARGE_STRAIGHT);
    }

    private static int calculateScoreForStraightRule(List<Integer> rollValues,
                                                     Set<Integer> straightValues,
                                                     int fullScore) {
        if (checkIfRollValuesContainsAllRange(rollValues, straightValues)) {
            return fullScore;
        }
        return ZERO;
    }

    private static boolean checkIfRollValuesContainsAllRange(List<Integer> rollValues, Set<Integer> range) {
        return new HashSet<>(rollValues).containsAll(range);
    }

    private static Stream<Map.Entry<Integer, List<Integer>>> sortGroupedValuesByKey(Map<Integer, List<Integer>> groupedByDiceValue) {
        return groupedByDiceValue.entrySet().
                stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByKey()));
    }

    private static Map<Integer, List<Integer>> groupByDiceValues(List<Integer> values) {
        return values.stream().
                collect(groupingBy(Integer::intValue));
    }
}
