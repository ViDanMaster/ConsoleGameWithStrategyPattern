package Interfaces;

import Classes.Characters.Character;
import Classes.Characters.Wizard;

public interface SpellBehaviour {
    public void useSpellToDealDamageTo(Character opponent, Wizard caster);
    public void reduceManaOf(Wizard wizard);
    public int getManaValue();
    public String toString();
}
