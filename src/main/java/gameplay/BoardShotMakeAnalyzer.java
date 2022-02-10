package gameplay;

public class BoardShotMakeAnalyzer {

    public Boolean start(String[][] checkHitBoard, int x, int y) {
        String checkedField = checkHitBoard[x][y];

        if (!checkedField.equals(".")) {
            System.out.println("you already shot there, try again");
            return false;
        } else return true;
    }
}
