package com.ironhack.ui;

import com.ironhack.Graveyard;
import com.ironhack.Party;
import com.ironhack.battle.Battle;
import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final Graveyard graveyard = new Graveyard();
    private Party party = new Party();
    public void main() {
        String input;
        do {
            var mainMenu = """
                    Welcome to Battle Simulator
                    ===============
                    [0]  - Show Graveyard
                    [1]  - Create Party
                    [2]  - Select a Party
                    [99] - Battle
                    
                    [exit] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> showGraveyard();
                case "1" -> createParty();
                case "2" -> selectParty();
                case "99" -> battle();
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }
        } while (!input.equals("exit"));
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

    //SOLO A MODO DE PRUEBA, EDITAR EN LA CLASE GRAVEYARD
    private void showGraveyard() {
        Graveyard graveyard = new Graveyard();

        var Merlin = new Wizard("Merlin", "3", 200,  500, 100);
        var VatoLoco = new Warrior("Vato Loco", "3", 200, 500, 100);

        graveyard.addDeadCharacter(Merlin);
        graveyard.addDeadCharacter(VatoLoco);

        graveyard.showGraveyard();
    }

    private void createParty() {
        String input;
        do {
            var mainMenu = """
                    Welcome to Battle Simulator
                    ===============
                    [0] - Add Warrior
                    [1] - Add Wizard
                    [2] - Random Wizard
                    [3] - Random Warrior
                    [4] - Random Party
                    
                    [exit] - Exit Battle Simulator
                    ===============
                    Write your COMMAND:
                    """;
            System.out.println(mainMenu);
            input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "0" -> party.addCharacter(createWarrior());
                case "1" -> party.addCharacter(createWizard());
                case "2" -> party.addCharacter(Wizard.generateRandom());
                case "3" -> party.addCharacter(Warrior.generateRandom());
                case "4" -> {
                    System.out.println("how many characters do you want?");
                    party.getRandomParty(scanner.nextInt());
                    party.membersParty();
                }
                case "exit" -> printWithColor("Bye bye", ConsoleColors.GREEN);
                default -> printWithColor("Command not recognized!", ConsoleColors.RED);
            }

        } while (!input.equals("exit"));
        party.addTeamToThePartyList(party.getMembers());
        party.setMembers(new ArrayList<Character>());

    }

    private void battle() {
        Character char1 = new Warrior("First Warrior", Character.generateId(), 200, 30, 10);
        Character char2 = new Wizard("First Wizard", Character.generateId(), 100,  40, 10);
        Battle.oneVsOneBattle(char1, char2);
    }

    private void selectParty() {
        party.returnList();
        System.out.println("A party you need to choice for the battle, give me the number");
        System.out.println(party.selectList(scanner.nextInt()));
    }

    public void printWithColor(String text, String color){
        System.out.println(color + text + ConsoleColors.RESET);
    }

}
