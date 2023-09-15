package org.example;


import org.example.engine.AnagramFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class AnagramFunctionTest {

    @ParameterizedTest
    @MethodSource("provideInputForAnagramConditionTest")
    void isConditionFulfilled(List<String> input, boolean expected) {
        final var anagramFunction = new AnagramFunction();

        Assertions.assertEquals(expected, anagramFunction.isConditionFulfilled(input));
    }

    @ParameterizedTest
    @MethodSource("provideInputForFindingAllAnagramsTest")
    void findAllWithConditionFulfilled(List<List<String>> preLoadedAnagrams, String input, Set<String> expected) {
        final var anagramFunction = new AnagramFunction();

        preLoadedAnagrams.forEach(anagramFunction::isConditionFulfilled);

        Assertions.assertEquals(expected, anagramFunction.findAllWithConditionFulfilled(input));
    }

    private static Stream<Arguments> provideInputForAnagramConditionTest() {
        return Stream.of(
                Arguments.of(List.of("abcd", "abdc", "adbc"), Boolean.TRUE),
                Arguments.of(List.of("abcd", "badc", "efgh"), Boolean.FALSE),
                Arguments.of(List.of("listen", "silent", "enlist"), Boolean.TRUE),
                Arguments.of(List.of("hello", "world", "dlrow", "olleh"), Boolean.FALSE),
                Arguments.of(List.of("123", "321", "456"), Boolean.FALSE),
                Arguments.of(List.of("", ""), Boolean.TRUE),
                Arguments.of(List.of("abc", "cab", "bac", "xyz"), Boolean.FALSE),
                Arguments.of(List.of("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba"), Boolean.TRUE)
        );
    }

    private static Stream<Arguments> provideInputForFindingAllAnagramsTest() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("hello", "olleh", "ohell"),
                                List.of("world", "dlrow", "drawl"),
                                List.of("example", "complex", "palmexa")
                        ),
                        "hello",
                        Set.of("hello", "olleh", "ohell")
                ),
                Arguments.of(
                        List.of(
                                List.of("listen", "silent", "enlist"),
                                List.of("triangle", "integral", "relating"),
                                List.of("moon", "noom", "omno")
                        ),
                        "listen",
                        Set.of("listen", "silent", "enlist")
                ),
                Arguments.of(
                        List.of(
                                List.of("abcdefg", "gfedcba", "bagcfed"),
                                List.of("12345", "54321", "21543"),
                                List.of("word", "drow", "rowd")
                        ),
                        "abcdefg",
                        Set.of("abcdefg", "gfedcba", "bagcfed")
                ),
                Arguments.of(
                        List.of(
                                List.of("empty", "tempy", "pytem"),
                                List.of("123", "321", "213"),
                                List.of("anagram", "mangara", "aargman")
                        ),
                        "empty",
                        Set.of("empty", "tempy", "pytem")
                ),
                Arguments.of(
                        List.of(
                                List.of("hello", "olleh", "ohell"),
                                List.of("world", "dlrow", "drawl"),
                                List.of("example", "complex", "palmexa")
                        ),
                        "invalid_input",
                        Collections.emptySet()
                ),
                Arguments.of(
                        Collections.emptyList(),
                        "hello",
                        Collections.emptySet()
                ),
                Arguments.of(
                        List.of(
                                List.of("listen", "silent", "enlist"),
                                List.of("triangle", "integral", "relating"),
                                List.of("moon", "noom", "omno")
                        ),
                        "nonexistent_input",
                        Collections.emptySet()
                ),
                Arguments.of(
                        List.of(
                                List.of("hello", "olleh", "ohell"),
                                List.of("world", "dlrow", "drawl"),
                                List.of("example", "complex", "palmexa")
                        ),
                        "",
                        Collections.emptySet()
                )
        );
    }

}