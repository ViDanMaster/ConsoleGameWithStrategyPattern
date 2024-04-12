package Classes.Arena;

import Classes.Characters.Character;

import java.util.Scanner;

public class Arena {

    private Character player1;
    private Character player2;
    public static Scanner scanner = new Scanner(System.in);

    public Arena(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startFight() {
        Character attacker = determineAttacker();
        Character defender = attacker == player1 ? player2 : player1;
        System.out.println("Player1 is: \n" + player1.toString());
        System.out.println("Player2 is: \n" + player2.toString());

        while (bothPlayersAlive()) {
            System.out.println("Now attacking: " + attacker.getName() + "\n");
            attacker.fight(defender);
            printHealthStatus();
            Character temp = attacker;
            attacker = defender;
            defender = temp;
        }

        announceWinner();
    }

    private Character determineAttacker() {
        if (player1.getSpeed() >= player2.getSpeed()) {
            return player1;
        } else {
            return player2;
        }
    }

    private boolean bothPlayersAlive() {
        return player1.getHealth() > 0 && player2.getHealth() > 0;
    }

    private void printHealthStatus() {
        System.out.println(player1.getName() + " health: " + player1.getHealth());
        System.out.println(player2.getName() + " health: " + player2.getHealth());
        System.out.println();
    }

    private void announceWinner() {
        if (player1.getHealth() > 0) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
    }
}
