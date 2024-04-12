package Classes.Weapons;

import Classes.Characters.Character;
import Interfaces.WeaponBehaviour;

public class Knife implements WeaponBehaviour {
    private final int Damage = 5;
    @Override
    public void useWeaponToDealDamageTo(Character opponent) {
        opponent.setHealth(opponent.getHealth()-Damage);
    }

    @Override
    public String toString(){
        return "Knife";
    }
}
