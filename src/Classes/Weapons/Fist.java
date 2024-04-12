package Classes.Weapons;

import Interfaces.WeaponBehaviour;
import Classes.Characters.Character;

public class Fist implements WeaponBehaviour {
    private final int Damage = 2;
    @Override
    public void useWeaponToDealDamageTo(Character opponent) {
        opponent.setHealth(opponent.getHealth()-Damage);
    }

    @Override
    public String toString(){
        return "Fist";
    }
}
