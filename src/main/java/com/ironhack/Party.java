package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Party {

    private List<Character> members = new ArrayList<Character>();


    public Party() {

    }
    public Party(List<Character> charactersList) {
        members = charactersList;
    }

    public List<Character> getMembers() {
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

    public void partyMembers() {
        for (Character member : members) {
            System.out.println(member.toString());
        }
    }

    public void removeMember(Character member) {
        members.remove(member);
    }


    public static void test() {
        Party party = new Party();

        Character Merlin = new Wizard("Merlin", Character.generateId(), 1,  500, 100);
        Character VatoLoco = new Warrior("Vato Loco", Character.generateId(), 200,  500, 100);
        Character VatoLoco2 = new Warrior("Vato Loco", Character.generateId(), 200, 500, 100);

        party.addCharacter(Merlin);
        party.addCharacter(VatoLoco);
        party.partyMembers();
        party.removeMember(VatoLoco2);

        party.partyMembers();

    }

    public static Party getRandomParty(int membersRand){
        var randomParty = new Party();
        Random random = new Random();
        final int WARRIOR = 1;

        for(int i = 0; i < membersRand; i++) {
            int randomValue = random.nextInt(1, 3);
            if(randomValue == WARRIOR) {
                randomParty.addCharacter(Warrior.generateRandom());
            } else {
                randomParty.addCharacter(Wizard.generateRandom());
            }
        }

        return randomParty;
    }
}
