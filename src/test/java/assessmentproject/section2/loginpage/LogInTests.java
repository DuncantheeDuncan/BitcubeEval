package assessmentproject.section2.loginpage;

import assessmentproject.section1.regpage.Email;
import assessmentproject.section1.regpage.EmailProcessor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static junit.framework.TestCase.*;

public class LogInTests {

    String email;
    String expected;
    String actual;
    String existMail;

    @DisplayName("getting the email that matches")
    @Test
    public void shouldAddGetTheEmail() {
        VerifyUserEmail logIn = new VerifyUserEmail();
        Email addEmail = new EmailProcessor();

        email = "sam@yahoo";
        actual = logIn.verifyUserEmail(email);
        expected = String.valueOf(false);

        assertEquals(expected,actual);
        assertFalse(Boolean.parseBoolean(actual));


        email = "sam@yaho@o";
        actual = logIn.verifyUserEmail(email);
        expected = "Error: email cannot contain two or more of '@' in your username";

        assertEquals(expected,actual);
        assertFalse(Boolean.parseBoolean(actual));


        email = "jabu@mac";
        existMail = addEmail.makeEmailUnique(email);

        email = "sam@yahoo";
        existMail = addEmail.makeEmailUnique(email);


        actual = logIn.verifyUserEmail(existMail);
        expected ="sam@yahoo";
        assertEquals(expected,actual);
        assertTrue(expected.contains(actual));

        actual = String.valueOf(EmailProcessor.emailHashSet.size());
        expected = "2";
        assertEquals(expected,actual);
        assertTrue(expected.contains(actual));

    }

    @DisplayName("should check if email already exist from the emails storage")
    @Test
    public void checkingIfEmailExist() {
        VerifyUserEmail logIn = new VerifyUserEmail();
        Email addEmail = new EmailProcessor();

        email = "sam@yahoo";
        existMail = addEmail.makeEmailUnique(email);

        email = "jabu@gmail";
        existMail = addEmail.makeEmailUnique(email);

        email = "jabu@mac";
        existMail = addEmail.makeEmailUnique(email);

        actual = String.valueOf(logIn.emailExist("jabu@gmail"));
        expected = String.valueOf(true);
        assertEquals(expected,actual);
        assertTrue(Boolean.parseBoolean(actual));

        actual = String.valueOf(logIn.emailExist("Lunga@gmail"));
        expected = String.valueOf(false);
        assertEquals(expected,actual);
        assertFalse(Boolean.parseBoolean(actual));

    }
}
