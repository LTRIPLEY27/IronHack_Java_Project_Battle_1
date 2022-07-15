package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
import com.ironhack.battle.Battle;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.*;


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
                default ->
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
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
                default ->
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
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
                    [1] - Remove Party
                                        
                    [BACK] - GO BACK
                    ==============="
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> removeParty();
                case "back" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default ->
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("back"));
    }

    private void removeParty() {
        var id = 0;
        int input = id;
        ConsoleColors.printWithColor("Choose which party to delete", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        id = Integer.parseInt(scanner.next());
        try {
            parties.remove(id);
            ConsoleColors.printWithColor("Party deleted!", ConsoleColors.RED_BACKGROUND);
        } catch (Exception e) {
            ConsoleColors.printWithColor("Invalid number", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            removeParty();
        }
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
                case "back" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default ->
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
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

        var wizardCreated = new Wizard(name, Character.generateId(), hp, mana, intelligence);
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
                case "2" -> automatedBattleMenu();
                case "back" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                default ->
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("back"));
    }

    private void manualBattle() {

        // TODO: party selection - if not enough parties, create them

        // TODO: select characters that will participate in the battle

        // TODO: Battle.oneVsOneBattle()

        // TODO: remove dead character from party and add it to the graveyard

    }

    private void automatedBattleMenu() {

        var text = """
                                
                ===================
                An automated battle is starting...
                We will create random parties if there are not enough to simulate a battle.
                You will be also tasked with starting each battle
                So... without further ado...
                LET'S BATTLE!
                ===================
                                
                ARE YOU READY ?
                [Y] - Start battle
                [N] - Go back and rethink your life choices
                               
                """;

        String input;
        do {
            ConsoleColors.printWithColor(text, ConsoleColors.PURPLE_BACKGROUND);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "y" -> automatedBattle();
                case "n" ->
                        ConsoleColors.printWithColor("I knew you weren't ready...\n\n", ConsoleColors.PURPLE_BACKGROUND);
                default ->
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input), ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("n"));

    }

    private void automatedBattle() {

        ConsoleColors.printWithColor("""
                ===================
                """, ConsoleColors.PURPLE_BACKGROUND);

        if (parties.size() <= 2) {

            do {
                parties.add(Party.getRandomParty((new Random()).nextInt(0, 5)));
            } while (parties.size() <= 2);

            var noPartiesText = """
                                    
                    There aren't enough parties.
                    We just created some, as you seem to be unprepared.
                                   
                    """;

            ConsoleColors.printWithColor(noPartiesText, ConsoleColors.PURPLE_BACKGROUND);
        }

        var enoughPartiesText = """
                                
                Ok, now it seems we have some parties to play with
                Let's hope they have good fighters
                ===================
                               
                """;
        ConsoleColors.printWithColor(enoughPartiesText, ConsoleColors.PURPLE_BACKGROUND);

        Party partyA = parties.get(0);
        Party partyB = parties.get(1);


        String input;
        Party winner = null;
        do {
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                default ->
                {
                    if(partyA.getMembers().isEmpty()) winner = partyB;
                    else if(partyB.getMembers().isEmpty()) winner = partyA;
                    else {
                        var charA = partyA.getMembers().get(0);
                        var charB = partyB.getMembers().get(0);

                        ConsoleColors.printWithColor("""
                                
                                =================
                                Let's Battle!!
                                
                                This battle will be between %s and %s
                                they are a %s and a %s
                                
                                =================
                                
                                """.formatted(charA.getName(), charB.getName(), charA instanceof Warrior ? "warrior" : "wizard", charB instanceof Warrior ? "warrior" : "wizard"), ConsoleColors.PURPLE_BACKGROUND);

                        Battle.oneVsOneBattle(charA, charB);
                        if(!charA.isAlive()) {

                            ConsoleColors.printWithColor("""
                                    %s just passwed away
                                    """.formatted(charA.getName()), ConsoleColors.PURPLE_BACKGROUND);

                            partyA.removeMember(charA);
                            graveyard.addDeadCharacter(charA);
                        }
                        if(!charB.isAlive()) {

                            partyB.removeMember(charB);
                            graveyard.addDeadCharacter(charB);
                        }

                    }
                }
            }
        } while (input.equals("g") && winner == null);

        var battleEnd = """
                
                We have a winner!!!
                
                """;
        ConsoleColors.printWithColor(battleEnd, ConsoleColors.YELLOW_BACKGROUND);

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
