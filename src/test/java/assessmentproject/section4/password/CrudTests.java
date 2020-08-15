package assessmentproject.section4.password;

import assessmentproject.section1.regpage.PasswordProcessor;
import assessmentproject.section2.loginpage.LogIn;
import assessmentproject.web.WebProcessor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class CrudTests {

    private String providedPassword;
    private String email;
    private String salt;
    private String securedPassword;
    private String newPassword;
    private String oldPassword;
    private LogIn expectedMessage;
    private LogIn actualMessage;


    @DisplayName("should update password")
    @Test
    public void updatePassword() {
        Crud crud = new Crud();
        PasswordProcessor passwordProcessor = new PasswordProcessor();

        /*
         * fist we add password so we can update it later
         * */

        email = "xulu@bmw.kzn";
        providedPassword = "Q1q!asim";
        securedPassword = passwordProcessor.password(providedPassword);
        salt = passwordProcessor.salt;

        LogIn userPassword = new LogIn(email, providedPassword, securedPassword, salt);
        WebProcessor.myPasswords.put(email, userPassword);


        /*
         * now we can start updating the password
         * */

        newPassword = "asimQ1q!";
        oldPassword = providedPassword;

        actualMessage = userPassword;
        expectedMessage = crud.update(email, oldPassword, newPassword);

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessage.getClass(), actualMessage.getClass());




        /*
         * fist we add password so we can update it later
         * */

        email = "Mike.steve@gbuck.uk";
        providedPassword = "MJkl27%!";
        securedPassword = passwordProcessor.password(providedPassword);
        salt = passwordProcessor.salt;

        LogIn userPassword2 = new LogIn(email, providedPassword, securedPassword, salt);
        WebProcessor.myPasswords.put(email, userPassword2);


        /*
         * now we can start updating the password
         * */

        newPassword = "newPass123!@";
        oldPassword = providedPassword;


        actualMessage = userPassword2;
        expectedMessage = crud.update(email, oldPassword, newPassword);

        assertEquals(expectedMessage, actualMessage);
        assertEquals(expectedMessage.getClass(), actualMessage.getClass());


    }
}
