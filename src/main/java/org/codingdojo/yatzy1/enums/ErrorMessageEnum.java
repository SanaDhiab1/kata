package org.codingdojo.yatzy1.enums;

public enum ErrorMessageEnum {

    INVALID_SIZE("The roll should contain five values"),
    VALUE_OUT_OF_THE_RANGE("The values must be in the range [1-6]");

    private final String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
