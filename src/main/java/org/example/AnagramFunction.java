package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramFunction implements CommandFunction {

    // This will contain anagrams checked at point 1 of the problem and will use as a key a HashMap used for counting the number of char appearances in a String
    private final Map<HashMap<Character, Integer>, Set<String>> savedAnagrams = new HashMap<>();

    @Override
    public boolean isConditionFulfilled(List<String> input) {
        return false;
    }

    @Override
    public Set<String> findAllWithConditionFulfilled(String input) {
        return null;
    }
}
