package Classes.Characters;

import Classes.Weapons.Fist;
import Interfaces.WeaponBehaviour;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int speed;
    private int health;
    private WeaponBehaviour weapon;

    public Character(){
        this.name = "NewPlayer";
        this.speed = 100;
        this.health = 100;
        this.weapon = new Fist();
    }

    public Character(String name, int speed, int health, WeaponBehaviour weapon) {
        this.name = name;
        this.speed = speed;
        this.health = health;
        this.weapon = weapon;
    }


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }


    public int getHealth() {
        return health;
    }

    public WeaponBehaviour getWeapon() {
        return weapon;
    }


    public void setName(String newName) {
        this.name = newName;
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }


    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public void setWeapon(WeaponBehaviour newWeapon) {
        this.weapon = newWeapon;
    }

    public void fightWithWeapon(Character opponent){
        weapon.useWeaponToDealDamageTo(opponent);
    }

    public abstract String toString();

    public abstract void fight(Character opponent);

}
