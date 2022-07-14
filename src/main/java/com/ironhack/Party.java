package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;

import java.util.*;


public class Party {

    private ArrayList<Character> members = new ArrayList<Character>();
    private ArrayList< ArrayList <Character>> parties = new ArrayList<ArrayList<Character>>();
    public Party(){}

    public void setMembers(ArrayList<Character> members) {
        this.members = members;
    }

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
        party.membersParty();
        party.removeMember(VatoLoco2);

        party.membersParty();

    }

    public  ArrayList <Character> getRandomParty(int membersRand){
        final int WARRIOR = 1;

        for(int i = 0; i < membersRand; i++) {
            if(new Random().nextInt(1,3) == WARRIOR) {
                members.add(Warrior.generateRandom());
            } else {
                members.add(Wizard.generateRandom());
            }
        }
        return members;
    }

    public void addTeamToThePartyList(ArrayList<Character> team){

        parties.add(team);
    }

    public  void returnList() {
        int f = 1;
        for(var i : parties) {
            System.out.println("Party number : " + f + "\n" + i);
            f++;
        }
    }

    public ArrayList <Character> selectList(int choice) {
        int election = choice - 1;
        return parties.get(election);
    }
    }


