package org.example;

import java.util.Set;

public class InputValidator {

    public boolean isValid(String input) {
        return input != null && !input.isEmpty();
    }

    public boolean isValidWithPredefined(String input, Set<String> predefinedValues) {
        return isValid(input) && predefinedValues.contains(input);
    }
}
