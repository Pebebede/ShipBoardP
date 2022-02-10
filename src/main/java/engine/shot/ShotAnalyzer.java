package engine.shot;

public class ShotAnalyzer {


    public Boolean check(Missile missile, String[][] opponentBoardHitCheck) {

        int column = missile.getX();
        int row = missile.getY();

        if (hitCheck(column, row, opponentBoardHitCheck)) {
            System.out.println("wsio");
            // rozpoczęcie instrukcji sprawdzenia zatopienia statku pod trafionymi koordynatami
            return true;
        } else return false;
    }

    // tutaj wiem że: x i row nie było użyte!
    // albo trafia albo pudło!
    private Boolean hitCheck(int column, int row, String[][] opponentBoard) {
        if (!opponentBoard[column][row].equals(".")) {
            System.out.println("your missile just hit opponent ship!");
            return true;
        } else {
            System.out.println("your missile drop in to the ocean, try again");
            return false;
        }
    }


}
