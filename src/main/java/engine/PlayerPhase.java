package engine;

import engine.board.BoardPrinter;
import engine.shot.ActionPrepare;
import player.Player;

public class PlayerPhase {
    //wczytaniue plansz DANEGO GRACZA ok
    //Podanie cc ruchu ok
    //Zapisanie wpisanych cc do mapy DANEGO GRACZA
    //Sprawdzenie trafienia
    //Ponowny ruch/zakonczenie tury
    public void start(Player player, String[][] hitCheck) {
        printBoards(player.getBaseBoard(), player.getShotsMakeBoard());
        actionExecution(player, hitCheck);

    }


    private void printBoards(String[][] base, String[][] opponent) {
        BoardPrinter.render(base, opponent);
    }

    private void actionExecution(Player player, String[][] hitCheck) {
        new ActionPrepare().doIt(player, hitCheck);
    }
}
