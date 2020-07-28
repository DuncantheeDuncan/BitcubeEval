package assessmentproject.section1.regpage;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


import static org.junit.Assert.*;

public class PasswordTests {
    String Expected;
    String Actual;
    String password;


    @DisplayName("should check if all password minimum requirements are met")
    @Test
    public void verifyingPassMinimum() {

        // TODO  ~ TRUE MEANS THERE IS AN ERROR
        //       ~ FALSE MEANS THERE ARE NO ERRORS


        // should return false as there are errors

        password = "JacksonMabso%45";
        Expected = String.valueOf(false);
        Actual = String.valueOf(Password.checkMinimumReq(password));

        assertEquals(Expected, Actual);
        assertFalse(Boolean.parseBoolean(Actual));


        //should return error as no uppercase

        password = "acksonzabso%45";
        Expected = String.valueOf(true);
        Actual = String.valueOf(Password.checkMinimumReq(password));

        assertEquals(Expected, Actual);
        assertTrue(Boolean.parseBoolean(Actual));


        // error, there is not special character

        password = "JacksonMabso45";
        Expected = String.valueOf(true);
        Actual = String.valueOf(Password.checkMinimumReq(password));

        assertEquals(Expected, Actual);
        assertTrue(Boolean.parseBoolean(Actual));


        // error 'coz there are no numbers

        password = "JacksonMabso%";
        Expected = String.valueOf(true);
        Actual = String.valueOf(Password.checkMinimumReq(password));

        assertEquals(Expected, Actual);
        assertTrue(Boolean.parseBoolean(Actual));


        // error 'coz there is no lower case characters

        password = "JacksonMabso%45".toUpperCase();
        Expected = String.valueOf(true);
        Actual = String.valueOf(Password.checkMinimumReq(password));

        assertEquals(Expected, Actual);
        assertTrue(Boolean.parseBoolean(Actual));


        // error 'coz there is password is less than 6 chars

        password = "Jason";
        Expected = String.valueOf(true);
        Actual = String.valueOf(Password.checkMinimumReq(password));

        assertEquals(Expected, Actual);
        assertTrue(Boolean.parseBoolean(Actual));
    }

}
