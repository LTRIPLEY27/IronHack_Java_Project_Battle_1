package com.ironhack.characters;

import net.datafaker.Faker;

import java.util.Random;

public abstract class Character {
    protected String name;
    protected String id;
    protected double hp;
    protected boolean isAlive;

    public Character() {}

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

    public void randomCharacter() {
    }

    public static Character generatedCharacter() {
        Character character = new Character() {
            public void randomCharacter() {
                /*var faker = new Faker();
                Random num = new Random();

                setName(faker.name().firstName());
                setId(faker.idNumber().valid());
                setHp(0);
                setAlive(true);*/

            }

        };

        var faker = new Faker();
        Random num = new Random();

        character.setName(faker.name().firstName());
        character.setId(faker.idNumber().valid());
        character.setHp(0);
        character.setAlive(true);

        return character;

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
