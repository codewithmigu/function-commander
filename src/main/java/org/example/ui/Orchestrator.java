package org.example.ui;

import java.util.*;

import static org.example.ui.MessageConstants.*;

public class Orchestrator {
    private final Commands commands;

    public Orchestrator() {
        this.commands = new Commands();
    }

    public void displayMenu() {
        var scanner = new Scanner(System.in);

        while (true) {
            FunctionEnum loadedFunction = commands.getLoadedFunction();
            System.out.printf(APPLICATION_MENU, loadedFunction.name(), loadedFunction.getDescription());

            switch (scanner.nextLine()) {
                case "0" -> commands.changeLoadedFunction(scanner);
                case "1" -> commands.checkIfInputFulfillsLoadedFunction(scanner);
                case "2" -> commands.printInputOfFirstCommand(scanner);
                case "3" -> {
                    System.out.println("Bye bye.");
                    return;
                }
                default -> System.out.println(INVALID_INPUT);
            }
        }
    }

}