package Classes.Characters;

import Classes.Enums.Weapon;
import Interfaces.WeaponBehaviour;

import static Classes.Arena.Arena.scanner;

public class Barbarian extends Character{
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(getName()).append("\n");
        builder.append("Speed: ").append(getSpeed()).append("\n");
        builder.append("Health: ").append(getHealth()).append("\n");
        builder.append("Weapon: ").append(getWeapon()).append("\n");
        builder.append("Class: Barbarian \n");
        return builder.toString();
    }

    @Override
    public void fight(Character opponent) {
        if (wantToChangeWeapon()) {
            selectWeapon();
            System.out.println(getName() + " changed his weapon to " + this.getWeapon().toString());
        } else {
            this.getWeapon().useWeaponToDealDamageTo(opponent);
            System.out.println(getName() + " attacks with a weapon!");
        }
    }

    public Barbarian(){
        super();
    }

    public Barbarian(String name, int speed, int health, WeaponBehaviour weapon){
        super(name, speed, health, weapon);
    }


    private boolean wantToChangeWeapon(){
        System.out.println("Do you want to change your weapon? Type 'yes' to change it, otherwise you will use a weapon");
        System.out.println("If you change your weapon, you won't attack in this round");
        String choice = scanner.next();
        return choice.equalsIgnoreCase("yes");
    }

    private void selectWeapon(){
        System.out.println("Select a new weapon!");
        System.out.println("Type: 'Fist', 'Knife', 'Excalibur', 'Axe'");
        String chosenWeapon;
        while(true){
            chosenWeapon = scanner.next();
            try {
                Weapon weapon = Weapon.valueOf(chosenWeapon.toUpperCase());
                setWeapon(weapon.getWeaponBehaviour());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid spell name. Please choose a valid spell!");
            }
        }
    }

}
