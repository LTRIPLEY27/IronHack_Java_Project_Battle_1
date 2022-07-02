import java.util.Random;

public abstract class Character {
    private String name;
    private int id;
    private double hp;
    private boolean isAlive;

    public static final String SUFFIX_NAME = " Jr";
    public Character(String name, int id, double hp, boolean isAlive) {
        setId(id);
        setName(name);
        setHp(hp);
        setAlive(isAlive);
    }

    //RANDOM
    public Character() {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.isAlive = isAlive;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // crear el array de nombres e iterar random para crear personaje random
    public void setName() {
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
