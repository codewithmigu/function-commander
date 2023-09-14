package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String APPLICATION_MENU = LINE_SEPARATOR + LINE_SEPARATOR + "Application offers the functionality to select a predefined function which can be used in two features." + LINE_SEPARATOR +
            "Currently loaded function in the program: %s - %s" + LINE_SEPARATOR + LINE_SEPARATOR +
            "Please select the number for executing command:" + LINE_SEPARATOR +
            "0. Select the function you would like to apply for other commands. " + LINE_SEPARATOR +
            "1. Check if given inputs are fulfilling the function loaded in the program." + LINE_SEPARATOR +
            "2. Out of all inputs of command 1: for a given input, provide all the inputs which fulfilled the function loaded in the program" + LINE_SEPARATOR + LINE_SEPARATOR +
            "Please select the number of the command you want to execute:" + LINE_SEPARATOR + LINE_SEPARATOR;
    private static final String NUMBERED_INPUT_FORMAT = "Please insert input #%s:" + LINE_SEPARATOR;
    private static final String NUMBER_OF_INPUTS_MSG = "Please select number of inputs you want to introduce:";
    private static final String SINGLE_INPUT_FORMAT = "Please insert input: " + LINE_SEPARATOR;
    private static final Map<Boolean, String> BASED_ON_CONDITION_OUTPUT_MAP = Map.of(
            Boolean.TRUE, "Inputs %s are fulfilling the function loaded in the program: %s",
            Boolean.FALSE, "Inputs %s are not fulfilling the function loaded in the program: %s"
    );

    private static final String CURRENTLY_LOADED_FUNCTION_FORMAT = "Currently loaded function in the program: %s" + LINE_SEPARATOR + LINE_SEPARATOR;
    private static final String ALL_INPUTS_FORMAT = "All inputs from command 1 fulfilling loaded program: %s" + LINE_SEPARATOR;
    private static final String AVAILABLE_FUNCTIONS = "Please select one of available functions: " + LINE_SEPARATOR;
    private static final String FUNCTION_LOADED = "Function %s loaded in program.";
    private static final String INVALID_INPUT = "Invalid input. Please retry.";
    private static final String FUNCTION_FORMAT = "%s - %s - %s";
    private final SortedMap<Integer, FunctionEnum> functionLoaderMap = new TreeMap<>(Map.of(
            1, FunctionEnum.ANAGRAM,
            2, FunctionEnum.VOWELS
    ));
    private FunctionEnum loadedFunction = FunctionEnum.ANAGRAM;

    private final Map<FunctionEnum, CommandFunction> commandFunctionMap = Map.of(
            FunctionEnum.ANAGRAM, new AnagramFunction(),
            FunctionEnum.VOWELS, new VowelsFunction()
    );

    public static void main(String[] args) {
        Main main = new Main();

        main.doSomething();
    }

    public void doSomething() {
        while (true) {
            System.out.printf(APPLICATION_MENU, loadedFunction.name(), loadedFunction.getDescription());
            var scanner = new Scanner(System.in);
            var command = scanner.nextLine();
            // TODO validate command

            switch (command) {
                case "0" -> {
                    System.out.println(AVAILABLE_FUNCTIONS);
                    functionLoaderMap.forEach((key, value) -> System.out.printf(FUNCTION_FORMAT + LINE_SEPARATOR, key, value.name(), value.getDescription()));
                    var selectedFunction = scanner.nextInt();
                    if (functionLoaderMap.containsKey(selectedFunction)) {
                        loadedFunction = functionLoaderMap.get(selectedFunction);
                        System.out.printf(FUNCTION_LOADED, loadedFunction);
                    } else {
                        System.out.println(INVALID_INPUT);
                    }
                }
                case "1" -> {
                    System.out.println(NUMBER_OF_INPUTS_MSG);
                    var inputNumber = scanner.nextInt();
                    // TODO validate input

                    var input = new ArrayList<String>();
                    for (int i = 0; i < inputNumber; i++) {
                        System.out.printf(NUMBERED_INPUT_FORMAT, i);
                        input.add(scanner.next());
                    }

                    System.out.printf(BASED_ON_CONDITION_OUTPUT_MAP.get(commandFunctionMap.get(loadedFunction).isConditionFulfilled(input)), input, loadedFunction.name());
                }
                case "2" -> {
                    System.out.println(SINGLE_INPUT_FORMAT);
                    var input = scanner.nextLine();
                    // TODO validate input

                    System.out.printf(ALL_INPUTS_FORMAT, commandFunctionMap.get(loadedFunction).findAllWithConditionFulfilled(input));
                }
                case "3" -> {
                    System.out.println("Bye bye.");
                    return;
                }
                default -> System.out.println(INVALID_INPUT);
            }
        }
    }
}