public class Wizzard extends Character{


    private int mana;
    private int intelligence;

    public Wizzard(String name, int id, double hp, boolean isAlive, int mana, int intelligence) {
        super(name, id, hp, isAlive);
        setMana(mana);
        setIntelligence(intelligence);
    }

    //RAMDOM VALUES
    public Wizzard(String name, int id, double hp, boolean isAlive) {
        super(name, id, hp, isAlive);
        setMana();
        setIntelligence();
    }
    @Override// VERIFICAR EL RANDOM CHARACTER
    public void setHp(double hp) {
        this.hp = value.nextDouble(50, 100);
    }
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setMana() {
        this.mana = value.nextInt(10,50);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public void setIntelligence() {
        this.intelligence = value.nextInt(1,50);
    }
}
