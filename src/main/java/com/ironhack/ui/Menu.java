package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Graveyard graveyard = new Graveyard();
    private final List<Party> parties = new ArrayList<>();

    public void main() {
        String input;
        do {
            var mainMenu = """
                    Welcome to Battle Simulator
                    You currently have %s parties created and %s characters on the graveyard
                    ===============
                    [1] - PARTY MANAGER
                    [2] - VIEW GRAVEYARD
                    [3] - BATTLE
                    
                    [EXIT] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """.formatted(parties.size(), graveyard.howManyDeadCharacters());
            ConsoleColors.printWithColor(mainMenu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> partyManager();
                case "2" -> graveyardViewer();
                case "3" -> battle();
                case "exit" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
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
                    [1] - VIEW PARTIES
                    [2] - CREATE PARTY
                    
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> partyViewer();
                case "2" -> createParty();
                case "back" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("back"));
    }

    //region Party
    private void partyViewer() {
        String input;
        do {
            var menu = """
                    Welcome to Party Viewer
                    ===============
                    
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "back" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("back"));
    }

    private void createParty() {
        String input;
        Party party = new Party();
        do {
            var menu = """
                    Welcome to Party Creator
                    ===============
                    [1] - Add Warrior
                    [2] - Add Wizard
                    [3] - View current party
                    
                    [SAVE] - SAVE THIS PARTY
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> party.addCharacter(createWarrior());
                case "2" -> party.addCharacter(createWizard());
                case "3" -> party.membersParty();
                case "save" -> {
                    parties.add(party);
                    ConsoleColors.printWithColor("Party saved", ConsoleColors.GREEN);
                }
                case "back" ->
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("back") && !input.equals("save"));
    }

    private Wizard createWizard() {
        ConsoleColors.printWithColor("You are creating a new Wizard", ConsoleColors.GREEN_BACKGROUND);
        ConsoleColors.printWithColor("Indique nombre", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var name = scanner.next();
        ConsoleColors.printWithColor("Indique hp", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var hp = scanner.nextDouble();
        ConsoleColors.printWithColor("Indique maná", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var mana = scanner.nextInt();
        ConsoleColors.printWithColor("Indique inteligencia", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var intelligence = scanner.nextInt();

        var wizardCreated=  new Wizard(name, Character.generateId(), hp, mana, intelligence);
        ConsoleColors.printWithColor("Wizard %s created!".formatted(wizardCreated.getName()), ConsoleColors.GREEN_BACKGROUND);
        return wizardCreated;
    }

    private Warrior createWarrior() {
        ConsoleColors.printWithColor("You are creating a new Warrior", ConsoleColors.GREEN_BACKGROUND);
        ConsoleColors.printWithColor("Indique nombre", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var name = scanner.next();
        ConsoleColors.printWithColor("Indique hp", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var hp = scanner.nextDouble();
        ConsoleColors.printWithColor("Indique stamina", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var stamina = scanner.nextInt();
        ConsoleColors.printWithColor("Indique fuerza", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var strength = scanner.nextInt();

        var warriorCreated = new Warrior(name, Character.generateId(), hp, stamina, strength);
        ConsoleColors.printWithColor("Warrior %s created!".formatted(warriorCreated.getName()), ConsoleColors.GREEN_BACKGROUND);
        return warriorCreated;
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
                    [1] - MANUAL BATTLE
                    [2] - AUTOMATED
                    
                    [BACK] - GO BACK
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> manualBattle();
                case "2" -> automatedBattle();
                case "back" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
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


}
