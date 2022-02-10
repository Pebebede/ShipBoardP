import engine.GameLogic;
import engine.NewGameService;

public class Main {


    public static void main(String[] args) {
        NewGameService newGameService = new NewGameService();
        GameLogic newGame = newGameService.createNewGame();
        newGame.run();


    }

}
//        String[][] test = new BoardGenerator().loadMapfromCsv();
//        new BoardPrinter().render(test);
//       Player player1 = new PlayerCreator().get();
//       Player player2 = new PlayerCreator().get();
