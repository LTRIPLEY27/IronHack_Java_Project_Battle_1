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

    public Warrior(){

    }

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


    @Override
    public Character randomCharacter() {
        var faker = new Faker();
        Random num = new Random();
        super.setName(faker.name().firstName());
        super.setId(faker.idNumber().valid());
        super.setHp(Math.floor(num.nextDouble(MINIMUM_HP,MAXIMUM_HP) * 100 / 100));
        super.setAlive(true);
        setStamina((int) num.nextDouble(MINIMUM_STAMINA,MAXIMUM_STAMINA));
        setStrength((int) num.nextDouble(MINIMUM_STRENGTH,MAXIMUM_STRENGTH));


        return new Warrior(super.getName(), super.getId(), super.getHp(), super.getIsAlive(), getStamina(), getStrength());
    }

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
