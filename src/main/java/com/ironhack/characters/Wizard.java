package com.ironhack.characters;

public class Wizard extends Character{

    public static final int MANA_ATTACK_THRESHOLD = 5;
    public static final int FIREBALL_MANA_USAGE = -5;
    public static final int STAFF_HIT_MANA_USAGE = 1;
    public static final double STAFF_HIT_DAMAGE = 2;

    private int mana;
    private int intelligence;

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

    @Override
    public double attack() {
        if (getMana() >= MANA_ATTACK_THRESHOLD) {
            // -5 mana
            setMana(getMana() + FIREBALL_MANA_USAGE);
            // FIREBALL -> return DMG == Intelligence
            return getIntelligence();
        } else {
            // +1 mana
            setMana(getMana() + STAFF_HIT_MANA_USAGE);
            // STAFF HIT -> return DMG == 2
            return  STAFF_HIT_DAMAGE;
        }
    }
}
