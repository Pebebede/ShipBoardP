package engine.shot;

import engine.shot.coordinates.CoordinatesCheck;
import engine.shot.coordinates.CoordinatesSplit;
import engine.shot.coordinates.CoordinatesValidation;
import engine.shot.coordinates.Pair;
import player.Player;

import java.util.Scanner;

public class ActionPrepare {
    Scanner in = new Scanner(System.in);

    public void doIt(Player player, String[][] hitCheck) {
        boolean untilMissHit;
        do {
            String attackCoordinates = getCorrect(player);
            Missile missile = arm(attackCoordinates);
            untilMissHit = fire(missile, hitCheck, player);
        } while (!untilMissHit);
    }

    private Missile arm(String coordinates) {
        Pair separated = new CoordinatesSplit().doIt(coordinates);
        int x = separated.getX();
        int y = separated.getY();
        return new Missile(x, y);
    }

    private String getCorrect(Player player) {
        String coordinates;
        boolean correctnessOfCoordinates;
        do {
            coordinates = readCoordinates();
            correctnessOfCoordinates = new CoordinatesCheck().start(coordinates, player);
        } while (!correctnessOfCoordinates);
        return coordinates;
    }

    private String readCoordinates() {
        boolean correct = false;
        String upperCaseCoordinate = "";
        while (!correct) {
            System.out.println("Please give the coordinates of the shot (example: B2)");
            String coordinate = in.nextLine();
            upperCaseCoordinate = coordinate.toUpperCase();
            correct = new CoordinatesValidation().doIt(upperCaseCoordinate);
        }
        return upperCaseCoordinate;
    }


    private Boolean fire(Missile missile, String[][] hitCheck, Player player) {
        return new ShotAnalyzer().check(missile, hitCheck);
    }

}
