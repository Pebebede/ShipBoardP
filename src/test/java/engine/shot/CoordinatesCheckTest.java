package engine.shot;

import engine.board.BoardGenerator;
import engine.shot.coordinates.CoordinatesCheck;
import org.junit.jupiter.api.Test;
import player.Player;
import player.PlayerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesCheckTest {
    //give CC+gracz z planszą
    //when
    //then t/f
    CoordinatesCheck coordinatesCheck = new CoordinatesCheck();

    @Test
    Player createTestPlayer() {
        //wypełnienie playerBoard kilkoma wcześniej oddamy strzałami
        String[][] testedShotMakeBoard = new BoardGenerator().loadMapfromCsv();
        testedShotMakeBoard[1][2] = "x";
        testedShotMakeBoard[5][5] = "x";
        testedShotMakeBoard[8][1] = "h";
        testedShotMakeBoard[9][1] = "h";
        testedShotMakeBoard[10][1] = "h";
        testedShotMakeBoard[7][10] = "h";
        testedShotMakeBoard[10][10] = "h";
        String[][] testedPlayerBoard = new BoardGenerator().loadMapfromCsv();
        List<String> emptyShips = new ArrayList<>();
        return new PlayerFactory().create("Tester", testedPlayerBoard, testedShotMakeBoard, emptyShips);
    }

    @Test
    void emptyFieldShot() {
        Player tester = createTestPlayer();
        String testCoordinate = "B2";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(true, check);
    }

    @Test
    void emptyFieldShot2() {
        Player tester = createTestPlayer();
        String testCoordinate = "F7";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(true, check);
    }

    @Test
    void emptyFieldShot3() {
        Player tester = createTestPlayer();
        String testCoordinate = "C10";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(true, check);
    }

    @Test
    void shotInSamePlace1() {
        Player tester = createTestPlayer();
        String testCoordinate = "A2";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(false, check);
    }

    @Test
    void shotInSamePlace2() {
        Player tester = createTestPlayer();
        String testCoordinate = "E5";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(false, check);
    }

    @Test
    void shotInSamePlace3() {
        Player tester = createTestPlayer();
        String testCoordinate = "I1";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(false, check);
    }

    @Test
    void shotInSamePlace4() {
        Player tester = createTestPlayer();
        String testCoordinate = "G10";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(false, check);
    }

    @Test
    void shotInSamePlace5() {
        Player tester = createTestPlayer();
        String testCoordinate = "J10";
        Boolean check = coordinatesCheck.start(testCoordinate, tester);
        assertEquals(false, check);
    }


}