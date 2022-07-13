package com.ironhack;
import com.ironhack.characters.Character;
import com.ironhack.characters.Wizard;
import com.ironhack.characters.Warrior;
import com.ironhack.ui.ConsoleColors;

import java.util.ArrayList;

public class Graveyard {
    ArrayList<Character> deadCharacters = new ArrayList<Character>();
    int wizardCount = 0;
    int warriorCount = 0;
    int othersCount = 0;
    int totalBodies = 0;

    public Graveyard() {
        ConsoleColors.printWithColor("""
                \nThe Graveyard has been created... 🪦🪦🪦
                ... ... no bodies have been buried yet... 🕊 
                🕸...🕷..... 🕸 \n
                """, ConsoleColors.BLUE_BRIGHT);
    }

    public int howManyDeadCharacters() {
        return totalBodies;
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
}
