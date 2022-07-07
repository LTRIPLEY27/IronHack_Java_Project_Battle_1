package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;

public class Warrior extends Character {

    private int stamina;
    private int strength;

    private final int MINIMUM_STAMINA = 10;
    private final int MAXIMUM_STAMINA = 50;
    private final int MINIMUM_HP = 100;
    private final int MAXIMUM_HP = 200;
    private final int MAXIMUM_STRENGTH = 10;
    private final int MINIMUM_STRENGTH = 1;

    public Warrior(String name, String id, double hp, boolean isAlive, int stamina, int strength) {
        super(name, id, hp, isAlive);
        setStamina(stamina);
        setStrength(strength);
    }


    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }

    //public Warrior gettingWarrior() {
    public void gettingWarrior() {
        Random num = new Random();

        setHp(Math.floor(num.nextDouble(MINIMUM_HP,MAXIMUM_HP) * 100 / 100));
        setStamina((int) num.nextDouble(MINIMUM_STAMINA,MAXIMUM_STAMINA));
        setStrength((int) num.nextDouble(MINIMUM_STRENGTH,MAXIMUM_STRENGTH));

        //new Warrior(Character.randomName, Character.randomId, getHp(), Character.randomIsAlive, getStamina(), getStrength());

        System.out.println(new Warrior(Character.randomName, Character.randomId, getHp(), Character.randomIsAlive, getStamina(), getStrength()));
       // return new Warrior(Character.randomName, Character.randomId, getHp(), Character.randomIsAlive, getStamina(), getStrength());
    }
/*
    public Warrior gettingWarrior(){
        Random num = new Random();

        setHp(Math.floor(num.nextDouble(MINIMUM_HP,MAXIMUM_HP) * 100 / 100));
        setStamina((int) num.nextDouble(MINIMUM_STAMINA,MAXIMUM_STAMINA));
        setStrength((int) num.nextDouble(MINIMUM_STRENGTH,MAXIMUM_STRENGTH));

        return new Warrior(Character.generatedCharacter().getName(), Character.generatedCharacter().getId(), getHp(), Character.generatedCharacter().getIsAlive(), getStamina(), getStrength());
    }
*/
    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }
}
