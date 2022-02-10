package engine;

import player.Player;
import player.PlayerCreator;

public class NewGameService {

    public GameLogic createNewGame() {
        PlayerCreator playerCreator = new PlayerCreator();
        Player player1 = playerCreator.get();
        Player player2 = playerCreator.get();
        GameLogic gameLogic = new GameLogic(player1, player2);
        return gameLogic;
    }


}
