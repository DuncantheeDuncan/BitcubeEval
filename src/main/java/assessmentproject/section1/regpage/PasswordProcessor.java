package assessmentproject.section1.regpage;

public class PasswordProcessor extends Password {

    public String password(String password) {

        boolean hasError = Password.checkMinimumReq(password);

        if (!hasError) {

            String salt = Password.getSalt(20);
            String SecurePassword = Password.generateSecurePassword(password, salt);

            return SecurePassword;
        }
        throw new AssertionError("Error double check your password please");
    }
}
