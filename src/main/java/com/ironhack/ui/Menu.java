package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
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
                    [0] - PARTY MANAGER
                    [1] - VIEW GRAVEYARD
                    [2] - BATTLE
                    
                    [EXIT] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> partyManager();
                case "1" -> graveyardViewer();
                case "2" -> battle();
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
    }

    //region Party
    private void partyManager() {
        String input;
        do {
            var menu = """
                    Welcome to Party Manager
                    ===============
                    [0] - VIEW PARTIES
                    [1] - CREATE PARTY
                    
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(menu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> partyViewer();
                case "1" -> createParty();
                case "back" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("back"));
    }

    private void createParty() {
        String input;
        Party party = new Party();
        do {
            var mainMenu = """
                    Welcome to Party Creator
                    ===============
                    [0] - Add Warrior
                    [1] - Add Wizard
                    
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> party.addCharacter(createWarrior());
                case "1" -> party.addCharacter(createWizard());
                case "back" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("back"));

        party.membersParty();
    }

    private Wizard createWizard() {
        System.out.println("Indique nombre");
        var name = scanner.next();
        System.out.println("Indique id");
        var id = scanner.next();
        System.out.println("Indique hp");
        var hp = scanner.nextDouble();
        System.out.println("Indique maná");
        var mana = scanner.nextInt();
        System.out.println("Indique inteligencia");
        var intelligence = scanner.nextInt();

        return  new Wizard(name, id, hp, mana, intelligence);
    }

    private Warrior createWarrior() {
        System.out.println("Indique nombre");
        var name = scanner.next();
        System.out.println("Indique id");
        var id = scanner.next();
        System.out.println("Indique hp");
        var hp = scanner.nextDouble();
        System.out.println("Indique stamina");
        var stamina = scanner.nextInt();
        System.out.println("Indique fuerza");
        var strength = scanner.nextInt();

        return new Warrior(name, id, hp, stamina, strength);
    }

    private void partyViewer() {

    }
    //endregion

    //region Graveyard

    private void graveyardViewer() {
        graveyard.showGraveyard();
    }

    //endregion

    //region Battle
    private void battle() {

        String input;
        do {
            var menu = """
                    Welcome to the Battle - Which kind of battle do you want to do?
                    ===============
                    [0] - MANUAL BATTLE
                    [1] - AUTOMATED
                    
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(menu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> manualBattle();
                case "1" -> automatedBattle();
                case "back" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("back"));
    }

    private void manualBattle() {

        // TODO: party selection - if not enough parties, create them

        // TODO: select characters that will participate in the battle

        // TODO: Battle.oneVsOneBattle()

        // TODO: remove dead character from party and add it to the graveyard

    }

    private void automatedBattle() {

        // TODO: party selection - if not enough parties, create them

        // TODO: simulate battle - fully automated

    }


    //endregion

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

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }


}
