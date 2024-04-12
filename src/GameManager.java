import Classes.Arena.Arena;
import Classes.Characters.Barbarian;
import Classes.Characters.Wizard;
import Classes.Weapons.Excalibur;

public class GameManager {
    public static void main(String[] args) {
        Wizard c = new Wizard("Attila", 100, 100, new Excalibur(), 5, 100);
        Barbarian c2 = new Barbarian("Peti", 100, 100, new Excalibur());

        Arena a = new Arena(c, c2);
        a.startFight();
    }
}