package org.codingdojo.yatzy1.validator;

import org.codingdojo.yatzy1.exceptions.BusinessException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RollValuesValidatorTest {

    @Test
    void validate_roll_values_test_case_valid_values() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        assertDoesNotThrow(() -> RollValuesValidator.validateRollValues(input));
    }

    @Test
    void validate_roll_values_test_case_invalid_size() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        assertThrows(BusinessException.class, () -> RollValuesValidator.validateRollValues(input));
    }

    @Test
    void validate_roll_values_test_case_invalid_numbers() {
        List<Integer> input = List.of(1, 2, 3, 4, 8);

        assertThrows(BusinessException.class, () -> RollValuesValidator.validateRollValues(input));
    }
}