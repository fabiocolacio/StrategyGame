import java.util.Random;
import java.lang.Math;

public class GameUnit {
    Random rand = new Random();
    private String name;
    private String flavor;
    private String description;
    private int movePoints;
    private int dodgeChance;
    private int defense;
    private int health;
    private int armorPhysical;
    private int armorMagical;
    
    private String attackName;
    private String attackDescription;
    private int attackType;
    private int attackRange;
    private int attackDamage;

    GameUnit (String name, String flavor, String description, int movePoints, 
            int dodgeChance, int defense, int health, int armorPhysical, int armorMagical,
            String attackName, String attackDescription, int attackType, int attackRange, int attackDamage) {

        this.name = name;
        this.flavor = flavor;
        this.description = description;
        this.movePoints = movePoints;
        this.dodgeChance = dodgeChance;
        this.defense = defense;
        this.health = health;
        this.armorPhysical = armorPhysical;
        this.armorMagical = armorMagical;
        this.attackName = attackName;
        this.attackDescription = attackDescription;
        this.attackType = attackType;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
    }

    public boolean checkDodge() {
        int rng = rand.nextInt(100);
        if (rng <= (this.dodgeChance)) {
            return true;
        } else {
            return false;
        }
    }

    public void addHealth(int ammount) {
        this.health += ammount;
    }

    public void removeRawHealth(int ammount) {
        this.health -= ammount;
    }

    public void removeHealth(boolean damageType, int ammount) {
        if (damageType) {
            this.health -= this.armorMagical - ammount;
        } else {
            this.health -= this.armorPhysical - ammount;
        }
    }

    public String toString () {
        return  "Name: \t" + this.name + "\n" +
                "Flavor: \t" + this.flavor + "\n" +
                "Description: \t" + this.description + "\n" +
                "Move Points: \t" +  this.movePoints + "\n" +
                "Dodge Chance: \t" + this.dodgeChance + "\n" +
                "Defense: \t" + this.defense + "\n" +
                "Armor Physical: \t" + this.armorPhysical + "\n" +
                "Armor Magical: \t" + this.armorMagical + "\n" +
                "Attack - Name: \t" + this.attackName + "\n" +
                "Attack - Description: \t" + this.attackDescription + "\n" +
                "Attack - Type: \t" + this.attackType + "\n" +
                "Attack - Range: \t" + this.attackRange + "\n" +
                "Attack - Damage: \t" + this.attackDamage;

    }

}