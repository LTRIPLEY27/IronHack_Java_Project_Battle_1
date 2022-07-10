package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

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
                    [2] - Random Warrior
                    [3] - Random Wizard
                    [4] - Show Graveyard
                    [5] - Random Party
                    
                    [exit] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> createWarrior();
                case "1" -> createWizard();
                case "2" -> randomWarrior();
                case "3" -> randomWizard();
                case "4" -> showGraveyard();
                case "5" -> randomParty();
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
    }

    private void createWizard() {

    }

    private void createWarrior() {
        System.out.println(Warrior.generateRandom());
    }

    private void randomWizard() {
        System.out.println(Wizard.generateRandom());
    }

    private void randomWarrior() {

    }

    private void randomParty() {
        //Party part = new Party();
        System.out.println("Indique cuántos miembros");
        int num = scanner.nextInt();
        System.out.println(Party.getRandomParty(num));  // --- > VERIFICAR SI DEJAMOS O NO EL MÈTODO COMO ESTÁTICO
    }
    
    private void showGraveyard() {
        graveyard.showGraveyard();
    }

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }


}
