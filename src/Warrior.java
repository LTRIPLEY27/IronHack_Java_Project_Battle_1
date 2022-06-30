public class Warrior extends Character{

    private int stamina;
    private int strength;

    public Warrior(String name, int id, double hp, boolean isAlive, int stamina, int strength) {
        super(name, id, hp, isAlive);
        setStamina(stamina);
        setStrength(strength);
    }

    public Warrior(String name, int id, double hp, boolean isAlive) {
        super(name, id, hp, isAlive);
        setStamina();
        setStrength();
    }
    @Override//VERIFICAR EL CHARACTER FATHER
    public void setHp(double hp) {
        this.hp = value.nextDouble(100, 200);
    }
    public int getStamina() {
        return stamina;
    }

    public void setStamina() {
        this.stamina = value.nextInt(10, 50);
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        this.strength = value.nextInt(1,10);
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
}
