import characters.Wizard;
import characters.Warrior;

import java.sql.SQLOutput;
import java.util.ArrayList;


/**
 * This is a class to create a Graveyard. The place where all
 * dead characters go.
 */
public class Graveyard {
    ArrayList<Wizard> deadWizards;
    ArrayList<Warrior> deadWarriors;

    //Graveyard constructor
    public Graveyard() {
        this.deadWizards = new ArrayList<Wizard>();
        this.deadWarriors = new ArrayList<Warrior>();
        System.out.println("The Graveyard has been created... 🪦");
        System.out.println("no bodies have been buried yet...  ");

    }

    /**
     * This method is just for testing the functionality of the Graveyard
     */
    public static void test(){
        Graveyard graveyard = new Graveyard();

        var Merlin = new Wizard("Merlin", 3, 200, true, 500, 100);
        var VatoLoco = new Warrior("Vato Loco", 3, 200, true, 500, 100);

        graveyard.addDeadCharacter(Merlin);
        graveyard.addDeadCharacter(VatoLoco);

        graveyard.showGraveyard();
    }


    /**
     * showGraveyard() shows the current state of the Graveyard
     * revealing if there are any dead wizards or warriors
     * burried in it.
     */
    public void showGraveyard(){

        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");
        System.out.println("DEADWIZARDS: ");

        if (deadWizards.isEmpty()){
            System.out.println("none");
        }else{
            for (Wizard wizard : deadWizards) {
                System.out.println("🪦 " + wizard.getName());
            }
        }

        System.out.println("DEADWARRIORS: ");

        if (deadWarriors.isEmpty()){
            System.out.println("none");
        }else {
            for (Warrior warrior: deadWarriors){
                System.out.println("🪦 "+warrior.getName());
            }
        }

        System.out.println("✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝✝");


    }


    /**
     * When a warrior dies use this method to add the warrior to
     * the graveyard.
     */
    public void addDeadCharacter(Warrior deadWarrior) {
        deadWarriors.add(deadWarrior);
        System.out.println(deadWarrior.getName() + " is dead. A legendary fighter has past away 🪦");

    }


    /**
     * When a wizard dies use this method to add the wizard to
     * the graveyard.
     */
    public void addDeadCharacter(Wizard deadWizard) {
        deadWizards.add(deadWizard);
        System.out.println(deadWizard.getName() + " magic is over. A magical soul is now moving to the other world 🪦");
    }
}
