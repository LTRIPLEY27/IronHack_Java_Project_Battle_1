public class Wizzard extends Character{

    private int mana;
    private int intelligence;

    public Wizzard(String name, int id, double hp, boolean isAlive, int mana, int intelligence) {
        super(name, id, hp, isAlive);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
