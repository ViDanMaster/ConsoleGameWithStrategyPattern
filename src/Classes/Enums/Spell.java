package Classes.Enums;

import Classes.Spells.*;
import Interfaces.SpellBehaviour;

public enum Spell {
    EARTH(new EarthSpell()),
    FIRE(new FireSpell()),
    WIND(new WindSpell()),
    ICE(new IceSpell());

    private final SpellBehaviour spellBehaviour;

    Spell(SpellBehaviour spellBehaviour) {
        this.spellBehaviour = spellBehaviour;
    }

    public SpellBehaviour getSpellBehaviour() {
        return spellBehaviour;
    }
}
