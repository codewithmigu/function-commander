package org.example.ui;

import java.util.Map;

public class MessageConstants {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String APPLICATION_MENU = LINE_SEPARATOR + LINE_SEPARATOR + "Application offers the functionality to select a predefined function which can be used in two features." + LINE_SEPARATOR +
            "Currently loaded function in the program: %s - %s" + LINE_SEPARATOR + LINE_SEPARATOR +
            "Please select the number for executing command:" + LINE_SEPARATOR +
            "0. Select the function you would like to apply for other commands. " + LINE_SEPARATOR +
            "1. Check if given inputs are fulfilling the function loaded in the program." + LINE_SEPARATOR +
            "2. Out of all inputs of command 1: for a given input, provide all the inputs which fulfilled the function loaded in the program" + LINE_SEPARATOR + LINE_SEPARATOR +
            "Please select the number of the command you want to execute:" + LINE_SEPARATOR + LINE_SEPARATOR;
    public static final String NUMBERED_INPUT_FORMAT = "Please insert input #%s:" + LINE_SEPARATOR;
    public static final String NUMBER_OF_INPUTS_MSG = "Please select number of inputs you want to introduce:";
    public static final String SINGLE_INPUT_FORMAT = "Please insert input: " + LINE_SEPARATOR;
    public static final Map<Boolean, String> BASED_ON_CONDITION_OUTPUT_MAP = Map.of(
            Boolean.TRUE, "Inputs %s are fulfilling the function loaded in the program: %s",
            Boolean.FALSE, "Inputs %s are not fulfilling the function loaded in the program: %s"
    );

    public static final String ALL_INPUTS_FORMAT = "All inputs from command 1 fulfilling loaded program: %s" + LINE_SEPARATOR;
    public static final String AVAILABLE_FUNCTIONS = "Please select one of available functions: " + LINE_SEPARATOR;
    public static final String FUNCTION_LOADED = "Function %s loaded in program.";
    public static final String INVALID_INPUT = "Invalid input. Please retry.";
    public static final String FUNCTION_FORMAT = "%s - %s - %s";
}
