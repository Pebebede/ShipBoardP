package engine.shot.coordinates;

public class CoordinatesValidation {


    public Boolean doIt(String coordinates) {
        String UpperCaseCoordinate = coordinates.toUpperCase();
        return validation(UpperCaseCoordinate);
    }

    private Boolean validation(String coordinate) {
        int coordinateLength = coordinate.length();
        String firstChar = firstCharCreate(coordinateLength, coordinate);
        String secondChar = secondCharCreate(coordinateLength, coordinate);
        String thirdChar = thirdCharCreate(coordinateLength, coordinate);
        if (conditions(firstChar, secondChar, thirdChar, coordinateLength)) {

            return true;
        } else {
            System.out.println("Please, write correct attack coordinates");
            return false;
        }

    }

    private Boolean conditions(String firstChar, String secondChar, String thirdChar, int coordinateLength) {
        if (lengthRequirement(coordinateLength) &&
                firstCharRequirement(firstChar) &&
                secondCharRequirement(secondChar) &&
                thirdCharRequirement(secondChar, thirdChar)) {
            return true;
        } else return false;
    }

    private Boolean lengthRequirement(int coordinateLength) {
        if (coordinateLength == 2 || coordinateLength == 3) {
            return true;
        } else return false;
    }

    private Boolean firstCharRequirement(String firstChar) {
        if (firstChar.matches("[A-J]")) {
            return true;
        } else return false;
    }

    private Boolean secondCharRequirement(String secondChar) {
        if (secondChar.matches("[1-9]")) {
            return true;
        } else return false;
    }

    private Boolean thirdCharRequirement(String secondChar, String thirdChar) {
        if (secondChar.matches("1") && thirdChar.matches("0")) {
            return true;
        } else {
            if (thirdChar.equals("")) return true;
            else return false;
        }


    }

    private String firstCharCreate(int coordinateLength, String coordinate) {
        String firstChar;
        if (!(coordinateLength == 2 || coordinateLength == 3)) {
            firstChar = "";
        } else firstChar = coordinate.substring(0, 1);
        return firstChar;
    }

    private String secondCharCreate(int coordinateLength, String coordinate) {
        String secondChar;
        if (!(coordinateLength == 2 || coordinateLength == 3)) {
            secondChar = "";
        } else secondChar = coordinate.substring(1, 2);
        return secondChar;
    }

    private String thirdCharCreate(int coordinateLength, String coordinate) {
        String thirdChar;
        if (coordinateLength == 3) {
            thirdChar = coordinate.substring(2, 3);
        } else thirdChar = "";
        return thirdChar;
    }
}
