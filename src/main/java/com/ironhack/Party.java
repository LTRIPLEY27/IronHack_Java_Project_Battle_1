package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.ArrayList;

public class Party {

    private ArrayList<Character> members = new ArrayList<Character>();

    public Party() {}

    public void addCharacter(Character member) {
        members.add(member);
    }

    public void membersParty() {
        for (Character member : members) {
            System.out.println(member.getClass().getName());
        }
    }

    public static void test() {
        Party party = new Party();

        Character Merlin = new Wizard("Merlin", 3, 200, true, 500, 100);
        Character VatoLoco = new Warrior("Vato Loco", 3, 200, true, 500, 100);

        party.addCharacter(Merlin);
        party.addCharacter(VatoLoco);

        party.membersParty();

    }
}
