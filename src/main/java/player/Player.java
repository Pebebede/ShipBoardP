package player;

import java.util.List;

public class Player {

    //zawartość gracza:
    //Nick
    //swoja tablica + tablica z statkami przeciwnika
    //swoje statki
    //
    private final String nickname;
    private final String[][] baseBoard;
    private final String[][] shotsMakeBoard;
    private final List<String> shipList;

    protected Player(String nickname, String[][] baseBoard, String[][] shotsMakeBoard, List<String> shipList) {
        this.nickname = nickname;
        this.baseBoard = baseBoard;
        this.shotsMakeBoard = shotsMakeBoard;
        this.shipList = shipList;
    }

    public String getNickname() {
        return nickname;
    }

    public String[][] getBaseBoard() {
        return baseBoard;
    }

    public String[][] getShotsMakeBoard() {
        return shotsMakeBoard;
    }

    public List<String> getShipList() {
        return shipList;
    }
}
