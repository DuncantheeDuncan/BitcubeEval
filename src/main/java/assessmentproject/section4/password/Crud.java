package assessmentproject.section4.password;

import assessmentproject.section1.regpage.PasswordProcessor;
import assessmentproject.section2.loginpage.LogIn;
import assessmentproject.section2.loginpage.VerifyUserPassword;

import static assessmentproject.web.WebProcessor.myPasswords;

public class Crud {

    public LogIn update(String email, String oldPassword, String newPassword) {

        PasswordProcessor passwordProcessor = new PasswordProcessor();

        LogIn updatePassword = myPasswords.get(email);


        boolean isPassMatch = VerifyUserPassword.verifyUserPassword(oldPassword, updatePassword.securedPassword, updatePassword.salt);

        if (isPassMatch) {

            if (oldPassword != null) {

                updatePassword.securedPassword = passwordProcessor.password(newPassword);
                updatePassword.providedPassword = newPassword;
                updatePassword.salt = passwordProcessor.salt;

                isPassMatch = VerifyUserPassword.verifyUserPassword(newPassword, passwordProcessor.password(newPassword), passwordProcessor.salt);

                if (!isPassMatch)
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }

        return updatePassword;
    }
}
