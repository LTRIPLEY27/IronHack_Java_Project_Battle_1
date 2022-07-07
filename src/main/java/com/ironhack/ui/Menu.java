package com.ironhack.ui;

import com.ironhack.Graveyard;

import java.util.Scanner;

public class Menu {

    

    private final Scanner scanner = new Scanner(System.in);
    private final Graveyard graveyard = new Graveyard();

    public void main() {
        String input;
        do {
            var mainMenu = """
                    Welcome to Battle Simulator
                    ===============
                    [0] - Warrior creator
                    [1] - Wizard creator
                    [2] - Show Graveyard
                    
                    [exit] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> createWarrior();
                case "1" -> createWizard();
                case "2" -> showGraveyard();
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
    }

    private void createWizard() {

    }

    private void createWarrior() {

    }

    private void showGraveyard() {
        graveyard.showGraveyard();
    }

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }

}
