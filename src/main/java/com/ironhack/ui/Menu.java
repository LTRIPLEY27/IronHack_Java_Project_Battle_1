package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

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
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
    }

    private void createWizard() {

    }

    private void randomWizard() {

    }

    private void createWarrior() {

    }

    private void randomWarrior() {
        Warrior warlock = null;


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

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }


}
