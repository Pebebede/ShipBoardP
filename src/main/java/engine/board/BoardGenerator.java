package engine.board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoardGenerator {
    int y = 11;
    int x = 11;
    private String[][] baseMap = new String[y][x];

    public String[][] loadMapfromCsv() {

        String path = "/home/pebe/IdeaProjects/ShipBoardP/src/main/resources/board.csv";
        BufferedReader scanIn;
        String next = "";
        int rowC = 0;

        {
            try {
                scanIn = new BufferedReader(new FileReader(path));

                while ((next = scanIn.readLine()) != null) {
                    String[] values = next.split(",");
                    for (int x = 0; x < values.length; x++) {
                        baseMap[rowC][x] = values[x];
                    }
                    rowC++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baseMap;
    }


}
