package org.example.engine;


import java.util.List;
import java.util.Set;

public interface CommandFunction {

    boolean isConditionFulfilled(List<String> input);
    Set<String> findAllWithConditionFulfilled(String input);
}
