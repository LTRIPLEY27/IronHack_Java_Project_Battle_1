package com.ironhack;
import com.ironhack.characters.Character;
import com.ironhack.characters.Wizard;
import com.ironhack.characters.Warrior;
import java.util.ArrayList;

public class Graveyard {
    ArrayList<Character> deadCharacters;
    int wizardCount = 0;
    int warriorCount = 0;
    int othersCount = 0;
    int totalBodies = 0;

    public Graveyard() {
        this.deadCharacters = new ArrayList<Character>();
        System.out.println("The Graveyard has been created... 🪦🪦🪦");
        System.out.println("... ... no bodies have been buried yet... 🕊 ");
        System.out.println("🕸...🕷..... 🕸\n");
    }

    public void addDeadCharacter(Character deadCharacter) {
        deadCharacters.add(deadCharacter);
        if (deadCharacter instanceof Wizard) {
            System.out.println("🧙‍ "+deadCharacter.getName() + "'s magic is over. A magical soul is now moving to the other world 🪦");
            wizardCount++;
        }else if (deadCharacter instanceof Warrior){
            System.out.println("💂‍ " + deadCharacter.getName()+" is dead. A legendary fighter has past away 🪦");
            warriorCount++;
        }else{
            System.out.println("💂‍ " + deadCharacter.getName()+" is dead. who was this person? 🪦");
            othersCount++;
        }
        totalBodies = wizardCount + warriorCount + othersCount;
    }

    public void showGraveyard(){
        System.out.println("\n✝✝✝🪦GRAVEYARD🪦✝✝✝");
        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");

        if (deadCharacters.isEmpty()){
            System.out.println("the graveyard is empty 🕊");
        }else{
            for (Character character : deadCharacters) {
                if (character instanceof Wizard) {
                    System.out.println("🪦 " + character.getName() + " lies here. 🧙‍");
                }else if (character instanceof Warrior){
                    System.out.println("🪦 " + character.getName()+" lies here. 💂‍");
                }else{
                    System.out.println("🪦 " + character.getName()+" lies here. 💀");
                }
            }
        }
        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");
    }

    public void showGraveyardByClass(){
        System.out.println("\n✝✝✝🪦GRAVEYARD🪦✝✝✝");
        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");

        if (deadCharacters.isEmpty()) {
            System.out.println("the graveyard is empty 🕊");

        } else {
            System.out.println("... in the Graveyard are "+ totalBodies+" bodies buried...");
            System.out.println("🪦...🪦.........🪦...🪦🪦🪦......🪦");

            if (wizardCount!=0){
                System.out.println("\nThe Graveyard has "+wizardCount+" dead wizards...");
                for (Character character : deadCharacters) {
                    if (character instanceof Wizard) {System.out.println("🪦 " + character.getName() + " lies here. 🧙‍");}
                }
            }
            if (warriorCount!=0) {
                System.out.println("\nThe Graveyard has "+warriorCount+" dead warriors...");
                for (Character character : deadCharacters) {
                    if (character instanceof Warrior) {System.out.println("🪦 " + character.getName() + " lies here. 💂‍");}
                }
            }
            if (othersCount!=0) {
                for (Character character : deadCharacters) {
                    if (!(character instanceof Warrior) && !(character instanceof Wizard)) {System.out.println("🪦 " + character.getName() + " lies here. 💀");}
                }
            }
        }
        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");
    }



    /*************************************************
     * TEST
     *************************************************/
    public static void test(){
        Graveyard graveyard = new Graveyard();

        var Merlin = new Wizard("Merlin", 3, 200, true, 500, 100);
        var VatoLoco = new Warrior("Vato Loco", 3, 200, true, 500, 100);
        var Johnny = new Warrior("Johnny", 3, 200, true, 500, 100);
        var Maria = new Wizard("Maria", 3, 200, true, 500, 100);
        var Paco = new Warrior("Paco", 3, 200, true, 500, 100);
        var Hugo = new Warrior("Hugo", 3, 200, true, 500, 100);


        graveyard.addDeadCharacter(Merlin);
        graveyard.addDeadCharacter(VatoLoco);
        graveyard.addDeadCharacter(Johnny);
        graveyard.addDeadCharacter(Maria);
        graveyard.addDeadCharacter(Paco);
        graveyard.addDeadCharacter(Hugo);


        graveyard.showGraveyard();
        graveyard.showGraveyardByClass();

        if (deadWizards.isEmpty()){
            System.out.println("none");
        }else{
            for (Wizard wizard : deadWizards) {
                System.out.println("🪦 " + wizard.getName());
            }
        }

        System.out.println("DEADWARRIORS: ");

        if (deadWarriors.isEmpty()){
            System.out.println("none");
        }else {
            for (Warrior warrior: deadWarriors){
                System.out.println("🪦 "+warrior.getName());
            }
        }

        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");


    }


    /**
     * When a warrior dies use this method to add the warrior to
     * the graveyard.
     */
    public void addDeadCharacter(Warrior deadWarrior) {
        deadWarriors.add(deadWarrior);
        System.out.println(deadWarrior.getName() + " is dead. A legendary fighter has past away 🪦");

    }


    /**
     * When a wizard dies use this method to add the wizard to
     * the graveyard.
     */
    public void addDeadCharacter(Wizard deadWizard) {
        deadWizards.add(deadWizard);
        System.out.println(deadWizard.getName() + " magic is over. A magical soul is now moving to the other world 🪦");
    }
}
