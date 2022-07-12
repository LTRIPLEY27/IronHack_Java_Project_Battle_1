package com.ironhack.characters;

import java.util.UUID;

public abstract class Character {

    public static int HEALTH_DEATH_THRESHOLD = 0;

    protected String name;
    protected String id;
    protected double hp;
    protected boolean alive;

    public static final String SUFFIX_NAME = " Jr";
    
    public Character(String name, String id, double hp) {
        setId(id);
        setName(name);
        setHp(hp);
        setAlive(hp > HEALTH_DEATH_THRESHOLD);
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
        this.hp = hp > HEALTH_DEATH_THRESHOLD ? hp : HEALTH_DEATH_THRESHOLD;
        if(this.hp <= HEALTH_DEATH_THRESHOLD) setAlive(false);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public abstract double attack();

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", hp=" + hp +
                ", isAlive=" + alive +
                '}';
    }
}
