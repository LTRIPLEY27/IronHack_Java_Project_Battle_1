package com.ironhack.characters;

public abstract class Character {
    protected String name;
    protected int id;
    protected double hp;// VERIFICAR SI ES DOUBLE O INTEGER
    protected boolean isAlive;

    public static final String SUFFIX_NAME = " Jr";
    public Character(String name, int id, double hp, boolean isAlive) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //RANDOM
    public void setId() {
        this.id = id;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    //RANDOM
    public void setHp() {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract double attack();
}
