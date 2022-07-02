package com.ironhack;

import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import com.ironhack.characters.Character;

import java.util.ArrayList;

public class Party {

    static ArrayList<Character> members;

    public Party() {
        this.members = new ArrayList<Character>();
    }

    public static void addCharacter(Character member) {
        members.add(member);
    }

    public void membersParty() {
        for (Character member : members) {
            System.out.println(member.getClass().getName());
        }
    }

    public static void test(){
        Party party = new Party();

        Character Merlin = new Wizard("Merlin", 3, 200, true, 500, 100);
        Character VatoLoco = new Warrior("Vato Loco", 3, 200, true, 500, 100);

        Party.addCharacter(Merlin);
        Party.addCharacter(VatoLoco);

        party.membersParty();
    }
}
