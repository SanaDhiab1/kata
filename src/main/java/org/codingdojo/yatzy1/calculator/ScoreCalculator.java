package org.codingdojo.yatzy1.calculator;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.codingdojo.yatzy1.constants.DiceRulesConstants.*;
import static org.codingdojo.yatzy1.constants.ScoreConstants.*;

public class ScoreCalculator {

    private static final Set<Integer> SMALL_STRAIGHT_VALUES = Set.of(1, 2, 3, 4, 5);
    private static final Set<Integer> LARGE_STRAIGHT_VALUES = Set.of(2, 3, 4, 5, 6);


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
        Stream<Map.Entry<Integer, List<Integer>>> sorted = groupedByDiceValue.entrySet().
                stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByKey()));

        List<Map.Entry<Integer, List<Integer>>> entryList = sorted.
                filter(entry -> entry.getValue().size() >= PAIR_NUMBER).
                limit(pairNumber).toList();

        if (entryList.size() < pairNumber) {
            return ZERO;
        }
        return entryList.stream().
                map(pairEntry -> pairEntry.getKey() * PAIR_NUMBER).
                reduce(Integer::sum).
                orElse(ZERO);
    }


    public static int calculateScoreForNofKindRule(List<Integer> rollValues, Integer ruleNumber) {
        Map<Integer, List<Integer>> groupedByDiceValue = groupByDiceValues(rollValues);

        Optional<Map.Entry<Integer, List<Integer>>> filtredEntry = groupedByDiceValue.entrySet().stream().
                filter(entry -> entry.getValue().size() >= ruleNumber).
                findFirst();

        return filtredEntry.map(integerListEntry -> integerListEntry.getKey() * ruleNumber).
                orElse(ZERO);
    }

    public static int calculateScoreForFullHouseRule(List<Integer> rollValues) {
        int scoreForThreeOfAkind = calculateScoreForNofKindRule(rollValues, THREE_OF_A_KIND_NUMBER);
        if (scoreForThreeOfAkind == ZERO) {
            return ZERO;
        }
        List<Integer> remainingRollValues = rollValues.stream().
                filter(value -> value != (scoreForThreeOfAkind / THREE_OF_A_KIND_NUMBER)).
                toList();
        int scoreForTwoOfAkind = calculateScoreForNofKindRule(remainingRollValues, TWO_OF_A_KIND_NUMBER);
        if (scoreForTwoOfAkind == ZERO) {
            return ZERO;
        }
        return scoreForThreeOfAkind + scoreForTwoOfAkind;
    }

    public static int calculateScoreForSmallStraightRule(List<Integer> rollValues) {
        if (checkIfRollValuesContainsAllRange(rollValues, SMALL_STRAIGHT_VALUES)) {
            return FULL_SMALL_STRAIGHT;
        }
        return ZERO;
    }

    public static int calculateScoreForLargeStraightRule(List<Integer> rollValues) {
        if (checkIfRollValuesContainsAllRange(rollValues, LARGE_STRAIGHT_VALUES)) {
            return FULL_LARGE_STRAIGHT;
        }
        return ZERO;
    }

    private static boolean checkIfRollValuesContainsAllRange(List<Integer> rollValues, Set<Integer> range) {
        return new HashSet<>(rollValues).containsAll(range);
    }

    private static Map<Integer, List<Integer>> groupByDiceValues(List<Integer> values) {
        return values.stream().
                collect(groupingBy(Integer::intValue));
    }
}
