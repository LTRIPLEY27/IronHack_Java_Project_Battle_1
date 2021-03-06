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
                \nThe Graveyard has been created... πͺ¦πͺ¦πͺ¦
                ... ... no bodies have been buried yet... π 
                πΈ...π·..... πΈ \n
                """, ConsoleColors.BLUE_BRIGHT);
    }

    public int howManyDeadCharacters() {
        return totalBodies;
    }

    public void addDeadCharacter(Character deadCharacter) {
        deadCharacters.add(deadCharacter);
        if (deadCharacter instanceof Wizard) {
            System.out.println("π§β "+deadCharacter.getName() + "'s magic is over. A magical soul is now moving to the other world πͺ¦");
            wizardCount++;
        }else if (deadCharacter instanceof Warrior){
            System.out.println("πβ " + deadCharacter.getName()+" is dead. A legendary fighter has past away πͺ¦");
            warriorCount++;
        }else{
            System.out.println("πβ " + deadCharacter.getName()+" is dead. who was this person? πͺ¦");
            othersCount++;
        }
        totalBodies = wizardCount + warriorCount + othersCount;
    }

    public void showGraveyard(){
        System.out.println("\nβββπͺ¦GRAVEYARDπͺ¦βββ");
        System.out.println("βββββββββββββββββββ");

        if (deadCharacters.isEmpty()){
            System.out.println("the graveyard is empty π");
        }else{
            for (Character character : deadCharacters) {
                if (character instanceof Wizard) {
                    System.out.println("πͺ¦ " + character.getName() + " lies here. π§β");
                }else if (character instanceof Warrior){
                    System.out.println("πͺ¦ " + character.getName()+" lies here. πβ");
                }else{
                    System.out.println("πͺ¦ " + character.getName()+" lies here. π");
                }
            }
        }
        System.out.println("βββββββββββββββββ");
    }

    public void showGraveyardByClass(){
        System.out.println("\nβββπͺ¦GRAVEYARDπͺ¦βββ");
        System.out.println("βββββββββββββββββββ");

        if (deadCharacters.isEmpty()) {
            System.out.println("the graveyard is empty π");

        } else {
            System.out.println("... in the Graveyard are "+ totalBodies+" bodies buried...");
            System.out.println("πͺ¦...πͺ¦.........πͺ¦...πͺ¦πͺ¦πͺ¦......πͺ¦");

            if (wizardCount!=0){
                System.out.println("\nThe Graveyard has "+wizardCount+" dead wizards...");
                for (Character character : deadCharacters) {
                    if (character instanceof Wizard) {System.out.println("πͺ¦ " + character.getName() + " lies here. π§β");}
                }
            }
            if (warriorCount!=0) {
                System.out.println("\nThe Graveyard has "+warriorCount+" dead warriors...");
                for (Character character : deadCharacters) {
                    if (character instanceof Warrior) {System.out.println("πͺ¦ " + character.getName() + " lies here. πβ");}
                }
            }
            if (othersCount!=0) {
                for (Character character : deadCharacters) {
                    if (!(character instanceof Warrior) && !(character instanceof Wizard)) {System.out.println("πͺ¦ " + character.getName() + " lies here. π");}
                }
            }
        }
        System.out.println("βββββββββββββββββ");
    }
}
