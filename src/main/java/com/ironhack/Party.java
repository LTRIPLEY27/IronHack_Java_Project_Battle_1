package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import java.util.ArrayList;



public class Party {

    private ArrayList<Character> members = new ArrayList<Character>();


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

        Character Merlin = new Wizard("Merlin", 3, 1, true, 500, 100);
        Character VatoLoco = new Warrior("Vato Loco", 3, 200, true, 500, 100);
        Character VatoLoco2 = new Warrior("Vato Loco", 3, 200, true, 500, 100);

        party.addCharacter(Merlin);
        party.addCharacter(VatoLoco);
        party.membersParty();
        party.removeMember(VatoLoco2);

        party.membersParty();

    }
}
