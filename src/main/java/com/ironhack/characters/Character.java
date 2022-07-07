package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;

public abstract class Character {
    protected String name;
    protected static  String randomName;
    protected String id;
    protected static String randomId;
    protected double hp;
    protected static double randomHp;
    protected boolean isAlive;
    protected static boolean randomIsAlive;

    //public Character() {}

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

    public static void randomCharacter() {
        Random num = new Random();
        var faker = new Faker();

        randomName = faker.name().firstName();
        randomId = faker.idNumber().valid();
        randomHp = 0;
        randomIsAlive = true;

        System.out.println(randomName);
        System.out.println(randomId);
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }
}
