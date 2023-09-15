package org.example.ui;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FunctionEnum {
    ANAGRAM("An anagram is a word or phrase formed by rearranging the letters of a different word or phrase."),
    VOWELS("The number of vowels in multiple words is the same.");

    private final String description;
}
