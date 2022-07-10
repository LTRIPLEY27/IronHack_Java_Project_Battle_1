package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import java.util.ArrayList;
import java.util.Random;


public class Party {

    private static ArrayList<Character> members = new ArrayList<Character>();


    public Party() {}

    public ArrayList<Character> getMembers() {
        return members;
    }

    public void addCharacter(Character member) {
        for (Character character : members) {
            if (character.getName().equals(member.getName())) {
                member.setName(member.getName() + Character.SUFFIX_NAME);
                break;
            }
        }
        members.add(member);
    }

    public void membersParty() {
        for (Character member : members) {
            System.out.println(member.getName());
        }
    }

    public void removeMember(Character member) {
        members.remove(member);
    }


    public static void test() {
        Party party = new Party();

        Character Merlin = new Wizard("Merlin", "3", 1, true, 500, 100);
        Character VatoLoco = new Warrior("Vato Loco", "3", 200, true, 500, 100);
        Character VatoLoco2 = new Warrior("Vato Loco", "3", 200, true, 500, 100);

        party.addCharacter(Merlin);
        party.addCharacter(VatoLoco);
        party.membersParty();
        party.removeMember(VatoLoco2);

        party.membersParty();

    }

    public static ArrayList <Character> getRandomParty(int membersRand){
        Random random = new Random();
        final int WARRIOR = 1;

        for(int i = 0; i < membersRand; i++) {
            int randomValue = random.nextInt(1, 3);
            if(randomValue == WARRIOR) {
                members.add(Warrior.generateRandom());
            } else {
                members.add(Wizard.generateRandom());
            }
        }

        return members;
    }
}
