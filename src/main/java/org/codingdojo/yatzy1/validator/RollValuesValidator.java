package org.codingdojo.yatzy1.validator;

import org.codingdojo.yatzy1.exceptions.BusinessException;

import java.util.List;
import java.util.Set;

import static org.codingdojo.yatzy1.enums.ErrorMessageEnum.INVALID_SIZE;
import static org.codingdojo.yatzy1.enums.ErrorMessageEnum.VALUE_OUT_OF_THE_RANGE;

public class RollValuesValidator {

    private static final Set<Integer> ROLL_VALUES_RANGE = Set.of(1,2,3,4,5, 6);
    private static final int ROLL_SIZE = 5;

    public static void validateRollValues(List<Integer> rollValues) throws BusinessException {

        validateSize(rollValues);
        validateValuesRange(rollValues);
    }

    private static void validateValuesRange(List<Integer> rollValues) throws BusinessException {
        if (!(ROLL_VALUES_RANGE).containsAll(rollValues)) {
            throw new BusinessException(VALUE_OUT_OF_THE_RANGE.getMessage());
        }
    }

    private static void validateSize(List<Integer> rollValues) throws BusinessException {
        if (rollValues == null || rollValues.size() != ROLL_SIZE) {
            throw new BusinessException(INVALID_SIZE.getMessage());
        }
    }
}
