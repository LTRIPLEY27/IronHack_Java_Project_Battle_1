package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Party {

    private String name = Faker.instance().team().name().replace(" ", "-").replace(".","");

    private final List<Character> members = new ArrayList<Character>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Party() {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Party named %s - has ".formatted(getName()));
        var warriors = 0;
        var wizards = 0;
        for (Character member : members) {
            if(member instanceof Wizard) {
                wizards++;
            }else if(member instanceof Warrior) {
                warriors++;
            }
        }
        sb.append(warriors).append(" warriors and ").append(wizards).append(" wizards in it");
        return sb.toString();
    }

    public static Party getRandomParty() {
        var randomParty = new Party();
        final int WARRIOR = 1;
        Random random = new Random();
        var numberOfMembers = random.nextInt(3,5);

        for (int i = 0; i < numberOfMembers; i++) {
            int randomValue = random.nextInt(1, 3);
            if (randomValue == WARRIOR) {
                randomParty.addCharacter(Warrior.generateRandom());
            } else {
                randomParty.addCharacter(Wizard.generateRandom());
            }
        }

        return randomParty;
    }
}


