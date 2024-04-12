package Classes.Spells;

import Classes.Characters.Character;
import Classes.Characters.Wizard;
import Interfaces.SpellBehaviour;

public class FireSpell implements SpellBehaviour {
    private final int baseDamage = 2;
    private final int manaUse = 10;
    @Override
    public void useSpellToDealDamageTo(Character opponent, Wizard caster) {
        opponent.setHealth(opponent.getHealth() - (baseDamage + caster.getMagicPower()));
    }
    @Override
    public void reduceManaOf(Wizard wizard){
        wizard.setMana(wizard.getMana()-manaUse);
    }

    @Override
    public int getManaValue() {
        return manaUse;
    }

    @Override
    public String toString(){
        return "Fire Spell";
    }
}
