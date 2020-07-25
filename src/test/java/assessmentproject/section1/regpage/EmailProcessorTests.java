package assessmentproject.section1.regpage;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmailProcessorTests {

    String Expected;
    String Actual;
    String name;
    String gmail = "@gmail.com";
    String yahoo = "@yahoo.com";
    String mac = "@mac.com";

    @DisplayName("adding emails")
    @Test
    public void addingEmails() {

        EmailProcessor email = new EmailProcessor();
        Email em = new Email();

        // should throw an Error

        name = "phum@lani@gm.com";
        Actual = email.addEmail(name);
        Expected = "email cannot contain two or more of '@' in your username";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        // check if email exists

        name = "jack".concat(gmail);
        email.addEmail(name);
        email.addEmail(name);
        Actual = email.addEmail(name);
        Expected = "email already exists jack@gmail.com";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));


        // ignoring caps

        name = "joseph".concat(mac);

        email.addEmail("Joseph".concat(mac));
        email.addEmail("JOSEPH".concat(mac));
        email.addEmail("JOsEpH".concat(mac));

        Actual = email.addEmail(name);
        Expected = "email already exists joseph@mac.com";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        // checking how many '@' are there
        name = "sa@mson";
        Actual = email.addEmail(name.concat(gmail));
        Expected = "email cannot contain two or more of '@' in your username";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        // minimum characters is 3 otherwise it must fail

        name = "@samsomlook.com";
        Actual = email.addEmail(name);
        Expected = "email is too short";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        name = "sa@look.com";
        Actual = email.addEmail(name);
        Expected = "email is too short";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));

        // must have '@'

        name = "samsonlook.com";
        Actual = email.addEmail(name);
        Expected = "email must have '@'";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));


        // this email has all requirements

        name = "samson@look.com";
        Actual = email.addEmail(name);
        Expected = "samson@look.com";

        assertEquals(Expected, Actual);
        assertTrue(Expected.contains(Actual));
    }
}
