package engine.board;

public class BoardPrinter {
    //Do zmiany na drukowanie dwóch plansz na raz
    public static void render(String[][] base, String[][] opponent) {
        printBoards(base, opponent);
        //printRightSide(opponent);
    }

    private static void printBoards(String[][] base, String[][] opponent) {
        for (int i = 0; i < base.length; i++) {

            for (int j = 0; j < base[i].length; j++) {
                System.out.print(base[i][j] + " ");
            }
            System.out.print("    ");
            justification(i);
            for (int k = 0; k < opponent.length; k++) {
                System.out.print(opponent[i][k] + " ");
            }
            System.out.println("");
        }
    }

    private static void justification(int i) {
        if (i != 0) {
            System.out.print(" ");
        }
    }
}
