package org.codingdojo.yatzy1.model;

import java.util.List;
import java.util.Set;

public class Roll {

    private static final Set<Integer> ROLL_VALUES_RANGE = Set.of(1,2,3,4,5, 6);

    private final List<Integer> diceValueList;

    public Roll(int value1, int value2, int value3, int value4, int value5) throws Exception {
        if (!(ROLL_VALUES_RANGE).containsAll(List.of(value1, value2, value3, value4, value5))) {
            throw new Exception("Invalid input");
        }
        this.diceValueList = List.of(value1, value2, value3, value4, value5);
    }

    public List<Integer> getDiceValueList() {
        return diceValueList;
    }
}
