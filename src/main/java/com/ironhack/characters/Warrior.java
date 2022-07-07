package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;
import java.util.UUID;

public class Warrior extends Character {

    public static final int STAMINA_ATTACK_THRESHOLD = 5;
    public static final int HEAVY_ATTACK_STAMINA_USAGE = -5;
    public static final int WEAK_ATTACK_STAMINA_USAGE = 1;
    public static final double WEAK_ATTACK_MULTIPLIER = 0.5;

    private int stamina;
    private int strength;

    private static final int MINIMUM_STAMINA = 10;
    private static final int MAXIMUM_STAMINA = 50;
    private static final int MINIMUM_HP = 100;
    private static final int MAXIMUM_HP = 200;
    private static final int MAXIMUM_STRENGTH = 10;
    private static final int MINIMUM_STRENGTH = 1;

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

    public static Warrior generateRandom() {
        Random random = new Random();
        var faker = new Faker();

        var randomName = faker.name().firstName();
        var randomId = Character.generateId();
        var randomIsAlive = random.nextBoolean();

        var randomHp = random.nextDouble(MINIMUM_HP, MAXIMUM_HP);
        var randomStamina = random.nextInt(MINIMUM_STAMINA, MAXIMUM_STAMINA);
        var randomStrength = random.nextInt(MINIMUM_STRENGTH, MINIMUM_STRENGTH);

        return new Warrior(randomName, randomId, randomHp, randomIsAlive, randomStamina, randomStrength);
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
