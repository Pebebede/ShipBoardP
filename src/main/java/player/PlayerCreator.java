package player;

import engine.board.BoardGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerCreator {
    BoardGenerator generateBoard = new BoardGenerator();
    PlayerFactory player = new PlayerFactory();
    Scanner in = new Scanner(System.in);

    public Player get() {

        return player.create(nameChoice(), baseBoard(), baseBoard(), shipList());
    }


    private String nameChoice() {
        System.out.println("Please, write you name");
        String choiceName = in.nextLine();
        return choiceName;
    }

    private String[][] baseBoard() {
        String[][] blankBoard = generateBoard.loadMapfromCsv();
        return blankBoard;
    }

    //Statki zmienić na oddzielną klasę ze stakami, zamist string
    private List<String> shipList() {
        List<String> ships = new ArrayList<>();
        ships.add("statekMaly1");
        ships.add("statekMaly2");
        ships.add("statekSredni1");
        ships.add("statekSredni2");
        ships.add("statekDuzy");
        return ships;
    }

}
