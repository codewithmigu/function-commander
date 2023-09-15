package org.example.ui;

import org.example.engine.AnagramFunction;
import org.example.engine.CommandFunction;
import org.example.engine.VowelsFunction;

import java.util.*;

import static org.example.ui.MessageConstants.*;

public class Commands {
    private FunctionEnum loadedFunction;
    private final SortedMap<String, FunctionEnum> functionLoaderMap;
    private final Map<FunctionEnum, CommandFunction> commandFunctionMap;

    public Commands() {
        loadedFunction = FunctionEnum.ANAGRAM;
        functionLoaderMap = new TreeMap<>(Map.of(
                "1", FunctionEnum.ANAGRAM,
                "2", FunctionEnum.VOWELS
        ));
        commandFunctionMap = Map.of(
                FunctionEnum.ANAGRAM, new AnagramFunction(),
                FunctionEnum.VOWELS, new VowelsFunction()
        );
    }

    public void printInputOfFirstCommand(Scanner scanner) {
        System.out.println(SINGLE_INPUT_FORMAT);
        var input = scanner.nextLine();

        System.out.printf(ALL_INPUTS_FORMAT, commandFunctionMap.get(loadedFunction).findAllWithConditionFulfilled(input));
    }

    public void checkIfInputFulfillsLoadedFunction(Scanner scanner) {
        System.out.println(NUMBER_OF_INPUTS_MSG);
        var inputNumber = scanner.nextLine();

        try {
            var input = new ArrayList<String>();

            for (int i = 0; i < Integer.parseInt(inputNumber); i++) {
                System.out.printf(NUMBERED_INPUT_FORMAT, i);
                input.add(scanner.next());
            }

            System.out.printf(BASED_ON_CONDITION_OUTPUT_MAP.get(commandFunctionMap.get(loadedFunction).isConditionFulfilled(input)), input, loadedFunction.name());
        }
        catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT);
        }
    }

    public void changeLoadedFunction(Scanner scanner) {
        System.out.println(AVAILABLE_FUNCTIONS);
        functionLoaderMap.forEach((key, value) -> System.out.printf(FUNCTION_FORMAT + LINE_SEPARATOR, key, value.name(), value.getDescription()));
        var selectedFunction = scanner.nextLine();

        if (!functionLoaderMap.containsKey(selectedFunction)) {
            System.out.println(INVALID_INPUT);
        } else {
            loadedFunction = functionLoaderMap.get(selectedFunction);
            System.out.printf(FUNCTION_LOADED, loadedFunction);
        }
    }

    public FunctionEnum getLoadedFunction() {
        return loadedFunction;
    }
}
