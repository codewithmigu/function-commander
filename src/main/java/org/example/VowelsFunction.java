package org.example;

import java.util.*;
import java.util.stream.IntStream;


/**
 * Component responsible for verifying if the number of vowels is the same and to retrieve elements with the same number of vowels based on input
 */
public class VowelsFunction implements CommandFunction {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');
    private final Map<Long, Set<String>> vowelsCounterMap = new HashMap<>();

    @Override
    public boolean isConditionFulfilled(List<String> input) {
        if (input.size() <= 1) {
            return Boolean.TRUE;
        }

        var firstInputVowelsNo = getVowelsNumber(input.get(0));

        var differentVowelNo = IntStream.range(1, input.size())
                .boxed()
                .filter(i -> getVowelsNumber(input.get(i)) != firstInputVowelsNo)
                .findAny();

        if (differentVowelNo.isPresent()) {
            return Boolean.FALSE;
        }

        var sameNoOfVowelsStr = vowelsCounterMap.getOrDefault(firstInputVowelsNo, new HashSet<>());
        sameNoOfVowelsStr.addAll(input);
        vowelsCounterMap.put(firstInputVowelsNo, sameNoOfVowelsStr);

        return Boolean.TRUE;
    }

    @Override
    public Set<String> findAllWithConditionFulfilled(String input) {
        return vowelsCounterMap.getOrDefault(getVowelsNumber(input), Collections.emptySet());
    }

    private long getVowelsNumber(String str) {
        return str.chars()
                .mapToObj(c -> ((char) c))
                .filter(VOWELS::contains)
                .count();
    }
}
