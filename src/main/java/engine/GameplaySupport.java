package engine;

import player.Player;

public class GameplaySupport {
    PlayerPhase playerPhase = new PlayerPhase();

    public void turnCycle(Player player1, Player player2) {
        boolean phaseP1 = false;
        boolean phaseP2 = false;
        while (!phaseP1) {
            String[][] player2HitCheck = player2.getBaseBoard();
            playerPhase.start(player1, player2HitCheck);
            phaseP1 = true;
        }

        while (!phaseP2) {
            String[][] player1HitCheck = player1.getBaseBoard();
            playerPhase.start(player2, player1HitCheck);
            phaseP2 = true;
        }
    }

}
