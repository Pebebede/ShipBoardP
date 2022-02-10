package engine.shot.coordinates;

public class CoordinatesSplit {


    public Pair doIt(String coordinates) {
        int firstChar = firstCharCreate(coordinates);
        int secondChar = secondCharCreate(coordinates);
        return getCoordinates(firstChar, secondChar);

    }


    private Integer firstCharCreate(String coordinate) {
        char firstChar = coordinate.charAt(0);
        return firstChar - 64;
    }

    private Integer secondCharCreate(String coordinates) {
        if (coordinates.length() == 2) {
            char secondChar = coordinates.charAt(1);
            return secondChar - 48;
        } else {
            return 10;

        }

    }

    private Pair getCoordinates(int x, int y) {
        return new Pair(x, y);
    }
}
