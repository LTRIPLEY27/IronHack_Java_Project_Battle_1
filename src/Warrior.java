public class Warrior extends Character{

    private int stamina;
    private int strength;

    private final int MINIMUM_STAMINA = 10;

    private final int MAXIMUM_STAMINA = 50;
    private final int MINIMUN_HP = 100;
    private final int MAXIMUN_HP = 200;
    private final int MAXIMUM_STRENGTH = 10;
    private final int MINIMUM_STRENGTH = 1;




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


}
