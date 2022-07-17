package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    ArrayList<Character> members;
    ArrayList< ArrayList <Character>> parties;


    @BeforeEach
    void setUp() {
        members =  new ArrayList<Character>(Arrays.asList(new Warrior("Peter", "2", 12.26, 52, 86), new Warrior("Louis", "3", 85.96, 10, 25), new Wizard("Thelma", "5", 41, 85, 77)));
        parties =  new ArrayList<ArrayList<Character>>();
    }

    @Test
    @DisplayName("Testing add character OK")
    void addCharacterOK_Character() {
        Wizard Gandalf = new Wizard("Gandalf the grey", "1", 250, 200, 320);
        int expectedSize = members.size() + 1;
        members.add(Gandalf);

        assertEquals(expectedSize, members.size());
    }

    @Test
    @DisplayName("Testing add character NotOK")
    void addCharacterNotOK_Character() {
        Wizard Gandalf = new Wizard("Gandalf the grey", "1", 250, 200, 320);
        int expectedSize = members.size();
        members.add(Gandalf);

        assertNotEquals(expectedSize, members.size());
    }

    @Test
    @DisplayName("Testing members")
    void membersPartyOk_Character() {
        assertEquals("Louis", members.get(1).getName());
    }

    @Test
    @DisplayName("Testing exception Nullpointer")
    void membersPartyOk_Character_NullPointer() {
        members.add(null);
        assertNull(members.get(3));
    }

    @Test
    void removeMember_OK_Character() {
        //assertEquals();
    }

    @Test
    void test1() {
    }

    @Test
    void getRandomParty() {
    }

    @Test
    void addTeamToThePartyList() {
    }

    @Test
    void returnList() {
    }

    @Test
    void selectList() {
    }
}