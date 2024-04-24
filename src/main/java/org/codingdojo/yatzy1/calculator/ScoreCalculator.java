package org.codingdojo.yatzy1.calculator;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.codingdojo.yatzy1.enums.RuleEnum.THREE_OF_A_KIND;
import static org.codingdojo.yatzy1.enums.RuleEnum.TWO_OF_A_KIND;
import static org.codingdojo.yatzy1.enums.ScoreEnum.*;

public class ScoreCalculator {

    private static final Set<Integer> SMALL_STRAIGHT_VALUES = Set.of(1, 2, 3, 4, 5);
    private static final Set<Integer> LARGE_STRAIGHT_VALUES = Set.of(2, 3, 4, 5, 6);
    private static final int TWO = 2;


    public static int calculateScoreForChanceRule(List<Integer> rollValues) {
        return rollValues.stream().mapToInt(Integer::intValue).sum();
    }

    public static int calculateScoreForYatzyRule(List<Integer> values) {
        if (values.stream().distinct().count() > 1) {
            return ZERO.getScore();
        }
        return FULL_YATZI.getScore();
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
                filter(entry -> entry.getValue().size() >= TWO).
                limit(pairNumber).toList();

        if (entryList.size() < pairNumber) {
            return ZERO.getScore();
        }
        return entryList.stream().
                map(pairEntry -> pairEntry.getKey() * TWO).
                reduce(Integer::sum).
                orElse(ZERO.getScore());
    }


    public static int calculateScoreForNofKindRule(List<Integer> rollValues, Integer ruleNumber) {
        Map<Integer, List<Integer>> groupedByDiceValue = groupByDiceValues(rollValues);

        Optional<Map.Entry<Integer, List<Integer>>> filtredEntry = groupedByDiceValue.entrySet().stream().
                filter(entry -> entry.getValue().size() >= ruleNumber).
                findFirst();

        return filtredEntry.map(integerListEntry -> integerListEntry.getKey() * ruleNumber).
                orElse(ZERO.getScore());
    }

    public static int calculateScoreForFullHouseRule(List<Integer> rollValues) {
        int scoreForThreeOfAkind = calculateScoreForNofKindRule(rollValues, THREE_OF_A_KIND.getNumber());
        if (scoreForThreeOfAkind == ZERO.getScore()) {
            return ZERO.getScore();
        }
        List<Integer> remainingRollValues = rollValues.stream().
                filter(value -> value != (scoreForThreeOfAkind / THREE_OF_A_KIND.getNumber())).
                toList();
        int scoreForTwoOfAkind = calculateScoreForNofKindRule(remainingRollValues, TWO_OF_A_KIND.getNumber());
        if (scoreForTwoOfAkind == ZERO.getScore()) {
            return ZERO.getScore();
        }
        return scoreForThreeOfAkind + scoreForTwoOfAkind;
    }

    public static int calculateScoreForSmallStraightRule(List<Integer> rollValues) {
        if (checkIfRollValuesContainsAllRange(rollValues, SMALL_STRAIGHT_VALUES)) {
            return FULL_SMALL_STRAIGHT.getScore();
        }
        return ZERO.getScore();
    }

    public static int calculateScoreForLargeStraightRule(List<Integer> rollValues) {
        if (checkIfRollValuesContainsAllRange(rollValues, LARGE_STRAIGHT_VALUES)) {
            return FULL_LARGE_STRAIGHT.getScore();
        }
        return ZERO.getScore();
    }

    private static boolean checkIfRollValuesContainsAllRange(List<Integer> rollValues, Set<Integer> range) {
        return new HashSet<>(rollValues).containsAll(range);
    }

    private static Map<Integer, List<Integer>> groupByDiceValues(List<Integer> values) {
        return values.stream().
                collect(groupingBy(Integer::intValue));
    }
}
