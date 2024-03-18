package Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStringFormatTest {

    @Test
    void upperStringTest(){
        String beforeFormat = "Game over!";

        String upperCaseString = CustomStringFormat.getUpperCaseString(beforeFormat);
        assertEquals("GAME OVER!", upperCaseString); // Passed test
        assertNotEquals("Game over!", upperCaseString); // Failed test
    }
}