package Classes.Characters;

import Classes.Enums.Spell;
import Interfaces.SpellBehaviour;
import Interfaces.WeaponBehaviour;

import static Classes.Arena.Arena.scanner;

public class Wizard extends Character{
    private int magicPower;
    private int mana;
    private SpellBehaviour currentSpell;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(getName()).append("\n");
        builder.append("Speed: ").append(getSpeed()).append("\n");
        builder.append("Health: ").append(getHealth()).append("\n");
        builder.append("Magic Power: ").append(getMagicPower()).append("\n");
        builder.append("Mana: ").append(getMana()).append("\n");
        builder.append("Weapon: ").append(getWeapon()).append("\n");
        if (currentSpell != null) {
            builder.append("Current Spell: ").append(currentSpell).append("\n");
        } else {
            builder.append("Current Spell: None\n");
        }
        builder.append("Class: Wizard \n");
        return builder.toString();
    }

    public Wizard(){
        super();
        this.magicPower = 5;
        this.mana = 100;
        this.currentSpell = null;
    }

    public Wizard(String name, int speed, int health, WeaponBehaviour weapon, int magicPower, int mana){
        super(name, speed, health, weapon);
        this.magicPower = magicPower;
        this.mana = mana;
        this.currentSpell = null;
    }

    public int getMana() {
        return mana;
    }

    public int getMagicPower(){
        return magicPower;
    }

    public SpellBehaviour getCurrentSpell() {
        return currentSpell;
    }

    public void setMana(int newMana) {
        this.mana = newMana;
    }

    public void setMagicPower(int newMagicPower){
        this.magicPower = newMagicPower;
    }

    public void setCurrentSpell(SpellBehaviour newSpell) {
        this.currentSpell = newSpell;
    }

    @Override
    public void fight(Character opponent) {
        if (wantToAttackWithSpell()) {
            selectSpell();
            currentSpell.useSpellToDealDamageTo(opponent, this);
            System.out.println(getName() + " changed his spell to " + currentSpell.toString());
            System.out.println(getName() + " casts a spell!");
        } else {
            this.getWeapon().useWeaponToDealDamageTo(opponent);
            System.out.println(getName() + " attacks with a weapon!");
        }
    }

    private boolean wantToAttackWithSpell() {
        System.out.println("Do you want to use a spell? You have " + this.mana + " mana and " + this.magicPower + " magic power. Type 'yes' to attack with a spell, otherwise you will use a weapon");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("yes");
    }

    private void selectSpell(){
        System.out.println("Select a new spell!");
        System.out.println("Type: 'Earth' (mana cost: 5), 'Wind' (mana cost: 15), 'Ice' (mana cost: 20) or 'Fire' (mana cost: 10)");
        System.out.println("If you don't have enough mana to use the spell you selected, you will use your weapon instead.");
        String chosenSpell;
        while(true){
            chosenSpell = scanner.next();
            try {
                Spell spell = Spell.valueOf(chosenSpell.toUpperCase());
                currentSpell = spell.getSpellBehaviour();
                if(hasEnoughMana()){
                    currentSpell.reduceManaOf(this);
                    break;
                }else{
                    System.out.println("You don't have enough mana to use this spell, you will use your weapon instead!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid spell name. Please choose a valid spell!");
            }
        }
    }

    private boolean hasEnoughMana(){
        return currentSpell.getManaValue() < mana;
    }
}
