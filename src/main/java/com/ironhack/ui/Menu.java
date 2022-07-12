package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.battle.Battle;
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
                    [99] - Battle
                    
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
                case "99" -> battle();
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
    }

    private void createWizard() {

    }

    private void randomWizard() {

    }

    private void randomWarrior() {

    }

    private void createWarrior() {

    }

    //SOLO A MODO DE PRUEBA, EDITAR EN LA CLASE GRAVEYARD
    private void showGraveyard() {
        Graveyard graveyard = new Graveyard();

        var Merlin = new Wizard("Merlin", "3", 200, true, 500, 100);
        var VatoLoco = new Warrior("Vato Loco", "3", 200, true, 500, 100);

        graveyard.addDeadCharacter(Merlin);
        graveyard.addDeadCharacter(VatoLoco);

        graveyard.showGraveyard();
    }

    private void battle() {
        Character char1 = new Warrior("First Warrior", Character.generateId(), 200, true, 30, 10);
        Character char2 = new Wizard("First Wizard", Character.generateId(), 100, true, 40, 10);
        Battle.oneVsOneBattle(char1, char2);
    }

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }


}
