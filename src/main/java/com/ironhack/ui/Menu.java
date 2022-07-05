package com.ironhack.ui;

import com.ironhack.Graveyard;
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
        testAttacks();
    }

    private void createWizard() {

    }

    private void randomWizard() {
        Wizard lizard = new Wizard();
        lizard.randomCharacter();
        System.out.println(lizard.toString());
    }

    private void createWarrior() {

    }

    private void randomWarrior() {
        Warrior warlock = new Warrior();
        warlock.randomCharacter();
        System.out.println(warlock.toString());
    }

    //SOLO A MODO DE PRUEBA, EDITAR EN LA CLASE GRAVEYARD
    private void showGraveyard() {
        Graveyard graveyard = new Graveyard();

        var Merlin = new Wizard("Merlin", "3", 200, true, 500, 100);
        var VatoLoco = new Warrior("Vato Loco", "3", 200, true, 500, 100);

        Wizard wizard1 = new Wizard("Merlin", 3, 200, true, 6, 100);
        Wizard wizard2 = new Wizard("Merlin", 3, 200, true, 2, 100);
        Character warrior1 = new Warrior("Vato Loco", 3, 200, true, 7, 100);
        Character warrior2 = new Warrior("Vato Loco", 3, 200, true, 3, 100);

        System.out.println("\n\nTesting attack methods\n");
        System.out.printf("wizard high mana attack value: %s - mana after: %s\n", wizard1.attack(), wizard1.getMana());
        System.out.printf("wizard low mana attack value: %s - mana after: %s\n", wizard2.attack(), wizard2.getMana());
        System.out.printf("warrior high stamina attack value: %s - stamina after: %s\n", warrior1.attack(), ((Warrior) warrior1).getStamina());
        System.out.printf("warrior low stamina attack value: %s - stamina after: %s\n\n", warrior2.attack(), ((Warrior) warrior2).getStamina());

    }

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }


}
