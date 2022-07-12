package com.ironhack.battle;

import com.ironhack.characters.Character;

public abstract class Battle {

    public static void oneVsOneBattle(Character firstCharacter, Character secondCharacter) {
        System.out.println("\n\n===========================");
        System.out.println("Battle between %s and %s is starting".formatted(firstCharacter.getName(), secondCharacter.getName()));
        while(firstCharacter.isAlive() && secondCharacter.isAlive()) {

            var firstCharAttack = firstCharacter.attack();
            printAttack(firstCharacter, firstCharAttack);

            var secondCharAttack = secondCharacter.attack();
            printAttack(secondCharacter, secondCharAttack);

            firstCharacter.setHp(firstCharacter.getHp() - secondCharAttack);
            printStateAfterAttack(firstCharacter);

            secondCharacter.setHp(secondCharacter.getHp() - firstCharAttack);
            printStateAfterAttack(secondCharacter);
        }
        System.out.println("\n\n===========================");
    }

    private static void printAttack(Character firstCharacter, double firstCharAttack) {
        System.out.println("%s attacks and does %s damage".formatted(firstCharacter.getName(), firstCharAttack));
    }

    private static void printStateAfterAttack(Character firstCharacter) {
        if(firstCharacter.isAlive()) {
            System.out.println("%s is now at %s hp".formatted(firstCharacter.getName(), firstCharacter.getHp()));
        }else {
            System.out.println("%s died :(".formatted(firstCharacter.getName()));
        }
    }

}
