package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;

public class Wizard extends Character{

    private int mana;
    private int intelligence;
    private final int MINIMUM_HP = 50;
    private final int MAXIMUM_HP = 100;
    private final int MINIMUM_INTELLIGENCE = 1;
    private final int MAXIMUM_INTELLIGENCE = 50;
    private final int MINIMUM_MANA = 10;
    private final int MAXIMUM_MANA = 50;

    public  Wizard(){}

    public Wizard(String name, String id, double hp, boolean isAlive, int mana, int intelligence) {
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

    @Override
    public Character randomCharacter() {
        var faker = new Faker();
        Random num = new Random();

        super.setName(faker.name().firstName());
        super.setId(faker.idNumber().valid());
        super.setHp(Math.floor(num.nextDouble(MINIMUM_HP,MAXIMUM_HP) * 100 / 100));
        super.setAlive(true);
        setMana((int) num.nextDouble(MINIMUM_MANA,MAXIMUM_MANA));
        setIntelligence((int) num.nextDouble(MINIMUM_INTELLIGENCE,MAXIMUM_INTELLIGENCE));


        return new Wizard(getName(), getId(), getHp(), getIsAlive(), getMana(), getIntelligence());
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                ", mana=" + mana +
                ", intelligence=" + intelligence +
                '}';
    }

}
