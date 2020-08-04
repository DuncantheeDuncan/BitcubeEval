package assessmentproject.section1.regpage;

public class PasswordProcessor extends Password {

    public  String salt;
    public  String securePassword;
    public String password(String password) {

        boolean hasError = Password.checkMinimumReq(password);
        if (!hasError) {

            this.salt  = Password.getSalt(20);
            this.securePassword = Password.generateSecurePassword(password, salt);
            return securePassword;
        }
        throw new AssertionError("Error double check your password please");
    }
}
