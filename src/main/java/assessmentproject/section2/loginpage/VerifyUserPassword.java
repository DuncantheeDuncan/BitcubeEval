package assessmentproject.section2.loginpage;

import assessmentproject.section1.regpage.PasswordProcessor;

public class VerifyUserPassword extends PasswordProcessor {

    static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {

        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        return newSecurePassword.equalsIgnoreCase(securedPassword);
    }


}
