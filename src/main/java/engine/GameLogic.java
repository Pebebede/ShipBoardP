package engine;

import player.Player;

public class GameLogic {
    private final Player player1;
    private final Player player2;
//Zastanowić się nad nazwą klasy, aby oddawała intencję zarządzania rozpoczętą rozgrywką

    public GameLogic(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        new GameplaySupport().turnCycle(player1, player2);


    }


}
