package com.ironhack;

import com.ironhack.characters.Character;
import com.ironhack.characters.Warrior;
import com.ironhack.characters.Wizard;
import com.ironhack.ui.Menu;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.main();

        Graveyard.test();

        Warrior warlock = new Warrior();
        Wizard lizard = new Wizard();
        lizard.randomCharacter();
        System.out.println(lizard.toString()
        );

        warlock.randomCharacter();
        System.out.println(warlock.toString());

    }


}