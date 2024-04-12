package Interfaces;

import Classes.Characters.Character;

public interface WeaponBehaviour {
    public void useWeaponToDealDamageTo(Character opponent);
    public String toString();
}
