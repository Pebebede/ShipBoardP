package engine.shot.coordinates;

import gameplay.BoardShotMakeAnalyzer;
import player.Player;

public class CoordinatesCheck {
    CoordinatesSplit split = new CoordinatesSplit();


    public Boolean start(String coordinates, Player player) {
        Pair separated = split.doIt(coordinates);
        int x = separated.getX();
        int y = separated.getY();
        return checkTheShotMade(x, y, player);
    }


    private Boolean checkTheShotMade(int x, int y, Player player) {
        return new BoardShotMakeAnalyzer().start(player.getShotsMakeBoard(), x, y);

    }
}
