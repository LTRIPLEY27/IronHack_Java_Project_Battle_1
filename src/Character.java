import java.util.Random;

public abstract class Character {
    protected String name;
    protected int id;
    protected double hp;// VERIFICAR SI ES DOUBLE O INTEGER
    protected boolean isAlive;

    protected Random value = new Random();

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

    //RANDOM
    public void setAlive() {
        isAlive = alive;
    }
}
