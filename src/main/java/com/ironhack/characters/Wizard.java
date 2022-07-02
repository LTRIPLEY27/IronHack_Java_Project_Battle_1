package com.ironhack.characters;

public class Wizard extends Character{

    private int mana;
    private int intelligence;
    private final int MINIMUM_HP = 50;
    private final int MAXIMUM_HP = 100;
    private final int MINIMUM_INTELLIGENCE = 1;
    private final int MAXIMUM_INTELLIGENCE = 50;
    private final int MINIMUM_MANA = 10;
    private final int MAXIMUN_MANA = 50;

    public Wizard(String name, int id, double hp, boolean isAlive, int mana, int intelligence) {
        super(name, id, hp, isAlive);
        setMana(mana);
        setIntelligence(intelligence);
    }


    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

}
