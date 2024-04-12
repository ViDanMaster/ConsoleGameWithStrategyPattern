package Classes.Enums;

import Classes.Weapons.*;
import Interfaces.WeaponBehaviour;

public enum Weapon {
    FIST(new Fist()),
    AXE(new Axe()),
    EXCALIBUR(new Excalibur()),
    KNIFE(new Knife());

    private final WeaponBehaviour weaponBehaviour;

    Weapon(WeaponBehaviour spellBehaviour) {
        this.weaponBehaviour = spellBehaviour;
    }

    public WeaponBehaviour getWeaponBehaviour() {
        return weaponBehaviour;
    }
}
