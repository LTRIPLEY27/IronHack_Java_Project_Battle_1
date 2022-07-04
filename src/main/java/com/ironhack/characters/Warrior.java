package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;

public class Warrior extends Character {

    public static final int STAMINA_ATTACK_THRESHOLD = 5;
    public static final int HEAVY_ATTACK_STAMINA_USAGE = -5;
    public static final int WEAK_ATTACK_STAMINA_USAGE = 1;
    public static final double WEAK_ATTACK_MULTIPLIER = 0.5;

    private int stamina;
    private int strength;

    private final int MINIMUM_STAMINA = 10;
    private final int MAXIMUM_STAMINA = 50;
    private final int MINIMUN_HP = 100;
    private final int MAXIMUN_HP = 200;
    private final int MAXIMUM_STRENGTH = 10;
    private final int MINIMUM_STRENGTH = 1;

    public Warrior(){

    }


    public Warrior(String name, int id, double hp, boolean isAlive, int stamina, int strength) {
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
    public double attack() {
        if (getStamina() >= STAMINA_ATTACK_THRESHOLD) {
            // -5 stamina
            setStamina(getStamina() + HEAVY_ATTACK_STAMINA_USAGE);
            // Heavy attack -> return DMG == Strength
            return getStrength();
        } else {
            // +1 stamina
            setStamina(getStamina() + WEAK_ATTACK_STAMINA_USAGE);
            // Weak attack -> return DMG == 0.5 * Strength
            return  WEAK_ATTACK_MULTIPLIER * getStrength();
        }
    }
}
