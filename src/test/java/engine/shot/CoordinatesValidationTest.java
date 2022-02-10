package engine.shot;

import engine.shot.coordinates.CoordinatesValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinatesValidationTest {
    //give
    //when
    //then
    CoordinatesValidation testValidation = new CoordinatesValidation();

    //false
    @Test
    void tooLowNumber() {
        String givenValue = "A0";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void tooBigNumber() {
        String givenValue = "A11";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void shorterValueOnlyLetter() {
        String givenValue = "A";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void shorterValueOnlyNumber() {
        String givenValue = "9";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void emptyString() {
        String givenValue = "";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void tooLongString() {
        String givenValue = "abecadlo";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void tooLongMixString() {
        String givenValue = "12ale2121";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void onlyNumbersGoodLength() {
        String givenValue = "215";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void onlyNumberGoodLength2() {
        String givenValue = "100";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }

    @Test
    void veryLongStringWithCorrectBegin() {
        String givenValue = "c10A11sdsa23frdfdfgwer21sssd";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(false, test);
    }


    //true
    @Test
    void correctString1LowCase() {
        String givenValue = "c5";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(true, test);
    }

    @Test
    void correctString2LowCase() {
        String givenValue = "c10";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(true, test);
    }

    @Test
    void correctString3() {
        String givenValue = "J10";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(true, test);
    }

    @Test
    void correctString4() {
        String givenValue = "F1";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(true, test);
    }

    @Test
    void correctString5() {
        String givenValue = "A10";
        Boolean test = testValidation.doIt(givenValue);
        assertEquals(true, test);
    }


}