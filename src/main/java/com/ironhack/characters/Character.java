package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;
import java.util.UUID;

public abstract class Character {
    protected String name;
    protected String id;
    protected double hp;
    protected boolean isAlive;

    public static final String SUFFIX_NAME = " Jr";
    
    public Character(String name, String id, double hp, boolean isAlive) {
        setId(id);
        setName(name);
        setHp(hp);
        setAlive(isAlive);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract double attack();
    
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

}
