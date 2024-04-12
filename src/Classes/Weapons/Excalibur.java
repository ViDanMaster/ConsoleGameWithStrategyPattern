package Classes.Weapons;

import Classes.Characters.Character;
import Interfaces.WeaponBehaviour;

public class Excalibur implements WeaponBehaviour {
    private final int Damage = 10;
    @Override
    public void useWeaponToDealDamageTo(Character opponent) {
        opponent.setHealth(opponent.getHealth()-Damage);
    }

    @Override
    public String toString(){
        return "Excalibur";
    }
}
