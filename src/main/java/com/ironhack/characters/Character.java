package com.ironhack.characters;

import net.datafaker.Faker;

public abstract class Character {
    protected String name;
    protected String id;
    protected double hp;// VERIFICAR SI ES DOUBLE O INTEGER
    protected boolean isAlive;

    public Character() {
    }

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
    public abstract Character randomCharacter();


}
