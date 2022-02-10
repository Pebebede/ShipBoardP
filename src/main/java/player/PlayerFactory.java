package player;

import java.util.List;

public class PlayerFactory {

    public Player create(String nickname, String[][] baseBoard, String[][] shotsMakeBoard, List<String> shipList) {
        return new Player(nickname, baseBoard, shotsMakeBoard, shipList);
    }

}
