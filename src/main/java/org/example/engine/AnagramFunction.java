package org.example.engine;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramFunction implements CommandFunction {

    // This will contain anagrams checked at point 1 of the problem and will use as a key a HashMap used for counting the number of char appearances in a String
    private final Map<HashMap<Character, Integer>, Set<String>> savedAnagrams = new HashMap<>();

    @Override
    public boolean isConditionFulfilled(List<String> input) {
        if (input.isEmpty()) {
            return Boolean.TRUE;
        }

        // first we compute the char counter of the first input, later comparing with other elements length and char counter
        var firstInput = input.get(0);
        var firstInputCharCounterMap = getCountedCharsAsMap(firstInput);

        for (int i = 1; i < input.size(); i++) {
            var counterMap = new HashMap<Character, Integer>();
            var targetStr = input.get(i);

            if (targetStr.length() != firstInput.length()) {
                return Boolean.FALSE;
            }

            for (char c : targetStr.toCharArray()) {
                if (!firstInputCharCounterMap.containsKey(c)) {
                    return Boolean.FALSE;
                }

                counterMap.compute(c, (key, value) -> value == null ? 1 : value + 1);

                if (counterMap.get(c) > firstInputCharCounterMap.get(c)) {
                    return Boolean.FALSE;
                }
            }
        }

        // at this point we know that the input were all anagrams, and we save them into "savedAnagrams" data structure for fulfilling point 2 of the exercise
        var anagrams = savedAnagrams.getOrDefault(firstInputCharCounterMap, new HashSet<>());
        anagrams.addAll(input);
        savedAnagrams.put(firstInputCharCounterMap, anagrams);

        return Boolean.TRUE;
    }

    @Override
    public Set<String> findAllWithConditionFulfilled(String input) {
        if (input.isEmpty()) {
            return Collections.emptySet();
        }

        var charsCounterMap = getCountedCharsAsMap(input);

        return savedAnagrams.getOrDefault(charsCounterMap, Collections.emptySet());
    }

    private HashMap<Character, Integer> getCountedCharsAsMap(String str) {
        return str.chars()
                .mapToObj(c -> ((char) c))
                .collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum, HashMap::new));
    }
}
