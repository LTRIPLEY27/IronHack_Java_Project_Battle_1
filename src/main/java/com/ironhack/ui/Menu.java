package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
import com.ironhack.battle.Battle;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import com.ironhack.tools.PartyDocuments;

import java.io.IOException;
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
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                        ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("exit"));
    }

    // region Party
    private void partyManager() {
        String input;
        do {
            var menu = """
                    Welcome to Party Manager
                    ===============
                    [1] - VIEW PARTIES
                    [2] - CREATE PARTY MANUALLY
                    [3] - CREATE PARTY RANDOMNLY
                    [4] - IMPORT PARTY FROM CSV

                    [B] - GO BACK
                    [EXIT] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> partyViewer();
                case "2" -> createParty();
                case "3" -> createPartyRandomly();
                case "4" -> importParty();
                case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                        ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("b"));
    }

    private void createPartyRandomly() {
        ConsoleColors.printWithColor("""
                ====================
                Creating a random party, you can sit back and chill
                ====================
                """, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        var randomParty = Party.getRandomParty();
        parties.add(randomParty);
        ConsoleColors.printWithColor("""
                ====================
                PARTY CREATED!
                This is it -> %s
                ====================
                """.formatted(randomParty.toString()), ConsoleColors.BLACK_BACKGROUND_BRIGHT);

    }

    private void importParty() {
        var party = PartyDocuments.getPartyFromFile();
        if (party != null) {
            parties.add(party);
        }
    }

    // region Party
    private void partyViewer() {
        String input;
        Party partySelected = null;
        do {
            var menu = """
                    Welcome to Party Viewer
                    ===============
                    """;

            var menu2 = """
                    [B] - GO BACK
                    [EXIT] - Exit Battle Simulator
                    ===============
                    Select the party you want:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            if (parties.isEmpty()) {
                ConsoleColors.printWithColor("You have 0 parties", ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            } else {
                for (int i = 0; i < parties.size(); i++) {
                    ConsoleColors.printWithColor("[" + i + "] " + parties.get(i).toString(), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                }
            }
            ConsoleColors.printWithColor(menu2, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> {
                    try {
                        var index = Integer.parseInt(input);
                        partySelected = parties.get(index);
                        ConsoleColors.printWithColor(partySelected.toString(), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                    } catch (Exception e) {
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                                ConsoleColors.RED_BACKGROUND);
                    }
                }
            }
        } while (!input.equals("b") && partySelected == null);

        if (partySelected != null) {
            do {
                var menu = """
                        Welcome to Party Manager
                        ===============
                        [1] - VIEW MEMBERS
                        [2] - EXPORT PARTY TO CSV
                        [3] - DELETE PARTY

                        [B] - GO BACK
                        [EXIT] - Exit Battle Simulator
                        ===============
                        Write your COMMAND:
                        """;
                ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                input = scanner.nextLine().trim().toLowerCase();
                switch (input) {
                    case "1" -> {
                        partySelected.partyMembers();
                    }
                    case "2" -> {
                        try {
                            ConsoleColors.printWithColor("""
                                    ==============
                                    Exporting party to csv...
                                    ....
                                    ....
                                    bzzzzzz....
                                    ....
                                    ....
                                    brrrrr....
                                    ....
                                    more noise... (are we using a fax machine...?)
                                    ....
                                    ...
                                    ...
                                    ..
                                    """, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                            var path = PartyDocuments.writeToFile(partySelected);

                            ConsoleColors.printWithColor("""
                                    Finally the file is exported.
                                    You can find it at: %s
                                    ===============
                                    """.formatted(path), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                        } catch (IOException e) {
                            ConsoleColors.printWithColor("""
                                    Something did not go well...
                                    I knew some of those noises could not be good...
                                    ===============
                                    """, ConsoleColors.RED_BACKGROUND);
                        }
                    }
                    case "3" -> {
                        deleteParty(partySelected);
                        partySelected = null;
                    }
                    case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    case "exit" -> {
                        ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                        System.exit(1);
                    }
                    default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                            ConsoleColors.RED_BACKGROUND);
                }
            } while (!input.equals("b") && partySelected != null);
        }

    }

    private void deleteParty(Party party) {
        parties.remove(party);
        ConsoleColors.printWithColor("Party deleted!", ConsoleColors.RED_BACKGROUND);

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

                    [S] - SAVE THIS PARTY
                    [B] - GO BACK
                    [EXIT] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> party.addCharacter(createWarrior());
                case "2" -> party.addCharacter(createWizard());
                case "3" -> party.partyMembers();
                case "s" -> {
                    parties.add(party);
                    ConsoleColors.printWithColor("Party saved", ConsoleColors.GREEN);
                }
                case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                        ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("b") && !input.equals("s"));
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
        ConsoleColors.printWithColor("Wizard %s created!".formatted(wizardCreated.getName()),
                ConsoleColors.GREEN_BACKGROUND);
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
        ConsoleColors.printWithColor("Warrior %s created!".formatted(warriorCreated.getName()),
                ConsoleColors.GREEN_BACKGROUND);
        return warriorCreated;
    }
    // endregion

    // region Graveyard

    private void graveyardViewer() {
        graveyard.showGraveyard();
    }

    // endregion

    // region Battle
    private void battle() {

        String input;
        do {
            var menu = """
                    Welcome to the Battle - Which kind of battle do you want to do?
                    ===============
                    [1] - MANUAL BATTLE
                    [2] - AUTOMATED

                    [B] - GO BACK
                    [EXIT] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            ConsoleColors.printWithColor(menu, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1" -> manualBattleMenu();
                case "2" -> automatedBattleMenu();
                case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                        ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("b"));
    }

    private void manualBattleMenu() {
        ConsoleColors.printWithColor("""
                                            
                        ===============
                        Welcome to the Battle part of this Battle Simulator!
                        I'm sure you can't wait to start but first we need to check some things...
                                            
                        """,
                ConsoleColors.PURPLE_BACKGROUND);

        if (parties.size() < 2) {
            ConsoleColors.printWithColor("""
                            You don't have enough parties. Go back and fix it!
                            ===============
                                                
                            """,
                    ConsoleColors.RED_BACKGROUND);
        } else {
            Party partyA = null;
            Party partyB = null;
            ConsoleColors.printWithColor("""
                            There are enough parties.
                            First you have to choose the two that will fight!
                            """,
                    ConsoleColors.PURPLE_BACKGROUND);
            String input;
            do {
                for (int i = 0; i < parties.size(); i++) {
                    if (partyA != null && partyA.equals(parties.get(i))) {
                        continue;
                    }
                    ConsoleColors.printWithColor("[" + i + "] " + parties.get(i).toString(), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                }
                input = scanner.nextLine().trim().toLowerCase();
                switch (input) {
                    case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    case "exit" -> {
                        ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                        System.exit(1);
                    }
                    default -> {
                        try {
                            var index = Integer.parseInt(input);
                            if (partyA == null) {
                                partyA = parties.get(index);
                                ConsoleColors.printWithColor("Selected: " + partyA.toString(), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                            } else {
                                partyB = parties.get(index);
                                ConsoleColors.printWithColor("Selected: " + partyB.toString(), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                            }
                        } catch (Exception e) {
                            ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                                    ConsoleColors.RED_BACKGROUND);
                        }
                    }
                }
            } while (!input.equals("b") && (partyA == null || partyB == null));

            if (partyA != null && partyB != null) {

                do{
                    Character characterPartyA = selectCharacter(partyA);
                    Character characterPartyB = selectCharacter(partyB);

                    Battle.oneVsOneBattle(characterPartyA, characterPartyB);

                    if (!characterPartyA.isAlive()) {
                        partyA.removeMember(characterPartyA);
                        graveyard.addDeadCharacter(characterPartyA);
                    }
                    if (!characterPartyB.isAlive()) {
                        partyB.removeMember(characterPartyB);
                        graveyard.addDeadCharacter(characterPartyB);
                    }
                }while (!partyA.getMembers().isEmpty() && !partyB.getMembers().isEmpty());

                Party winner = null;

                if(partyA.getMembers().isEmpty()) winner = partyB;
                else if(partyB.getMembers().isEmpty()) winner = partyA;

                var battleEnd = """

                We have a winner!!!
                                
                %s won!! Congratulations! I hope it was the party you chose.

                """.formatted(winner.getName());


                ConsoleColors.printWithColor(battleEnd, ConsoleColors.BLUE_BACKGROUND);

                ConsoleColors.printWithColor("Press enter to continue...", ConsoleColors.PURPLE_BACKGROUND);
                scanner.nextLine();

            }

        }

    }

    private Character selectCharacter(Party party) {
        Character selectedCharacter = null;
        ConsoleColors.printWithColor("""
                        Select your combatant!
                        """,
                ConsoleColors.PURPLE_BACKGROUND);
        String input;
        do {
            for (int i = 0; i < party.getMembers().size(); i++) {
                ConsoleColors.printWithColor("[" + i + "] " + party.getMembers().get(i), ConsoleColors.BLACK_BACKGROUND_BRIGHT);
            }
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "b" -> ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> {
                    try {
                        var index = Integer.parseInt(input);
                        selectedCharacter = party.getMembers().get(index);
                        ConsoleColors.printWithColor("Selected: " + selectedCharacter, ConsoleColors.BLACK_BACKGROUND_BRIGHT);
                    } catch (Exception e) {
                        ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                                ConsoleColors.RED_BACKGROUND);
                    }
                }
            }
        } while (!input.equals("b") && selectedCharacter == null);
        return selectedCharacter;
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
                case "exit" -> {
                    ConsoleColors.printWithColor("Bye bye", ConsoleColors.GREEN);
                    System.exit(1);
                }
                default -> ConsoleColors.printWithColor("Command not recognized! - %s".formatted(input),
                        ConsoleColors.RED_BACKGROUND);
            }
        } while (!input.equals("n"));

    }

    private void automatedBattle() {

        ConsoleColors.printWithColor("""
                ===================
                """, ConsoleColors.PURPLE_BACKGROUND);

        if (parties.size() <= 2) {

            do {
                parties.add(Party.getRandomParty());
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


        ConsoleColors.printWithColor("Press enter to continue...", ConsoleColors.PURPLE_BACKGROUND);
        scanner.nextLine();


        Party partyA = parties.get(0);
        Party partyB = parties.get(1);
        System.out.println(partyA.getMembers().size());
        System.out.println(partyB.getMembers().size());

        Party winner = null;
        do {
            if (partyA.getMembers().isEmpty())
                winner = partyB;
            else if (partyB.getMembers().isEmpty())
                winner = partyA;
            else {
                var charA = partyA.getMembers().get(0);
                var charB = partyB.getMembers().get(0);

                ConsoleColors.printWithColor(
                        """

                                =================
                                Let's Battle!!

                                This battle will be between %s and %s
                                they are a %s and a %s

                                =================

                                """.formatted(charA.getName(), charB.getName(),
                                charA instanceof Warrior ? "warrior" : "wizard",
                                charB instanceof Warrior ? "warrior" : "wizard"),
                        ConsoleColors.PURPLE_BACKGROUND);

                Battle.oneVsOneBattle(charA, charB);
                if (!charA.isAlive()) {

                    ConsoleColors.printWithColor("""
                            %s just passwed away
                            """.formatted(charA.getName()), ConsoleColors.PURPLE_BACKGROUND);

                    partyA.removeMember(charA);
                    graveyard.addDeadCharacter(charA);
                }
                if (!charB.isAlive()) {

                    partyB.removeMember(charB);
                    graveyard.addDeadCharacter(charB);
                }

            }
        } while (winner == null);

        var battleEnd = """

                We have a winner!!!
                                
                %s won!! Congratulations! I hope it was the party you chose.

                """.formatted(winner.getName());
        ConsoleColors.printWithColor(battleEnd, ConsoleColors.BLUE_BACKGROUND);

        ConsoleColors.printWithColor("Press enter to continue...", ConsoleColors.PURPLE_BACKGROUND);
        scanner.nextLine();

    }

    // endregion

}
