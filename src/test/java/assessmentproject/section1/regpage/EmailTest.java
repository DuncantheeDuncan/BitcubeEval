package assessmentproject.section1.regpage;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EmailTest {

    String Expected;
    String Actual;
    String name;
    String gmail = "@gmail.com";
    String yahoo = "@yahoo.com";
    String mac = "@mac.com";


    @DisplayName("should return all unique emails")
    @Test
    public void makingEmailUnique() {

        Email email = new Email();

        // checking if we getting what we entered.

        name = "phumlani".concat(gmail);
        Actual = email.makeEmailUnique(name);
        Expected = "phumlani@gmail.com";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));


        // ignoring caps and keeping the count

        Email.emailHashSet.clear();
        name = "joseph".concat(mac);
        email.makeEmailUnique("Joseph".concat(mac));
        email.makeEmailUnique("JOSEPH".concat(mac));
        email.makeEmailUnique("JOsEpH".concat(mac));

        Actual = String.valueOf(email.count());
        Expected = "1";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));
    }

    @DisplayName("should increment the count when same emails with different domains")
    @Test
    public void shouldIncrementAllEmailsWithDifferentDomains() {

        Email email = new Email();

        // should pass entering same emails with different domains

        name = "micheal";
        email.makeEmailUnique(name.concat(gmail));
        email.makeEmailUnique(name.concat(gmail).toUpperCase());
        email.makeEmailUnique(name.concat(yahoo));
        email.makeEmailUnique(name.concat(mac));
        email.makeEmailUnique(name.concat("@gov.za"));
        email.makeEmailUnique(name.concat("@me.co.uk"));
        email.makeEmailUnique(name.concat("@bitcube.tech"));

        Actual = String.valueOf(email.count());
        Expected = "6";


        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

    }

    @DisplayName("validating the email address")
    @Test
    public void validating() {

        Email email = new Email();

        // checking how many '@' are there

        name = "sa@mson";
        Actual = email.validation(name.concat(gmail));
        Expected = "Error: email cannot contain two or more of '@' in your username";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));


        // minimum characters is 3 otherwise it must fail

        name = "@samsomlook.com";
        Actual = email.validation(name);
        Expected = "Error: email is too short";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        name = "sa@look.com";
        Actual = email.validation(name);
        Expected = "Error: email is too short";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        // must have '@'

        name = "samsonlook.com";
        Actual = email.validation(name);
        Expected = "Error: email must have '@'";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));


        // this email has all requirements

        name = "samson@look.com";
        Actual = email.validation(name);
        Expected = "samson@look.com";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));
    }
}
