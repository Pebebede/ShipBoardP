package gameplay;

import engine.board.BoardGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardAnalyzerTest {

    //given :[x] i [y] trafienia
    //given plansza z trafieniami
    //when :na planszy są różne statki i trafienia
    //then :informuje czy statek został zatopiony/jaki

    String[][] fillBoardWithShips() {
        String[][] boardToAnalyzeShipHits = new BoardGenerator().loadMapfromCsv();
        boardToAnalyzeShipHits[2][1] = "S"; //b1
        boardToAnalyzeShipHits[2][2] = "S"; //B2
        boardToAnalyzeShipHits[2][3] = "S"; //B3
        return boardToAnalyzeShipHits;
    }


    int[] checkingPossibilityOfFlooding(int columnHitPosition, int rowHitPosition, int[] helpBoard, String[][] testedBoard) {
        columnPlus(columnHitPosition, rowHitPosition, helpBoard, testedBoard);
        columnMinus(columnHitPosition, rowHitPosition, helpBoard, testedBoard);
        rowPlus(columnHitPosition, rowHitPosition, helpBoard, testedBoard);
        rowMinus(columnHitPosition, rowHitPosition, helpBoard, testedBoard);
        return helpBoard;
    }


    Boolean didShipSink(int[] shipCheck) {
        boolean sink = true;
        for (Integer check : shipCheck) {
            if (check == 1) {
                sink = false;
                break;
            }
        }
        return sink;
    }

    @Test
    void firstHit3PartShip() {
        //zwraca trafienie i nie zwraca info że statek ubity!
        //hit B3
        int columnHitPosition = 2;
        int rowHitPosition = 3;
        String[][] testedBoard = fillBoardWithShips();
        int[] shipCheck = new int[4];
        shipCheck[0] = 2;
        shipCheck = checkingPossibilityOfFlooding(columnHitPosition, rowHitPosition, shipCheck, testedBoard);

        System.out.println(Arrays.toString(shipCheck));
        assertFalse(didShipSink(shipCheck));
    }


    @Test
    int[] columnPlus(int columnHitPosition, int rowHitPosition, int[] helpBoard, String[][] testedBoard) {
        boolean loopCheck = true;
        for (int i = 1; loopCheck; i++) {
            if (testedBoard[columnHitPosition + i][rowHitPosition].equals("S")) {
                helpBoard[i] = 1;
            } else if (testedBoard[columnHitPosition + i][rowHitPosition].equals("H")) {
                helpBoard[i] = 2;
            } else loopCheck = false;
        }
        return helpBoard;
    }

    @Test
    int[] columnMinus(int columnHitPosition, int rowHitPosition, int[] helpBoard, String[][] testedBoard) {
        boolean loopCheck = true;
        for (int i = 1; loopCheck; i++) {
            if (testedBoard[columnHitPosition - i][rowHitPosition].equals("S")) {
                helpBoard[i] = 1;
            } else if (testedBoard[columnHitPosition - i][rowHitPosition].equals("H")) {
                helpBoard[i] = 2;
            } else loopCheck = false;
        }
        return helpBoard;
    }

    @Test
    int[] rowPlus(int columnHitPosition, int rowHitPosition, int[] helpBoard, String[][] testedBoard) {
        boolean loopCheck = true;
        for (int i = 1; loopCheck; i++) {
            if (testedBoard[columnHitPosition][rowHitPosition + i].equals("S")) {
                helpBoard[i] = 1;
            } else if (testedBoard[columnHitPosition][rowHitPosition + i].equals("H")) {
                helpBoard[i] = 2;
            } else loopCheck = false;
        }
        return helpBoard;
    }

    @Test
    int[] rowMinus(int columnHitPosition, int rowHitPosition, int[] helpBoard, String[][] testedBoard) {
        boolean loopCheck = true;
        for (int i = 1; loopCheck; i++) {
            if (testedBoard[columnHitPosition][rowHitPosition - i].equals("S")) {
                helpBoard[i] = 1;
            } else if (testedBoard[columnHitPosition][rowHitPosition - i].equals("H")) {
                helpBoard[i] = 2;
            } else loopCheck = false;
        }
        return helpBoard;
    }


}
//  for (int i = column; i <= 10; i++) {
//          System.out.println(testedBoard[i][row]);//1. 2|3(h) 2. 3|3(m) 3. 4|3(m) 4. 5|3(m)
//          for (int j = column; j >= 1; j--) {
//          System.out.println(testedBoard[j][row]);// 1. 2|3(h) 2. 1|3(m) 3. brak...
//          }
//          }